package com.agreggio.challenge.slingr.math.web.service;

import com.agreggio.challenge.slingr.math.web.model.Result;

import javax.script.ScriptException;

public interface ExpressionService {

    Result evaluate(String expression, int precision) throws ScriptException;


}
