package com.agreggio.challenge.slingr.math.web.service.impl;

import com.agreggio.challenge.slingr.math.web.model.Result;
import com.agreggio.challenge.slingr.math.web.service.ExpressionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math.util.MathUtils;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Locale;

import static com.agreggio.challenge.slingr.math.web.constant.ExpressionConstant.FUNCTIONS;

@Service
@Slf4j
public class ExpressionServiceImpl implements ExpressionService {

    private final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");


    @Override
    public Result evaluate(String expression, int precision) throws ScriptException {

        expression = expression.toLowerCase(Locale.ROOT).trim();

        log.info("Evaluate expression {} with precision {}", expression, precision);

        String tmpExpression = expression;

        for (String function : FUNCTIONS) {

            expression = expression.replace(function, "Math." + function);

        }

        double result = ((Number) scriptEngine.eval(expression)).doubleValue();

        log.info("Expression result: {} ", result);

        return new Result(tmpExpression, precision, MathUtils.round(result, precision));

    }



}
