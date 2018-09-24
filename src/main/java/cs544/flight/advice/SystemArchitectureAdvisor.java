package cs544.flight.advice;

import cs544.flight.logging.SystemLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemArchitectureAdvisor {

//    @Pointcut("within(cs544.flight.controller.*.*(..))")
    @After("execution(* cs544.flight.controller.*.*(..))")
    public void inControllerLayer(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()";
        SystemLogger.getControllerLogger().info("executed " + method);
    }
}
