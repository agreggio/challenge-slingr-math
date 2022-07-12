package com.agreggio.challenge.slingr.math.web.service;

import com.agreggio.challenge.slingr.math.web.model.Result;

import javax.script.ScriptException;

public interface ExpressionService {


    /**
     * Return the result of evaluating the expression.
     *
     * @param expression {@link String}
     * @param precision {@link int}
     *
     * @return {@link Result}
     *
     * @throws ScriptException
     */
    Result evaluate(String expression, int precision) throws ScriptException;


}
