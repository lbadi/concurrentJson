package com.hufflepuff.back;

import com.hazelcast.mapreduce.Collator;
import com.hufflepuff.domain.Partners;

import java.util.*;

public class CollatorQ1 implements Collator<Map.Entry<String, Long>, List<String>> {

    private long n;

    public CollatorQ1(long n) {
        this.n = n;
    }

    @Override
    public List<String> collate(Iterable<Map.Entry<String, Long>> actors) {

        List<ActorVotes> sortedActors = new ArrayList<>();
        for(Map.Entry<String, Long> a: actors) {
            sortedActors.add(new ActorVotes(a.getKey(), a.getValue()));
        }
        Collections.sort(sortedActors);

        List<String> ans = new ArrayList<>();
        int count = 0;
        for(ActorVotes av: sortedActors) {
            if(count++ < n) {
                ans.add(av.actor + " con " + av.votes + " votos.");
            }
        }

        return ans;
    }

    private class ActorVotes implements Comparable<ActorVotes> {

        String actor;
        long votes;

        public ActorVotes(String actor, long votes) {
            this.actor = actor;
            this.votes = votes;
        }

        @Override
        public int compareTo(ActorVotes av) {
            return Long.compare(av.votes, votes);
        }
    }
}
