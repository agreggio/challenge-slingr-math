package com.agreggio.challenge.slingr.math.web.controller;


import com.agreggio.challenge.slingr.math.web.model.dto.ExpressionDTO;
import com.agreggio.challenge.slingr.math.web.model.dto.JwtDTO;
import com.agreggio.challenge.slingr.math.web.model.dto.ResultDTO;
import com.agreggio.challenge.slingr.math.web.service.ExpressionService;
import com.agreggio.challenge.slingr.math.web.service.SecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptException;
import java.util.Map;

import static com.agreggio.challenge.slingr.math.web.utils.JwtUtil.getJWTtoHeader;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/expressions")
@Slf4j
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ModelMapper modelMapper;


    @ApiOperation(value = "Expression to be evaluated", produces = APPLICATION_JSON_VALUE)
    @GetMapping(produces = "application/json")
    public ResponseEntity getResolveExpression(@RequestParam() String expression,
                                               @RequestParam(defaultValue = "0", required = false) int precision,
                                               @ApiParam(value = "apiHeader", hidden = true)
                                                          @RequestHeader Map<String, String> apiHeader) throws ScriptException {


        log.info("Expression {} with precision {} to be evaluated", expression, precision);

        ResultDTO resultDTO = modelMapper.map(expressionService.evaluate(expression, precision), ResultDTO.class);

        try {

            JwtDTO jwt = getJWTtoHeader(apiHeader);
            resultDTO.setUserDTO(securityService.getUserByUserName(jwt));

        } catch (JsonProcessingException e) {

            return new ResponseEntity(resultDTO, HttpStatus.PARTIAL_CONTENT);
        }


        return new ResponseEntity(resultDTO, HttpStatus.OK);
    }



    @ApiOperation(value = "Expression to be evaluated", produces = APPLICATION_JSON_VALUE)
    @PostMapping(produces = "application/json")
    public ResponseEntity<ResultDTO> postResolveExpression(@RequestBody ExpressionDTO expressionDTO) throws ScriptException {

        log.info("Expression {} with precision {} to be evaluated", expressionDTO.getExpression(), expressionDTO.getPrecision());

        Validate.notBlank(expressionDTO.getExpression(),"Expression can't no be null or empty");
        Validate.validState(expressionDTO.getPrecision() >= 0,"Precision can't no be null or empty");

        ResultDTO resultDTO = modelMapper.map(expressionService.evaluate(expressionDTO.getExpression(), expressionDTO.getPrecision()), ResultDTO.class);

        return ResponseEntity.ok(resultDTO);
    }


}
