package com.aop.aop.configuration;

import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    
    @Before(value = "execution(* com.aop.aop.service.ServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("Before Advice");
    }

    @After(value = "execution(* com.aop.aop.service.ServiceImpl.*(..))")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("After Advice");
    }

    // This will be called if uncommented which take precedence on before, before returning and after
    // @Around(value = "execution(* com.aop.aop.service.ServiceImpl.*(..))")
    // public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
    //     System.out.println("Around Advice");
    // }

    @AfterReturning(value = "execution(* com.aop.aop.service.ServiceImpl.*(..))", returning = "ret")
    public void arAdvice(JoinPoint jp, Object ret) {
        System.out.println("After Returning Advice : " + ret.toString());
    }

    @AfterThrowing(value = "execution(* com.aop.aop.service.ServiceImpl.*(..))", throwing = "error")
    public void atAdvice(JoinPoint jp, Throwable error) {
        System.out.println("After Throwing Advice : " + error.getMessage());
    }

}
