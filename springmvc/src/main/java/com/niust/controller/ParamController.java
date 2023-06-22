package com.niust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求参数
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/home")
    public String param(){
        return "param";
    }

    //原始方法(low)
    @RequestMapping("/test1")
    public String testParam(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        return "target";
    }

    //形参方式获取参数
    @RequestMapping("/test2")
    public String testParamMVC(@RequestParam("username") String username, String password){
        System.out.println(username+password);
        return "target";
    }

    //使用ModelAndView来传递参数
    @RequestMapping("/test3")
    public ModelAndView testRequest(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username","张三");
        mv.setViewName("target");
        return mv;
    }

    @RequestMapping(value = "/test4", method = {RequestMethod.PUT})
    public ModelAndView testPut(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("target");
        return mv;
    }

    @RequestMapping("/说明")
    @ResponseBody
    public String shuoming(){
        return "ResponseBody这个标签是将这个方法的返回值当作响应体返回给浏览器，如果想要返回一个实体对象给浏览器需要解析成json格式，这时需要添加依赖" +
                "同时，对于ajax请求的处理也需要这个注解，因为ajax请求是不会产生页面跳转的，所以返回值都是以响应体的形式" +
                "这个注解用的会比较多";
    }

}
