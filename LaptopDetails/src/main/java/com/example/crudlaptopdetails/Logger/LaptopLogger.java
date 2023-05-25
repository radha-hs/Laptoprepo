package com.example.crudlaptopdetails.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LaptopLogger {
	Logger logger=LoggerFactory.getLogger(LaptopLogger.class);

	@Pointcut(value="execution(* com.example.crudlaptopdetails.*.*.*(..))")
	public void mypointcut() {
		
	}
	
	@Around("mypointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
		ObjectMapper objectmapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object array=pjp.getArgs();
		logger.info("method invoked"+className+":"+methodName+ "()" + "arguments: "+objectmapper.writeValueAsString(array));
		
		Object object=pjp.proceed();
		logger.info(className+":"+methodName+ "()" + "Response: "+objectmapper.writeValueAsString(object));
		return object;
		
	}

}
