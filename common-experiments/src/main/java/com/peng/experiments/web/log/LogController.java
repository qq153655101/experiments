package com.peng.experiments.web.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/4/6
 */
@Slf4j
@RestController
@RequestMapping(value = "/log")
public class LogController {
    @GetMapping
    public String testLog(String params){
        log.info("log test info：{}",params);
        log.error("log test error：{}",params);
        return params;
    }
}
