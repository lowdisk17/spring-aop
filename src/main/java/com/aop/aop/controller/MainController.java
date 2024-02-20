package com.aop.aop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aop.aop.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("base")
public class MainController {

    @Autowired
    private ServiceImpl serviceImpl;
    
    @GetMapping("service")
    public String getMethodName() {
        serviceImpl.getData();
        return "Success";
    }
    
}
