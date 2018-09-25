package cs544.flight.advice;

import cs544.flight.logging.SystemLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemMonitorAspect {

//    @Pointcut("within(cs544.flight.controller..*)")
    @After("execution(* cs544.flight.controller.*.*(..))")
    public void inControllerLayer(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName() + "()";
        SystemLogger.getLogger(joinPoint.getTarget().getClass().getName()).info("executed " + method);
    }

    @After("execution(* cs544.flight.service.*.*(..))")
    public void inServiceLayer(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName() + "()";
        SystemLogger.getLogger(joinPoint.getTarget().getClass().getName()).info("executed " + method);
    }

    @After("execution(* cs544.flight.repository.*.*(..))")
    public void inRepositoryLayer(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName() + "()";
        SystemLogger.getLogger(joinPoint.getTarget().getClass().getName()).info("executed " + method);
    }

}
