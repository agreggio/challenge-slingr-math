package com.agreggio.challenge.slingr.math.web.utils;

import com.agreggio.challenge.slingr.math.web.model.dto.JwtDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
import java.util.Map;

public class JwtUtil {


    public static JwtDTO getJWTtoHeader(Map<String, String> apiHeader) throws JsonProcessingException {

        String jwt = apiHeader.get("authorization").replace("Bearer", "").trim();

        String[] chunks = jwt.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));

        JwtDTO jwtDTO = new ObjectMapper().readValue(payload, JwtDTO.class);

        jwtDTO.setJwt("Bearer " + jwt);

        return jwtDTO;

    }



}
