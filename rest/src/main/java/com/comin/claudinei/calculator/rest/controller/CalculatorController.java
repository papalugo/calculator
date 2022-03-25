package com.comin.claudinei.calculator.rest.controller;

import com.comin.claudinei.calculator.rest.CalculatorRestApplication;
import com.comin.claudinei.calculator.rest.service.ICalculatorService;
import com.comin.claudinei.core.model.CalcSendModel;
import com.comin.claudinei.core.model.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("${server.api.path}/calc")
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getSum(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b, @RequestParam(required = false, value = "methodRound") Integer methodRound) {
        ResultModel resultModel = new ResultModel();
        try {
            logger.info("Request to SUM...");
            CalcSendModel calcSendModel = calculatorService.executeCalc(a, b, "+", methodRound);
            return ResponseEntity.ok(getReturnOK(resultModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(getReturnError(resultModel, e));
        }
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getSubtract(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b, @RequestParam(required = false, value = "methodRound") Integer methodRound) {
        ResultModel resultModel = new ResultModel();
        try {
            logger.info("Request to SUBTRACT...");
            CalcSendModel calcSendModel = calculatorService.executeCalc(a, b, "-");
            return ResponseEntity.ok(getReturnOK(resultModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(getReturnError(resultModel, e));
        }
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getDivide(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b, @RequestParam(required = false, value = "methodRound") Integer methodRound) {
        ResultModel resultModel = new ResultModel();
        try {
            logger.info("Request to DEVIDE...");
            CalcSendModel calcSendModel = calculatorService.executeCalc(a, b, "/", methodRound);
            return ResponseEntity.ok(getReturnOK(resultModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(getReturnError(resultModel, e));
        }
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getMultiply(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b, @RequestParam(required = false, value = "methodRound") Integer methodRound) {
        ResultModel resultModel = new ResultModel();
        try {
            logger.info("Request to MULTIPLY...");
            CalcSendModel calcSendModel = calculatorService.executeCalc(a, b, "*");
            return ResponseEntity.ok(getReturnOK(resultModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(getReturnError(resultModel, e));
        }
    }

    private ResultModel getReturnError(ResultModel resultModel, Exception e) {
        resultModel.setStatus(HttpStatus.BAD_REQUEST.value());
        resultModel.setMessage(e.getMessage());
        return resultModel;
    }

    private ResultModel getReturnOK(ResultModel resultModel) {
        resultModel.setStatus(HttpStatus.OK.value());
        return resultModel;
    }
}
