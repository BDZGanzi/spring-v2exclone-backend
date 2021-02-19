package wallfacer5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import wallfacer5.annotation.MetricTimeAnnotation;
import wallfacer5.util.LogUtil;

@Component
@Aspect
public class MetricTimeAspect {
    static final Logger logger = LogUtil.getLogger(MetricTimeAspect.class);

    @Around("@annotation(metricTimeAnnotation)")
    public void metricTime(ProceedingJoinPoint pjp, MetricTimeAnnotation metricTimeAnnotation) throws Throwable {
        long before = System.currentTimeMillis();
        pjp.proceed();
        long after = System.currentTimeMillis();
        logger.info("used time:{} ms", after-before);
    }
}
