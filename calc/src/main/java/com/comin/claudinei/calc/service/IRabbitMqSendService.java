package com.comin.claudinei.calc.service;

import com.comin.claudinei.calc.model.ResultModel;

public interface IRabbitMqSendService {
    public void send(ResultModel resultModel);
}
