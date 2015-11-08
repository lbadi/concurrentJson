package com.hufflepuff;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.hufflepuff.domain.Movie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Movie movie = new Movie();
        movie.setRated("rated").setReleased("released").setRuntime("runtime").setTitle("Titutlo").setYear("2000");
        Gson gson = new Gson();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        movies.add(movie);
        FileReader fileReader = new FileReader();
        String file = fileReader.read("/home/leo/workspace/PODTpe/concurrentJson/resources/imdb-200.json");
        System.out.println(file);
        List<Movie> m = gson.fromJson(file,List.class);
        System.out.println(gson.toJson(movies));
    }
}
