package com.peng.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/4/7
 */
@RestController
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableDiscoveryClient
@Slf4j
public class EurekaConfigApplication {

    @GetMapping("/alive")
    public String test(){
        log.info("server is alive");
        return "config-server is alive!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class,args);
        log.info("【config-server 启动成功】");
    }
}
