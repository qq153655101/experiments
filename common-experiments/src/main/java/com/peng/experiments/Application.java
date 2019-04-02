package com.peng.experiments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2018/11/17
 */
@SpringBootApplication //(exclude = {DataSourceConnectionSource.class})
@RestController
@Slf4j
public class Application {

    @GetMapping("/alive")
    public String test(){
        log.info("server is alive");
        return "i'm alive!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("【peng-experiments 自动成功】");
    }

}
