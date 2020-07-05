# mbeju

`mbeju` is a basic Spring Boot application which implements GraphQL caching, using resolvers for a crude `Post:Producer` data model. The `ProducerResolver` uses `Thread.sleep` to mock round-trip time to an improvised backend.

A Spring `@Cacheable` annotation on the resolver method implements caching for `Producer` objects on `producer.id` and `Post` on `post.producerId`. Specific caches can be implemented as required and specify eviction times based on type, context, etc. `mbeju` implements a 20-second TTL for all producers and
5-second TTL for posts. 

The GraphiQL interface can be found available on `http://localhost:8080/graphiql`

#### GraphQL example

```
graphql
{
  allPosts {
    title
    producer {
      id
      name
      posts {
        title
      }
    }
  }
}
```

#### Bash example

```
bash
curl 'http://localhost:8080/graphql' -H 'Accept: application/json' -H 'Content-Type: application/json' --data-binary '{"query":"{\n  allPosts {\n    title\n    producer {\n      id\n      name\n    }\n  }\n}\n","variables":null}'
```