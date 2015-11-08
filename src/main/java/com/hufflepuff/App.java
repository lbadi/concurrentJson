package com.hufflepuff;

import java.util.ArrayList;

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
//        Movie m = gson.fromJson(json, classOfT)
        System.out.println(gson.toJson(movies));
    }
}
