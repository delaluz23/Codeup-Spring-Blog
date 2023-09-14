package edu.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello/world")
    @ResponseBody
    public String helloWorld(){
        return "Hello WORLD";
    }
}
