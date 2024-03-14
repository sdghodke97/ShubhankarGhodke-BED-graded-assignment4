package com.gl.employee.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.gl.employee.Entity.AuditLog;
import com.gl.employee.Entity.Employee;
import com.gl.employee.repository.AuditRepository;
import com.gl.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Aspect
public class AspectConfig {

	@Autowired
	AuditRepository auditRepository;

	@Autowired
	EmployeeService employeeService;

	// PointCut expression accessModifier returnType
	// packagename.ClassName.MethodName(..)

//	@Before("execution(public * com.gl.employee.serviceImpl.*.*(..))")
//	public void logBeforeAllMethods(JoinPoint joinPoint) {
//		log.info(joinPoint.getSignature().getName()+"Started");;
//	}
//	
//	@After("execution(public * com.gl.employee.serviceImpl.*.*(..))")
//	public void logAfterAllMethods(JoinPoint joinPoint) {
//		log.info(joinPoint.getSignature().getName()+"Ended");;
//	}
//	
	@Around("execution(public * com.gl.employee.serviceImpl.*.*(..))")
	public void logBeforeAndAfterAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info(proceedingJoinPoint.getSignature().getName() + "Started");
		proceedingJoinPoint.proceed();
		log.info(proceedingJoinPoint.getSignature().getName() + "Ended");
	}

	@AfterReturning("execution(public * com.gl.employee.serviceImpl.EmployeeServiceImpl.addEmployee(..))")
	public void logBeforeAddEmployee(JoinPoint joinPoint) {
		auditRepository.saveAndFlush(AuditLog.builder().createDate(new Date())
				.discription("Details Of employee added" + joinPoint.getArgs()[0]).build());
	}

	@AfterThrowing("execution(public * com.gl.employee.serviceImpl.EmployeeServiceImpl.updateEmployee(..))")
	public void logIfErrorWhileUpdatingEmployee(JoinPoint joinPoint) {
		Employee employee = (Employee) joinPoint.getArgs()[0];
		auditRepository.saveAndFlush(AuditLog.builder().createDate(new Date())
				.discription("Error While Updating Employee since there is no employee with id" + employee.getId())
				.build());
	}
}
