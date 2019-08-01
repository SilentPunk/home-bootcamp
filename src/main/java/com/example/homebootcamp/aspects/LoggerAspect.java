package com.example.homebootcamp.aspects;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggerAspect {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.homebootcamp.controllers.*.*(..)) && args(request, ..)")
    public void log(HttpServletRequest request){};

    @Around("log(request)")
    public Object logBeforeController(ProceedingJoinPoint proceedingJoinPoint, HttpServletRequest request) throws Throwable{
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        String controllerName = StringUtils.substringAfterLast(className, ".");
        logger.info(String.format("Incoming %s request for %s controller", request.getMethod() , controllerName));
        Object output = proceedingJoinPoint.proceed();
        logger.info(String.format("%s controller returns %s", controllerName, output.toString()));
        return output;
    }

}
