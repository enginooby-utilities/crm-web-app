package com.cpulover.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName(), null);

	// setup pointcut declarations
	@Pointcut("execution(* com.cpulover.springdemo.controller.*.*(..))")
	public void forController() {
	}

	@Pointcut("execution(* com.cpulover.springdemo.dao.*.*(..))")
	public void forDao() {
	}

	@Pointcut("execution(* com.cpulover.springdemo.service.*.*(..))")
	public void forService() {
	}

	@Pointcut("forController() || forDao() || forService()")
	public void appFlow() {
	}

	// add advices
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		// display the calling method
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("In @Before: calling method " + method);

		// get the args
		Object[] args = joinPoint.getArgs();
		// display the args
		for (Object arg : args) {
			myLogger.info(">>> Params: " + arg);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "appFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info(">>> in @AfterReturning: from method: " + theMethod);

		// display data returned
		myLogger.info(">>> result: " + theResult);

	}
}
