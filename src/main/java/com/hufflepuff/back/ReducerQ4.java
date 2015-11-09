package com.hufflepuff.back;


import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

import java.util.*;

public class ReducerQ4 implements ReducerFactory<String, String, List<String>> {

    @Override
    public Reducer<String, List<String>> newReducer(String director) {
        return new Reducer<String, List<String>>() {

            private Map<String, Integer> actors;

            @Override
            public void beginReduce() {
                actors = new HashMap<>();
            }

            @Override
            public void reduce(String actor) {
                if(actors.containsKey(actor)) {
                    actors.put(actor, actors.get(actor) + 1);
                } else {
                    actors.put(actor, 1);
                }
            }

            @Override
            public List<String> finalizeReduce() {
                List<String> response = new ArrayList<>();
                int last = 0;
                for(String s: actors.keySet()) {
                    Integer actorCount = actors.get(s);
                    if(actorCount != null) {
                        if (actorCount > last) {
                            response.clear();
                            last = actorCount;
                            response.add(s);
                        } else if (actorCount == last) {
                            response.add(s);
                            last = actorCount;
                        }
                    }
                }
                return response;
            }
        };
    }
}
