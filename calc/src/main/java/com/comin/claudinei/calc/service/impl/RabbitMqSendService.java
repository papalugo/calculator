package com.comin.claudinei.calc.service.impl;

import com.comin.claudinei.calc.ObjectMapperUtils;
import com.comin.claudinei.calc.model.ResultModel;
import com.comin.claudinei.calc.service.IRabbitMqSendService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "rabbitMqSendService")
public class RabbitMqSendService implements IRabbitMqSendService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSendService.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSendService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey.send}")
    private String routingkeySend;

    @SneakyThrows
    @Override
    public void send(ResultModel resultModel) {
        logger.info("Send to rabbitmq: " + exchange + " " + routingkeySend + " " + ObjectMapperUtils.getInstance().writeValueAsString(resultModel));
        rabbitTemplate.convertAndSend(exchange, routingkeySend, resultModel);
    }
}