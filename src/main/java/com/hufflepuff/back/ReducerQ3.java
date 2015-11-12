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
                TreeSet<Partners> partnersSet = new TreeSet<Partners>(new Comparator<Partners>() {
                    @Override
                    public int compare(Partners o1, Partners o2) {
                        return Long.compare(o1.getAppearances(), o2.getAppearances());
                    }
                });
                partnersSet.addAll(partners.values());
                for(Partners p: partners.values()) {

                }git 
                return totalVotes;
            }
        };
    }
}
