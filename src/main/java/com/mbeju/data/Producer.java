package com.mbeju.data;

import java.util.Arrays;
import java.util.List;

public class producer {
    private String id;
    private String name;

    public producer() {}

    public producer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final List<producer> producerS = Arrays.asList(new producer[] {
            new producer("producer-1", "producer One"),
            new producer("producer-2", "producer Two")
    });

}