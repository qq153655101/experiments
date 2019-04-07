package com.peng.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/4/7
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
@Slf4j
public class EurekaServerApplication {

    @GetMapping("/alive")
    public String test(){
        log.info("server is alive");
        return "eureka-server is alive!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
        log.info("【eureka-server 启动成功】");
    }
}
