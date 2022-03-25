package com.comin.claudinei.calc.service;

import com.comin.claudinei.core.model.CalcSendModel;
import com.comin.claudinei.core.model.ResultModel;

public interface IRabbitMqReceiverService {
    public void receiveMessage(CalcSendModel calcSendModel);
}
