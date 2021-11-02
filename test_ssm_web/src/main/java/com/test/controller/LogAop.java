package com.test.controller;

import com.test.domain.SysLog;
import com.test.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
//    @Autowired
//    private HttpServletRequest request;
//
//    @Autowired
//    private SysLogService sysLogService;
//
//    private Date visitTime;//开始时间
//    private Class clazz;//访问的类
//    private Method method;//访问的方法
//
//    private Class[] classes;

//    @Before("execution(* com.test.controller.*.*(..))")
//    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
//        visitTime=new Date();//开始时间
//        clazz=joinPoint.getTarget().getClass();//具体访问的类
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        method=methodSignature.getMethod();
//        String methodName = joinPoint.getSignature().getName();//具体访问的方法名称
//
//        Object[] args = joinPoint.getArgs();//具体访问的方法参数
//        if(args==null||args.length==0){
////            method=clazz.getMethod(methodName);
//
//
//        }else{
//            //有参数的方法
//             classes = new Class[args.length];
//            for (int i = 0; i < classes.length; i++) {
//                classes[i] = args[i].getClass();
//            }
////            method = clazz.getMethod(methodName,classes);
//            //ToDo 参数
//
//        }
//    }



//    @After("execution(* com.test.controller.*.*(..))")
//    public void doAfter(JoinPoint joinPoint) throws Exception{
//        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长
//
//        String url = "";
//
//        //获取url
//        if(clazz != null && method !=null && clazz!=LogAop.class && clazz != SysLogController.class){
//            //获取注解类上RequestMapping
//            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//            if (clazzAnnotation!=null){
//                String[] clazzValue = clazzAnnotation.value();
//                //获取注解方法上RequestMapping
//
//                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
//                if (methodAnnotation!=null){
//                    String[] methodValue = methodAnnotation.value();
//
//                    url=clazzValue[0]+methodValue[0];
//
//                    //访问ip地址
//                    String ip = request.getRemoteAddr();
//
//                    //获取用户名
//                    SecurityContext context = SecurityContextHolder.getContext();
//                    User user = (User) context.getAuthentication().getPrincipal();
//                    String username = user.getUsername();
//
//                    //封装数据
//                    SysLog sysLog = new SysLog();
//                    sysLog.setIp(ip);
//                    sysLog.setUrl(url);
//                    sysLog.setExecutionTime(time);
//                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+ method.getName());
//                    sysLog.setUsername(username);
//                    sysLog.setVisitTime(visitTime);
//                    sysLogService.save(sysLog);
//                }
//
//            }
//        }
//    }
}
