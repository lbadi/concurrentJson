package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

public class MapperQ2 implements Mapper<String, Movie, Integer, Movie> {

    private int tope;

    public MapperQ2(int tope) {
        this.tope = tope;
    }

    @Override
    public void map(String keyInput, Movie valueInput, Context<Integer, Movie> context) {
        int year = valueInput.getYearAsInteger();
        if(year > tope) {
            context.emit(year, valueInput);
        }
    }
}
