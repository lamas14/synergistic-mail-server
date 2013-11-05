package com.synergistic.it.aop.advice;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //this annotation says this is an advice
public class AddMessageBeforeMethod {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(AddMessageBeforeMethod.class);
	
	@Before("execution(* com.synergistic.it.dao.impl.*.*(..))")
	public void addStatementBefore(JoinPoint joinPoint) {
		logger.debug("++++++++++++++________________________+++++++++++++++++++");
		logger.debug("Invoked methodn name is  : " + joinPoint.getSignature().getName());
		logger.debug("Method parameters : "+Arrays.asList(joinPoint.getArgs()));
	}
	
	@AfterReturning(
		      pointcut = "execution(* com.synergistic.it.dao.impl.*.*(..))",
		      returning= "result")
	public void afterStatementBefore(JoinPoint joinPoint,Object result) {
		logger.debug("result from invoked method ("+joinPoint.getSignature().getName()+")  = "+result);
		logger.debug("++++>>>>>>>>>>>>End of method  "+joinPoint.getSignature().getName()+"<<<<<<<<<<<<<<<<<<");
	}

}
