package com.xuanzilan.springMVC.controller;

import com.xuanzilan.springMVC.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/my")//命名空间
public class MyController {

    /**
     * 定义命名空间后，requestMapping中的路径可以有/前缀，也可以没有，如果没得/,如直接是welcome.do，会自动在前面补上/
     * @return
     */
    @RequestMapping("/welcome.do")
    public ModelAndView handleRequest(){
        ModelAndView mv = new ModelAndView();
        //其底层实现的是request.setAttribute()方法
        mv.addObject("message","Hello, SpringMVC");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    /**
     * 路径也可以使用通配符,如前缀或后缀*，此外还能在路径中使用
     * @return
     */
//    @RequestMapping("/doSome*.do")
//    @RequestMapping("/*/doSome.do")  //路径级数的绝对匹配，要求有且只有一层路径才能访问
    @RequestMapping("/**/doSome*.do")  //要求中间有大于等于0层路径
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","doSome");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

//    @RequestMapping(value = "doFirst.do",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @RequestMapping(value = "doFirst.do",method = RequestMethod.GET)
    public ModelAndView doFirst(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","doSome");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    /**
     * params相当于校验一下，要求请求需要带那么参数，不带age参数，如果不含那么或含有了age，则会提示404
     * @return
     */
//    @RequestMapping(value = "doSecond.do",params = {"name=zs","!age"})  //要求name参数必须为zs
    //    @RequestMapping(value = "doSecond.do",params = {"name!=zs","!age"})  //要求必须带name参数，且name不能为zs
    @RequestMapping(value = "doSecond.do",params = {"name","!age"})
    public ModelAndView doSecond(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","doSome");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    @RequestMapping(value = "/submit.do")
    public ModelAndView doSubmit(String name, int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    /**
     * 利用参数校正器 @RequestParam
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/submit1.do")
    public ModelAndView doSubmit1(@RequestParam("pname") String name, int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    /**
     * 接受对象
     * 要求表单参数名和对象属性名相同
     * @return
     */
    @RequestMapping(value = "/submit2.do")
    public ModelAndView doSubmit2(Student student){
        System.out.println(student);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());
        mv.addObject("sname",student.getSchool().getSname());
        mv.addObject("addr",student.getSchool().getAddr());
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    /**
     * 路径参数
     * @return
     */
    @RequestMapping(value = "/{pname}/{age}/pathParam.do")
    public ModelAndView pathParam(@PathVariable("pname") String name, @PathVariable int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/heheda.do")
    public String heheda() {
        return "heheda";
    }
}
