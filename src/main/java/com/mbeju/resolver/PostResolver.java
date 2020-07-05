package com.mbeju.resolver;

import com.mbeju.data.producer;
import com.mbeju.data.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(value = "producerByPost", key = "{#post.producerId}", cacheManager = "producerCache")
    public producer getproducer(Post post) {

        this.logger.info("Getting producer with id: {}", post.getproducerId());

        return producer.producerS.stream()
                .filter(a -> a.getId().equals(post.getproducerId()))
                .findFirst()
                .get();
    }

}
