package com.comin.claudinei.calc.service.impl;

import com.comin.claudinei.calc.ObjectMapperUtils;
import com.comin.claudinei.calc.model.CalcSendModel;
import com.comin.claudinei.calc.model.ResultModel;
import com.comin.claudinei.calc.service.ICalculatorService;
import com.comin.claudinei.calc.service.IRabbitMqReceiverService;
import com.comin.claudinei.calc.service.IRabbitMqSendService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void receiveMessage(CalcSendModel calcSendModel) {
        logger.info("Received queue data: " + ObjectMapperUtils.getInstance().writeValueAsString(calcSendModel));
        ResultModel resultModel = new ResultModel();
        if (calcSendModel != null && calcSendModel.valueA != null && calcSendModel.valueB != null && calcSendModel.operator != null) {
            try {
                resultModel = calculatorService.executeCalc(calcSendModel);
                resultModel.setStatus(HttpStatus.OK.value());
            } catch (Exception e) {
                e.printStackTrace();
                resultModel.setStatus(HttpStatus.BAD_REQUEST.value());
                resultModel.setMessage(e.getMessage());
            }
        } else {
            logger.info("Invalid parameters!");
            resultModel.setStatus(HttpStatus.BAD_REQUEST.value());
            resultModel.setMessage("Invalid Parameters!");
        }

        rabbitMqSendService.send(resultModel);
        logger.info("End queue processor.");
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

}
