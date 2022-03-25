package com.comin.claudinei.calculator.rest.service;

import com.comin.claudinei.core.model.CalcSendModel;

public interface IRabbitMqSendService {
    public void send(CalcSendModel calcSendModel);
}
