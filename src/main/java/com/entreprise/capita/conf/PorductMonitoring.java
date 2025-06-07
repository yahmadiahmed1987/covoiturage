package com.entreprise.capita.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PorductMonitoring {

	private final Logger logger = LoggerFactory.getLogger(PorductMonitoring.class);
	
	@Before("com.entreprise.capita.conf.PointCutContainer.repoProductFind()|| com.entreprise.capita.conf.PointCutContainer.serviceProductFind()")
	
	public void beforeProductFind(JoinPoint joinPoint) {
		String classeName = joinPoint.getSignature().getDeclaringTypeName();
		String methodeName = joinPoint.getSignature().getName();
		
		logger.info("---> Product Methode name: "+ classeName+ "."+methodeName+ " is reunning now");
	}
}
