package com.comin.claudinei.calc.service.impl;

import com.comin.claudinei.calc.NumberUtils;
import com.comin.claudinei.calc.model.CalcSendModel;
import com.comin.claudinei.calc.model.ResultModel;
import com.comin.claudinei.calc.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.UUID;

@Service
public class CalculatorService implements ICalculatorService {

    @Value("${arbitrary.precission}")
    private Integer arbitraryPrecission;

    @Value("${number.scale}")
    public Integer scaleConfig;

    @Override
    public ResultModel executeCalc(Double a, Double b, String operator) throws Exception {
        return executeCalc(a, b, operator, 4);
    }

    @Override
    public ResultModel executeCalc(Double a, Double b, String operator, Integer methodRound) throws Exception {
        if (methodRound == null) {
            methodRound = arbitraryPrecission;
        }

        ResultModel resultModel = new ResultModel();
        Double result = 0d;
        switch (operator) {
            case "+": {
                result = a + b;
                break;
            }
            case "-": {
                result = a - b;
                break;
            }
            case "/": {
                result = a / b;
                break;
            }
            case "*": {
                result = a * b;
                break;
            }
            default: {
                throw new Exception("Invalid Operator!");
            }
        }
        CalcSendModel calcSendModel = CalcSendModel
                .builder()
                .uuid(String.valueOf(UUID.randomUUID()))
                .valueA(a)
                .valueB(b)
                .methodRound(methodRound)
                .scale(scaleConfig)
                .build();

        resultModel.setResult(new NumberUtils().formatNumber(result, RoundingMode.valueOf(methodRound), scaleConfig));
        return resultModel;
    }

    @Override
    public ResultModel executeCalc(CalcSendModel calcSendModel) throws Exception {
        return executeCalc(calcSendModel.valueA, calcSendModel.valueB, calcSendModel.operator, calcSendModel.methodRound);
    }
}
