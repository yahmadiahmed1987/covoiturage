package com.entreprise.capita.conf;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutContainer {
	
	@Pointcut("execution(* com.entreprise.capita.repository.*.findBy*(..))") 
	public void repoProductFind() {}

	@Pointcut("execution(* com.entreprise.capita.service.*.getProductBy*(..))") 
	public void serviceProductFind() {}

}
