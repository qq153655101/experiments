package com.peng.data.mysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/4/7
 */
@SpringBootApplication //(exclude = {DataSourceConnectionSource.class})
@RestController
@Slf4j
public class MysqlProvidersAppliction {

    public static void main(String[] args) {
        SpringApplication.run(MysqlProvidersAppliction.class,args);
        log.info("【data-layer-server 启动成功】");
    }

    @GetMapping("/alive")
    public String test(){
        log.info("server is alive");
        return "data-layer-server is alive!";
    }
}
