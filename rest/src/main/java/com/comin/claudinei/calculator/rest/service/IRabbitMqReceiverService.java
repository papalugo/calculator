package com.comin.claudinei.calculator.rest.service;

import com.comin.claudinei.core.model.ResultModel;

public interface IRabbitMqReceiverService {
    public void receiveMessage(ResultModel resultModel);
}
