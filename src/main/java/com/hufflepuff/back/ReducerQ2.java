package com.hufflepuff.back;


import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;
import com.hufflepuff.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class ReducerQ2 implements ReducerFactory<Integer, Movie, List<Movie>> {

    @Override
    public Reducer<Movie, List<Movie>> newReducer(Integer actor) {
        return new Reducer<Movie, List<Movie>>() {

            private List<Movie> best;
            private int bestInt;

            @Override
            public void beginReduce() {
                best = new ArrayList<>();
                bestInt = -1;
            }

            @Override
            public void reduce(Movie movie) {
                int movieScore = movie.getMetascoreAsInteger();
                if(movieScore < bestInt) {
                    return;
                } else if(movieScore > bestInt) {
                    bestInt = movieScore;
                    best = new ArrayList<>();
                    best.add(movie);
                } else {
                    best.add(movie);
                }
            }

            @Override
            public List<Movie> finalizeReduce() {
                return best;
            }
        };
    }
}
