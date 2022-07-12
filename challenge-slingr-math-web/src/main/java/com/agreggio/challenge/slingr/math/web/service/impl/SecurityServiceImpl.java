package com.agreggio.challenge.slingr.math.web.service.impl;

import com.agreggio.challenge.slingr.math.web.model.dto.JwtDTO;
import com.agreggio.challenge.slingr.math.web.model.dto.UserDTO;
import com.agreggio.challenge.slingr.math.web.service.SecurityService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final WebClient client;


    public SecurityServiceImpl(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8088").build();
    }



    @Override
    public UserDTO getUserByUserName(JwtDTO jwtDTO) {

        return this.client.get().uri("/users/" + jwtDTO.getSub())
                .header("Authorization", jwtDTO.getJwt())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UserDTO.class).block();
    }
}
