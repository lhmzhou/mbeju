package com.mbeju.resolver;

import com.mbeju.data.producer;
import com.mbeju.data.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class producerResolver implements GraphQLResolver<producer> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(value = "postsByproducer", key = "{#producer.id}", cacheManager = "postCache")
    public List<Post> getPosts(producer producer) {

        logger.info("Getting posts for producer: {}", producer.getId());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        return Post.POSTS.stream()
                .filter(p -> p.getproducerId().equals(producer.getId()))
                .collect(Collectors.toList());
    }


}
