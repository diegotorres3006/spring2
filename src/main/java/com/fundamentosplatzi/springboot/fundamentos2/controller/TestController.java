package com.fundamentosplatzi.springboot.fundamentos2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private final Log LOGGER = LogFactory.getLog(TestController.class);

    @RequestMapping("/")
    @ResponseBody

    public ResponseEntity<String> function(){

        return new ResponseEntity<>("Hello from controller", HttpStatus.OK);

    }

}
