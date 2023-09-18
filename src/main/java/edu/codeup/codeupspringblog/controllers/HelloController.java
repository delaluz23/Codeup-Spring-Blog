package edu.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    @ResponseBody
    public String helloWorld(){
        System.out.println("inside hellocontroller helloworld method");
        return "Hello WORLD";
    }
    @GetMapping("")
    @ResponseBody
    public String withoutBackSlash(){
        return "Hello, World!";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String helloname(@PathVariable String name){
        return String.format("Hello, %s", name);
    }
}
