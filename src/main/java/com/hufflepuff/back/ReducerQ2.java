package com.hufflepuff.back;


import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;
import com.hufflepuff.domain.Movie;

public class ReducerQ2 implements ReducerFactory<Integer, Movie, Movie> {

    @Override
    public Reducer<Movie, Movie> newReducer(Integer actor) {
        return new Reducer<Movie, Movie>() {

            private Movie best;

            @Override
            public void beginReduce() {
                best = null;
            }

            @Override
            public void reduce(Movie movie) {
                if(best != null) {
                    if(movie.getMetascoreAsInteger() > best.getMetascoreAsInteger()) {
                        best = movie;
                    }
                } else {
                    best = movie;
                }
            }

            @Override
            public Movie finalizeReduce() {
                return best;
            }
        };
    }
}
