package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

public class MapperQ4 implements Mapper<String, Movie, String, String> {

    @Override
    public void map(String keyInput, Movie valueInput, Context<String, String> context) {
        for(String actor: valueInput.getActorsAsList()) {
            context.emit(valueInput.getDirector(), actor);
        }
    }
}
