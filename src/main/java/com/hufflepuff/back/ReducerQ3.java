package com.hufflepuff.back;


import java.util.*;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;
import com.hufflepuff.domain.Movie;
import com.hufflepuff.domain.Partners;


public class ReducerQ3 implements ReducerFactory<String, Movie, List<Partners>> {

    @Override
    public Reducer<Movie, List<Partners>> newReducer(String actor) {

        return new Reducer<Movie, List<Partners>>() {

            private Map<String, Partners> partners;

            @Override
            public void beginReduce() {
                partners = new HashMap<>();
            }

            @Override
            public void reduce(Movie movie) {
                List<String> partnersList = new ArrayList<>();
                for(String a: movie.getActorsAsList()) {
                    if(!a.equals(actor)) {
                        partnersList.add(a);
                    }
                }
                for(String s: partnersList) {
                    if(partners.containsKey(s)) {
                        partners.get(s).incAppearances(movie);
                    } else {
                        partners.put(s, new Partners(actor, s, movie));
                    }
                }
            }

            @Override
            public List<Partners> finalizeReduce() {
                int max = 0;
                List<Partners> result = new ArrayList<>();
                for(Partners p: partners.values()) {
                    int appearances = p.getAppearances();
                    if( appearances > max) {
                        result = new ArrayList<>();
                        max = appearances;
                        result.add(p);
                    } else if(appearances == max) {
                        result.add(p);
                    }
                }
                return result;
            }
        };
    }
}
