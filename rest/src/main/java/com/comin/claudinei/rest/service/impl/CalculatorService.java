package com.comin.claudinei.rest.service.impl;

import com.comin.claudinei.rest.model.CalcSendModel;
import com.comin.claudinei.rest.service.ICalculatorService;
import com.comin.claudinei.rest.service.IRabbitMqSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "calculatorService")
public class CalculatorService implements ICalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    @Autowired
    private IRabbitMqSendService rabbitMqSendService;

    @Value("${arbitrary.precission}")
    private Integer arbitraryPrecission;

    @Value("${number.scale}")
    public Integer scaleConfig;

    @Override
    public CalcSendModel executeCalc(Double a, Double b, String operator) throws Exception {
        return executeCalc(a, b, operator, 4);
    }

    @Override
    public CalcSendModel executeCalc(Double a, Double b, String operator, Integer methodRound) throws Exception {
        logger.info("Prepare to send to queue.");

        if (methodRound == null) {
            methodRound = arbitraryPrecission;
        }

        CalcSendModel calcSendModel = CalcSendModel
                .builder()
                .uuid(String.valueOf(UUID.randomUUID()))
                .valueA(a)
                .valueB(b)
                .operator(operator)
                .methodRound(methodRound)
                .scale(scaleConfig)
                .build();

        rabbitMqSendService.send(calcSendModel);

        return calcSendModel;
    }
}
