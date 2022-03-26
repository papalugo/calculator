package com.comin.claudinei.rest.service;


import com.comin.claudinei.rest.model.ResultModel;

public interface IRabbitMqReceiverService {
    public void receiveMessage(ResultModel resultModel);
}
