package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MapperQ3 implements Mapper<String, Movie, String, List<String>> {

    @Override
    public void map(String keyInput, Movie valueInput, Context<String, List<String>> context) {
        System.out.println("key input: " + keyInput + " value input: " + valueInput);

        if(!valueInput.getType().equals("movie")) {
            return;
        }

        List<String> actors = valueInput.getActorsAsList();
        for(String actor: actors) {
            List<String> partners = new ArrayList<>();
            actors.forEach(a -> {
                if(!a.equals(actor)) {
                    partners.add(a);
                }
            });
            context.emit(actor, partners);
        }
    }
}
