package com.agreggio.challenge.slingr.math.security.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
@Builder
public class Login {

    @JsonProperty(value = "user_name")
    private String username;

    @JsonProperty(value = "password")
    private String password;


    @JsonProperty(value = "token")
    @ApiModelProperty(hidden = true)
    private String token;

}
