package com.hufflepuff.back;

import com.hazelcast.mapreduce.Collator;
import com.hufflepuff.domain.Partners;

import java.util.*;

public class CollatorQ3 implements Collator<Map.Entry<String, List<Partners>>, List<Partners>> {

    @Override
    public List<Partners> collate(Iterable<Map.Entry<String, List<Partners>>> partners) {
        int max = 0;
        Set<Partners> partnersSet = new HashSet<>();
        for(Map.Entry<String, List<Partners>> pl: partners) {
            for(Partners p: pl.getValue()) {
                int appearances = p.getAppearances();
                if( appearances > max) {
                    partnersSet = new HashSet<>();
                    max = appearances;
                    partnersSet.add(p);
                } else if(appearances == max) {
                    partnersSet.add(p);
                }
            }
        }
        return new ArrayList<>(partnersSet);
    }
}
