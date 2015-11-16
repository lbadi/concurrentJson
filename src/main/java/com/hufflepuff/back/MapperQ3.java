package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MapperQ3 implements Mapper<String, Movie, String, Movie> {

    @Override
    public void map(String keyInput, Movie valueInput, Context<String, Movie> context) {

        List<String> actors = valueInput.getActorsAsList();
        for(String actor: actors) {
            context.emit(actor, valueInput);
        }


    }
}
