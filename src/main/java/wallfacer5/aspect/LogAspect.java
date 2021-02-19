package wallfacer5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import wallfacer5.annotation.LogAnnotation;

@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Around("@annotation(logAnnotation)")
    public void log(ProceedingJoinPoint pjp, LogAnnotation logAnnotation) throws Throwable {
        logger.info("start {}", pjp.getSignature());
        pjp.proceed();
        logger.info("end {}", pjp.getSignature());
    }
}
