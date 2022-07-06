package com.agreggio.challenge.slingr.math.security.component;



import com.agreggio.challenge.slingr.math.common.contant.JwtConstant;
import com.agreggio.challenge.slingr.math.security.model.entity.Login;
import com.agreggio.challenge.slingr.math.security.model.entity.User;
import com.agreggio.challenge.slingr.math.security.model.enums.UserRole;
import com.agreggio.challenge.slingr.math.security.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class LoginComponent {
    
    @Autowired
    private UserService userService;

    
    public Login getLogin(Login login)  {

        log.info("Get login");

        User user = userService.findUser(login.getUsername(), login.getPassword());

        login.setUsername(login.getUsername());
        login.setToken(getJWTToken(user.getUserName(), user.getUserRole()));
        login.setPassword(null);

    return login;

    }


    private String getJWTToken(String username, UserRole userRole) {

        log.info("Get JWT Token");

        String secretKey = JwtConstant.SECRET;
        List<GrantedAuthority> grantedAuthorities;

        grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(userRole.name());


        String token = Jwts
                .builder()
                .setId("slingrJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return JwtConstant.PREFIX + token;
    }

}
