package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

    //    dependency injection to use an instance of this new Posts interface
    private final PostRepository postsDao;
    private final UserRepository userDao;

    private final EmailService emailSvc;

    public BlogPostController(PostRepository postsDao, UserRepository userDao, EmailService emailSvc) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
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
    public String viewIndividualPost(@PathVariable long id, Model model) {
        BlogPost post = postsDao.findById(id).get();
        model.addAttribute("blogpost", post);
        return "blogpost/Show";
    }
    @GetMapping("/{id}/edit")
    public String editIndividualPostView(@PathVariable long id, Model model) {
        BlogPost postToEdit = postsDao.findById(id).get();
        model.addAttribute("blogpost", postToEdit);
        return "blogpost/edit";
    }
    @PostMapping("/{id}/edit")
    public String editIndividualPost(@PathVariable long id, @ModelAttribute BlogPost post) {
        BlogPost originalPost = postsDao.findById(id).get();
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        postsDao.save(originalPost);
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("blogpost", new BlogPost());
        return "blogpost/create";
    }

    //using request param
//    @PostMapping("/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, @RequestParam(name = "user_id") Long userId) {
//        BlogPost blogPost = new BlogPost(title, description, (User) userDao.findById(userId).get());
//        postsDao.save(blogPost);
//        return "redirect:/posts";
//    }

    //using  model attribute
    @PostMapping("/create")
    public String createPost(@ModelAttribute BlogPost post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BlogPost blogPost = new BlogPost(
                post.getTitle(),
                post.getBody(),
                userDao.findById(user.getId()).get()
        );
        postsDao.save(blogPost);
        emailSvc.prepareAndSend(blogPost, "hey loser", "YOU JABRONI");
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