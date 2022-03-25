package com.comin.claudinei.calculator.rest.service.impl;

import com.comin.claudinei.calculator.rest.CalculatorRestApplication;
import com.comin.claudinei.calculator.rest.service.ICalculatorService;
import com.comin.claudinei.calculator.rest.service.IRabbitMqReceiverService;
import com.comin.claudinei.calculator.rest.service.IRabbitMqSendService;
import com.comin.claudinei.core.ObjectMapperUtils;
import com.comin.claudinei.core.model.ResultModel;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqReceiverService implements IRabbitMqReceiverService, RabbitListenerConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiverService.class);

    @Autowired
    private ICalculatorService calculatorService;

    @Autowired
    private IRabbitMqSendService rabbitMqSendService;

    @SneakyThrows
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.listen}")
    public void receiveMessage(ResultModel resultModel) {
        logger.info("Received queue data: " + ObjectMapperUtils.getInstance().writeValueAsString(resultModel));
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {}

}
