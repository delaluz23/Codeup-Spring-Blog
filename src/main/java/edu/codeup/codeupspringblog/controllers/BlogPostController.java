package edu.codeup.codeupspringblog.controllers;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.ui.Model;
import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

//    dependency injection to use an instance of this new Posts interface
    private final PostRepository postsDao;
    private final UserRepository userDao;
    public BlogPostController(PostRepository postsDao, UserRepository userDao) {
        this.postsDao = postsDao; this.userDao =userDao;
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
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "user_id") Long userId) {
        BlogPost blogPost = new BlogPost(title, description, (User) userDao.findById(userId).get());
        postsDao.save(blogPost);
        return "redirect:/posts";
    }


    //walkthrough way
//    @PostMapping("/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
//        User hardCodeUser = userDao.findById(2L).get();
//        BlogPost blogPost = new BlogPost(title, description, hardCodeUser);
//        postsDao.save(blogPost);
//        return "redirect:/posts";
//    }
}