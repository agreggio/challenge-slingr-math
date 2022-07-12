package com.agreggio.challenge.slingr.math.web.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Getter
@Setter
public class ExpressionDTO {

    private String expression;
    private int precision;

}
