package com.agreggio.challenge.slingr.math.web.model.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {


    private String userName;

    private String firstName;

    private String lastName;


}
