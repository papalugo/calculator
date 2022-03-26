package com.comin.claudinei.calc.service;


import com.comin.claudinei.calc.model.CalcSendModel;
import com.comin.claudinei.calc.model.ResultModel;
import org.springframework.stereotype.Component;

@Component
public interface ICalculatorService {
    ResultModel executeCalc(Double a, Double b, String operator) throws Exception;

    ResultModel executeCalc(Double a, Double b, String operator, Integer methodRound) throws Exception;

    ResultModel executeCalc(CalcSendModel calcSendModel) throws Exception;
}
