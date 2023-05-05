package com.boot.batis.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/************
 * @info : Action Mapping Annotation define Class
 * @name : Action
 * @date : 2023/05/05 10:00 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Aspect
@Component
@Slf4j
public class Action {

    // Annotation Location
    @Pointcut("@annotation(com.boot.batis.config.aop.annotations.ActionMapping)")
    public void enableActions(){}

    // Target Package -> Project Global Setting(parameter 0~)
    @Pointcut("execution(* com.boot.batis..*.*(..))")
    public void cut() {}


    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        // Parameter
        Object[] args = joinPoint.getArgs();

        // Method
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        Method method = ms.getMethod();

        // Flag - if args is exist logs
        if(args.length > 0) {
            log.info("RUN METHOD NAME = {}", method.getName());
            log.info("  -> {} PARAMETERS = {}",method.getName(), Arrays.toString(args));
        }else {
            log.info("RUN METHOD NAME = {}", method.getName());
        }

    }
}
