package edu.codeup.codeupspringblog.controllers;
import org.springframework.ui.Model;
import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

    private List<BlogPost> blogPostsList =  new ArrayList<>(Arrays.asList(
            new BlogPost("A Day in the Life", "Yadda yadda yadda yaa..."),
            new BlogPost("Another Day in the Life", "Adda yadda yadda yadda yaa..."),
            new BlogPost("Yet Another Day in the Life", "Wadda adda yadda yadda yadda yaa...")
    ));

    @GetMapping
    public String indexPage(Model vModel) {
        vModel.addAttribute("blogposts", blogPostsList);
        return "blogposts/Index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        vModel.addAttribute("blogpost", blogPostsList.get((int) id - 1));
        return "blogposts/Show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
