package com.kou.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author JIAJUN KOU
 *
 * 用于记录日志的工具类：里边有公共的代码
 */
@Component("logger")
@Aspect //表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.kou.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 前置通知
     * 用于打印日志，让其在切入点方法执行之前执行
     * （切入点方法就是业务层方法）
     */
   // @Before("pt1()")
    public void beforeprintLog(){
        System.out.println("前置通知。。。。。。");
    }

    /**
     * 后置通知
     */
    //@AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知。。。。。。");
    }

    /**
     * 异常通知
     */
   // @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知。。。。。。");
    }

    /**
     * 最终通知
     */
    //@After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知。。。。。。");
    }

    /**
     * 环绕通知
     *     spring框架为我们提供了一个接口 ProceedingJoinPoint 该接口明确切入点方法。
     *
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try{
            //得到方法执行所需的参数
            Object[] args=pjp.getArgs();
            System.out.println("around执行了。。。。。。前置");
            //明确调用业务层方法
            rtValue=pjp.proceed(args);

            System.out.println("around执行了。。。。。。后置");

            return rtValue;

        }catch (Throwable t){
            System.out.println("around执行了。。。。。。异常");

            throw new RuntimeException(t);
        }finally {
            System.out.println("around执行了。。。。。。最终");

        }

    }
}
