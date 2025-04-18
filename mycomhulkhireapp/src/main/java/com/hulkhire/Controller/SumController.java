package com.hulkhire.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hulkhire.Pojo.Addreq;
import com.hulkhire.Service.CalculatorService;

@RestController
@RequestMapping("/api")
public class SumController {

    private static final Logger logger = LoggerFactory.getLogger(SumController.class);

    private final CalculatorService calculatorService;

    @Autowired
    public SumController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        logger.info("SumController initialized with CalculatorService");
    }

    @PostMapping("/sum")
    public int getSum(@RequestBody Addreq addreq) {
        logger.info("Received request to add numbers: a = {}, b = {}", addreq.getA(), addreq.getB());
        int sum = calculatorService.addnumbers(addreq);
        logger.info("Sum result: {}", sum);
        return sum;
    }
}
