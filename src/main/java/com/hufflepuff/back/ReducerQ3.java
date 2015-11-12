package com.hufflepuff.back;


import java.util.List;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class ReducerQ3 implements ReducerFactory<String, List<String>, Long> {

    @Override
    public Reducer<Long, Long> newReducer(String actor) {
        return new Reducer<Long, Long>() {

            private long totalVotes;

            @Override
            public void beginReduce() {
                totalVotes = 0;
            }

            @Override
            public void reduce(Long votes) {
                totalVotes += votes;
            }

            @Override
            public Long finalizeReduce() {
                return totalVotes;
            }
        };
    }
}
