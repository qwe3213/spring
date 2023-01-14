package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//spring은 해주어야함
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data" , "spring ");
        return "hello"; // resources/templates/hello 파일을 찾아서 렌더링함.
    }
}
