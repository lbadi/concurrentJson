package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

public class MapperQ2 implements Mapper<String, Movie, Integer, Movie> {

    @Override
    public void map(String keyInput, Movie valueInput, Context<Integer, Movie> context) {
        System.out.println("key input: " + keyInput + " value input: " + valueInput);
        context.emit(valueInput.getYearAsInteger(), valueInput);
    }
}
