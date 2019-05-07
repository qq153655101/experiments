package com.peng.experiments.web.common;

import com.peng.experiments.config.Rereshable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/5/7
 */
@RestController
@RequestMapping(value = "springconfig")
@Slf4j
public class SpringConfigController {

    @Autowired
    private Rereshable rereshable;

    @GetMapping
    public String getConfig(){
        return rereshable.getName();
    }
}
