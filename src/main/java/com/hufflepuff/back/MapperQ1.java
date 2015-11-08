package com.hufflepuff.back;


import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;
import com.hufflepuff.domain.Movie;

public class MapperQ1 implements Mapper<String, Movie, String, Long> {

    @Override
    public void map(String keyInput, Movie valueInput, Context<String, Long> context) {
        System.out.println("key input: " + keyInput + " value input: " + valueInput);
        long votes = valueInput.getImdbVotesAsLong();
        if(votes == 0) {
            return;
        }
        for(String actor: valueInput.getActorsAsList()) {
            context.emit(actor, votes);
        }
    }
}
