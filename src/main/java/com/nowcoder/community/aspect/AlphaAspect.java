package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

//@Component
//@Aspect
public class AlphaAspect {
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("before proceed");
        Object proceed = joinPoint.proceed();
        System.out.println("after proceed");
        return proceed;
    }
}
