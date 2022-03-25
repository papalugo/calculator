package com.comin.claudinei.calculator.rest.service;

import com.comin.claudinei.core.model.CalcSendModel;
import com.comin.claudinei.core.model.ResultModel;

public interface ICalculatorService {
    CalcSendModel executeCalc(Double a, Double b, String operator) throws Exception;

    CalcSendModel executeCalc(Double a, Double b, String operator, Integer methodRound) throws Exception;
}
