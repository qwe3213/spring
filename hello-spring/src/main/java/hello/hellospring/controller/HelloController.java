package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//spring은 해주어야함
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data" , "spring ");
        return "hello"; // resources/templates/hello 파일을 찾아서 렌더링함.
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name" ,name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" +name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    //@ResponseBody를사용 -> HTTP의 BODY에 문자 내용을 직접 반환 ,viewResolver 대신에 HttpMessageConverter가 동작
    //기본 문자처리 :StringHttpMessageConverter
    //기본 객체처리 :MappingJackson2HttpMessageConverter

    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    //json 방식
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        private void setName(String name){
            this.name = name;
        }
    }
}
//heelo-mvc? name=이름칠것 <-이런식으로 하여야 페이지에 오류가 뜨지 않고 제대로 나옴
