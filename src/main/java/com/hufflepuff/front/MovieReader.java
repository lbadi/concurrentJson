package com.hufflepuff.front;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hazelcast.core.IMap;
import com.hufflepuff.FileReader;
import com.hufflepuff.domain.Movie;
import com.hufflepuff.util.Timestamper;

import javax.xml.transform.sax.SAXSource;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MovieReader {

    public static void readMovies(IMap<String, Movie> movieMap, String path) {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader();
        System.out.println("Inicio de la lectura del archivo. " + Timestamper.getTime());
        String file = fileReader.read(path);
        System.out.println("Fin de lectura del archivo. " + Timestamper.getTime());
        Type movieListType = new TypeToken<List<Movie>>(){}.getType();
        List<Movie> movieList = gson.fromJson(file,movieListType);
        movieList.forEach(movie -> {
            movieMap.set(movie.getImdbID(), movie);
        });
    }

}
