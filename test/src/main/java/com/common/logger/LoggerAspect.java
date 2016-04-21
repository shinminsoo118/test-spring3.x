package com.common.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {
	protected Log log = LogFactory.getLog(LoggerAspect.class);
	static String name = "";
	static String type = "";
	
	@Around("execution(* com..controller.*Controller.*(..)) or execution(* com..service.*Impl.*(..)) or execution(* com..dao.*DAO.*(..))")
	public Object logAroundPrint(ProceedingJoinPoint joinPoint)throws Throwable{
		type = joinPoint.getSignature().getDeclaringTypeName();
		
		if(type.indexOf("Controller") > -1){
			name = "@Around Controller \t:	";
		}else if(type.indexOf("Service") > -1){
			name = "@Around ServiceImpl \t:	";
		}else if(type.indexOf("DAO") > -1){
			name = "@Around DAO \t:	";
		}
		
		log.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}
	
//	@Before("execution(* com..controller.*Controller.*(..)) or execution(* com..service.*Impl.*(..))")
//	public Object logBeforePrint(JoinPoint thisJoinPoint)throws Throwable{
//		type = thisJoinPoint.getSignature().getDeclaringTypeName();
//		
//		if(type.indexOf("Controller") > -1){
//			name = "@Before Controller \t:	";
//		}else if(type.indexOf("Service") > -1){
//			name = "@Before ServiceImpl \t:	";
//		}else if(type.indexOf("DAO") > -1){
//			name = "@Before DAO \t:	";
//		}
//		
//		log.debug(name + type + "." + thisJoinPoint.getSignature().getName() + "()");
//		return thisJoinPoint.getTarget();
//	}
}
