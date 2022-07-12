package com.agreggio.challenge.slingr.math.web.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtDTO {

    private String jti;

    private String sub;

    private List<String> authorities;

    private long iat;

    private long exp;

    private String jwt;
}
