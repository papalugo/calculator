package com.comin.claudinei.rest.service;

import com.comin.claudinei.rest.model.CalcSendModel;

public interface ICalculatorService {
    CalcSendModel executeCalc(Double a, Double b, String operator) throws Exception;

    CalcSendModel executeCalc(Double a, Double b, String operator, Integer methodRound) throws Exception;
}
