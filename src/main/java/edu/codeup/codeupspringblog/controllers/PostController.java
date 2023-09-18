package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @GetMapping("")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String view(@PathVariable Long id) {
        return "view";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createForm() {
        return "create";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost(@RequestParam("title") String title, @RequestParam("content") String content) {
        return "redirect:/posts";
    }

}
