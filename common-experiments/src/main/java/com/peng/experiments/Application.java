package com.peng.experiments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2018/11/17
 */
@SpringBootApplication //(exclude = {DataSourceConnectionSource.class})
@RestController
public class Application {

    public static void main(String[] args) { SpringApplication.run(Application.class,args); }

    @GetMapping("/test")
    public String test(){
        return "hello word";
    }
}
