package com.library.aop;

import com.library.controllers.LibraryController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
public class LibraryLogging {

    private static final Logger logger = Logger.getLogger(LibraryController.class);

//    @AfterReturning("execution(* com.library.domain.*(..))")
//    public void logServiceAccess(JoinPoint joinPoint){
//
//    }


//    @AfterReturning("execution(* create*(..))")
//    public void logControllerCreate(JoinPoint joinPoint){
//        System.out.println("A TUT TOJE SRABOTALO");
//        if(logger.isDebugEnabled()){
//            logger.debug("create method is executed" + joinPoint);
//            System.out.println("SRABOTALO !!!!!!!!!!");
//        }
//    }


    @After("execution(* com.library.controllers.*.createBook(..))")
    public void createMethod(){

        System.out.println("ololosh");

        logger.debug("Everything went fine");

    }



}
