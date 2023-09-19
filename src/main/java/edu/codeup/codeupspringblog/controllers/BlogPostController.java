package edu.codeup.codeupspringblog.controllers;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.ui.Model;
import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

//    dependency injection to use an instance of this new Posts interface
    private final PostRepository postsDao;

    public BlogPostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }
//

    @GetMapping("/view")
    public String returnPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "blogpost/Index";
    }

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("blogposts", postsDao.findAll());
        return "blogpost/Index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model){
        BlogPost post = postsDao.findById(id).get();
        model.addAttribute("blogpost", post);
        return "blogpost/Show";
    }

    @GetMapping("/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("blogpost", new BlogPost());
        return "blogpost/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
        BlogPost blogPost = new BlogPost(title, description);
        postsDao.save(blogPost);
        return "redirect:/posts";
    }

}