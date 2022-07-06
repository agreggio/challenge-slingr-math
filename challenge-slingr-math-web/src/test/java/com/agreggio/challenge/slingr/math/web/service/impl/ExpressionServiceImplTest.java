package com.agreggio.challenge.slingr.math.web.service.impl;

import com.agreggio.challenge.slingr.math.web.service.ExpressionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionServiceImplTest {


    private ExpressionService expressionService;

    @BeforeEach
    void setUp() {
        expressionService = new ExpressionServiceImpl();
    }

    @Test
    void evaluate() throws ScriptException {

        Assertions.assertEquals(8, expressionService.evaluate("2*(7-3)",1).getResult());
        Assertions.assertEquals(7.8, expressionService.evaluate("1.2 * (2 + 4.5)",1).getResult());
        Assertions.assertEquals(7.942, expressionService.evaluate("1.22 * (2 + 4.51)",3).getResult());
        Assertions.assertEquals(8, expressionService.evaluate("2+3*sqrt(4)",1).getResult());
        Assertions.assertEquals(4, expressionService.evaluate("abs(-4)",1).getResult());

        assertThrows(ScriptException.class,
                ()-> expressionService.evaluate("2+3*((4)",1));

    }


}