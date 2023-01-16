package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
//heelo-mvc? name=이름칠것 <-이런식으로 하여야 페이지에 오류가 뜨지 않고 제대로 나옴