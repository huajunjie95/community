package com.nowcoder.community.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

//统一记录日志，使用SpringAOP技术
@Component
@Aspect
public class ServiceLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    //指定切片作用于哪些那些文件
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointCut() {

    }

    //在切入点之前执行
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //用户【1，2，3，4】，在【xxx】访问量[com.newcoder.community.service.xxx(..)]
        //RequestContextHolder.getRequestAttributes()可以用于获取当前请求的上下文信息，包括请求的属性、参数、头部信息等
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //增加生产者消费者后，通过消费者调用的而不是controller导致没有request，需要增加判断
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        String ip = request.getRemoteHost();//获取远程主机ip地址
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//joinPoint.getSignature()返回的是一个 Signature 接口的实例，它代表了连接点所在方法或字段的签名信息，包括方法名、参数类型、返回类型等
        //joinPoint.getSignature().getDeclaringTypeName():这个方法链的作用是获取连接点所在方法或字段的声明类型的名称，以便于后续的处理。
        String target = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        logger.info(String.format("用户[%s],在[%s],访问了[%s].", ip, now, target));

    }
}
