package com.example.core.web;

import com.example.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
//        System.out.println("myLoggerObjectProvider = " + myLoggerObjectProvider.getClass());
//        MyLogger myLogger = myLoggerObjectProvider.getObject();
        System.out.println("myLogger of Controller = " + myLogger.getClass());
        myLogger.setRequestURL(request.getRequestURL().toString());

        myLogger.log("controller test");

        logDemoService.logic("testServiceId");
        return "OK";
    }
}
