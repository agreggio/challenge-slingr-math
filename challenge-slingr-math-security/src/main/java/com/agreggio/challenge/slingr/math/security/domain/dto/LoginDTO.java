package com.agreggio.challenge.slingr.math.security.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
@Builder
public class LoginDTO {

    @JsonProperty("username")
    @ApiModelProperty(required = true)
    private String username;

    @JsonProperty("pwd")
    @ApiModelProperty(required = true)
    private String password;

    @JsonProperty("token")
    @ApiModelProperty(hidden = true)
    private String token;

}
