package com.peng.experiments.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * created by guoqingpeng on 2019/4/16
 */
@RefreshScope
@Component
@Data
public class Rereshable {
    @Value("${name}")
    private String name;
}
