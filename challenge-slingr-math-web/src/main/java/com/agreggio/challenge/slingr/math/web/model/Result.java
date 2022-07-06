package com.agreggio.challenge.slingr.math.web.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Result {

    private String expression;
    private Integer precision;
    private Double result;

}
