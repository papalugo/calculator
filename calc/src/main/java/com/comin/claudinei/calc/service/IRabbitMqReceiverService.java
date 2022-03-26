package com.comin.claudinei.calc.service;

import com.comin.claudinei.calc.model.CalcSendModel;

public interface IRabbitMqReceiverService {
    public void receiveMessage(CalcSendModel calcSendModel);
}
