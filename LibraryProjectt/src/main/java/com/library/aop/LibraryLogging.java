package com.library.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LibraryLogging {

    private static final Logger logger = Logger.getLogger(LibraryLogging.class);

    @Before("execution(* com.library.controllers..*Controller.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        logger.info("logMethodAccessBefore");
        logger.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
        logger.info("***** Arguments: " + Arrays.toString(joinPoint.getArgs()) + " *****");
    }

    @After("execution(* com.library.controllers..*Controller.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
        logger.info("logMethodAccessAfter");
        logger.info("***** Finishing: " + joinPoint.getSignature().getName() + " *****");
    }

//    @Around("execution(* com.library.controllers..*Controller.*(..))")
//    public void logMethodAccessAround(ProceedingJoinPoint joinPoint) {
//        logger.trace("Logging around the methods (Before + After )");
//    }

}
