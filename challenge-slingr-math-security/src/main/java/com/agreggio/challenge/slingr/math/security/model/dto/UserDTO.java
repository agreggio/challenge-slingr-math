package com.agreggio.challenge.slingr.math.security.model.dto;


import com.agreggio.challenge.slingr.math.security.model.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserDTO {


    private Long id;

    private String firstName;

    private String userName;

    private String lastName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


}
