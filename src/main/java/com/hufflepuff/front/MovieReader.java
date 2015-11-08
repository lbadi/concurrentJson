package com.hufflepuff.front;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hazelcast.core.IMap;
import com.hufflepuff.FileReader;
import com.hufflepuff.domain.Movie;

import javax.xml.transform.sax.SAXSource;
import java.lang.reflect.Type;
import java.util.List;


public class MovieReader {

    public static void readMovies(IMap<String, Movie> movieMap, String path) {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader();
        String file = fileReader.read(path);
        Type movieListType = new TypeToken<List<Movie>>(){}.getType();
        List<Movie> movieList = gson.fromJson(file,movieListType);
        movieList.forEach(movie -> {
            movieMap.set(movie.getImdbID(), movie);
            System.out.println(movie.getImdbVotesAsLong());
            for (String s: movie.getActorsAsList())
                System.out.println(s);
        });
    }

}
