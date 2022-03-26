package com.comin.claudinei.rest.service;

import com.comin.claudinei.rest.model.CalcSendModel;

public interface IRabbitMqSendService {
    public void send(CalcSendModel calcSendModel);
}
