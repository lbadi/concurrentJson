package com.hufflepuff.front;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.hazelcast.core.IMap;
import com.hufflepuff.FileReader;
import com.hufflepuff.domain.Movie;
import com.hufflepuff.util.Timestamper;

import javax.xml.transform.sax.SAXSource;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MovieReader {

    public static void readMovies(IMap<String, Movie> movieMap, String path) {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader();
        JsonReader reader;
        try {
            System.out.println("Inicio de la lectura del archivo. " + Timestamper.getTime());
            reader = new JsonReader(new java.io.FileReader(path));
            Type movieListType = new TypeToken<List<Movie>>(){}.getType();
            List<Movie> movies = gson.fromJson(reader, movieListType);
            movies.forEach(movie -> {
                if (movie.getType().equals("movie")) {
                    movieMap.set(movie.getImdbID(), movie);
                }
            });
            System.out.println("Fin de lectura del archivo. " + Timestamper.getTime());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
