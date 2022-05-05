package com.trustrace.circularity.aop;

import com.trustrace.circularity.entity.AuditLogs;
import com.trustrace.circularity.repository.AuditLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Autowired
    AuditLogRepository auditLogRepository;

//    @Before("within(@org.springframework.stereotype.Repository *)" +
//            " || within(@org.springframework.stereotype.Service *)" +
//            " || within(@org.springframework.web.bind.annotation.RestController *)")


    @Before("within(@org.springframework.web.bind.annotation.RestController *)")

    public void springBeanPointcut(JoinPoint joinPoint) {

        if(joinPoint.getSignature().getDeclaringTypeName().contains("springfox.documentation")){
            return;
        }

        log.info(joinPoint.getSignature().getDeclaringTypeName()+ "------ "+joinPoint.getSignature().getName()+"-request "+Arrays.toString(joinPoint.getArgs()));

        AuditLogs auditLogs=new AuditLogs();
        auditLogs.setControler(joinPoint.getSignature().getDeclaringTypeName());
        auditLogs.setMethodName(joinPoint.getSignature().getName());
        auditLogs.setRequest(Arrays.toString(joinPoint.getArgs()));

        auditLogRepository.save(auditLogs);


    }
}
