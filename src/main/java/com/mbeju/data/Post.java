package com.mbeju.data;

import java.util.Arrays;
import java.util.List;

public class Post {
    private String id;
    private String title;
    private String category;
    private String producerId;

    private producer producer;

    public Post() {}

    public Post(String id, String title, String category, String producerId) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.producerId = producerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getproducerId() {
        return producerId;
    }

    public void setproducerId(String producerId) {
        this.producerId = producerId;
    }

//    public producer getproducer() {
//        return producer;
//    }
//
//    public void setproducer(producer producer) {
//        this.producer = producer;
//    }

    public static final List<Post> POSTS = Arrays.asList(new Post[] {
            new Post("post-1", "Post One", "Posts", "producer-1"),
            new Post("post-2", "Post Two", "Posts", "producer-1"),
            new Post("post-3", "Post Three", "Posts", "producer-2")
    });
}
