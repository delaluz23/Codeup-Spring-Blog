package edu.codeup.codeupspringblog.models;

public class BlogPost {
    private String title;
    private String body;

    public BlogPost(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public BlogPost() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}