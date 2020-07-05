package com.mbeju.resolver;

import com.mbeju.data.Producer;
import com.mbeju.data.Post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    public List<Post> getAllPosts() {
        return Post.POSTS;
    }

    public List<Producer> getAllProducers() {
        return Producer.PRODUCERS;
    }

}
