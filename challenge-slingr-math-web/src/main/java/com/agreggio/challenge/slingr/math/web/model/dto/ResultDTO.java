package com.agreggio.challenge.slingr.math.web.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
public class ResultDTO {

    private String expression;
    private int precision;
    private Double result;

}
