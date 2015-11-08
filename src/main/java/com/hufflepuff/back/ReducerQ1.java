package com.hufflepuff.back;


import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class ReducerQ1 implements ReducerFactory<String, Long, Long> {

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
