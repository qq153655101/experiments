package com.peng.experiments;

import com.peng.experiments.config.Rereshable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created by guoqingpeng on 2018/11/17
 */
@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.peng.experiments.*","com.peng.common.*"})
@EnableEurekaClient
@Slf4j
public class Application {



    @GetMapping("/alive")
    public String test(){
        log.info("server is alive");
        return "I'm alive!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("【peng-experiments 启动成功】");
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
