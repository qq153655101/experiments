package com.peng.experiments.web.exception;


import com.peng.common.domain.ErrorCodeMsgEnum;
import com.peng.web.exception.ErrorResultRegistry;
import com.peng.web.exception.VerifyUtil;
import com.peng.web.exception.carrier.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by guoqingpeng on 2019/4/6
 */
@RestController
@RequestMapping(value = "exception")
@Slf4j
public class ExceptionController {

    @GetMapping(value = "/check1")
    public void testThrowException1(String params){
        log.info("错误容器内注册的全部异常信息:{}", ErrorResultRegistry.REGISTRY);
        VerifyUtil.checkNotNull(params,10001,"params");
    }

    @GetMapping(value = "/check2")
    public void testThrowException2(){
        throw new CommonException(20002);
    }

    @GetMapping(value = "/check3")
    public void testThrowException3(String params){
        throw new CommonException(99999,"自主显示异常消息");
    }

    @GetMapping(value = "/check4")
    public void testThrowException4(String params){
        VerifyUtil.checkNotNull(params, ErrorCodeMsgEnum.PARAMS_NULL.getCode(),"params");
    }

    @GetMapping(value = "/check5")
    public void testThrowException5(){
        throw new CommonException(ErrorCodeMsgEnum.PARAMS_NULL_WITHOUT_MSG.getCode());
    }

    @GetMapping(value = "/check6")
    public void testThrowException6(String params){
        throw new CommonException(ErrorCodeMsgEnum.SERVICE_ERROR.getCode(),"自主显示异常消息2");
    }

}
