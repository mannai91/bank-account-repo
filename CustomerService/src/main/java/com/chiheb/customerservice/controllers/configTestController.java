package com.chiheb.customerservice.controllers;

import com.chiheb.customerservice.config.GlobalConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class configTestController {

    @Autowired
    private GlobalConfig  globalConfig;
   @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
       return globalConfig;
   }


}
