package com.hufflepuff.back;


import java.util.*;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;
import com.hufflepuff.domain.Partners;


public class ReducerQ3 implements ReducerFactory<String, List<String>, List<Partners>> {

    @Override
    public Reducer<List<String>, List<Partners>> newReducer(String actor) {

        return new Reducer<List<String>, List<Partners>>() {

            private Map<String, Partners> partners;

            @Override
            public void beginReduce() {
                partners = new HashMap<>();
            }

            @Override
            public void reduce(List<String> strings) {
                for(String s: strings) {
                    if(partners.containsKey(s)) {
                        partners.get(s).incAppearances();
                    } else {
                        partners.put(s, new Partners(actor, s));
                    }
                }
            }

            @Override
            public List<Partners> finalizeReduce() {
                TreeSet<Partners> partnersSet = new TreeSet<>((p1, p2) -> {
                    return Long.compare(p1.getAppearances(), p2.getAppearances());
                });
                partnersSet.addAll(partners.values());
                int max = 0;
                List<Partners> result = new ArrayList<>();
                for(Partners p: partnersSet.descendingSet()) {
                    int appearances = p.getAppearances();
                    if( appearances > max) {
                        max = appearances;
                        result.add(p);
                    } else if(appearances == max) {
                        result.add(p);
                    } else {
                        break;
                    }
                }
                return result;
            }
        };
    }
}
