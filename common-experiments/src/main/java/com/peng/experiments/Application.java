package com.peng.experiments;

import com.peng.web.exception.ErrorResultRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2018/11/17
 */
@SpringBootApplication //(exclude = {DataSourceConnectionSource.class})
@RestController
@ComponentScan(basePackages = {"com.peng.*"})
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
        log.info("错误容器内注册的全部异常信息:{}", ErrorResultRegistry.REGISTRY);
    }

}
