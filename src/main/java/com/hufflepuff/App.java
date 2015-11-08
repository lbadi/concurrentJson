package com.hufflepuff;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hufflepuff.domain.Movie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	QueryData data = parseArgs(args);
//        Movie movie = new Movie();
//        movie.setRated("rated").setReleased("released").setRuntime("runtime").setTitle("Titutlo").setYear("2000");
        Gson gson = new Gson();
//        ArrayList<Movie> movies = new ArrayList<Movie>();
//        movies.add(movie);
//        movies.add(movie);
        FileReader fileReader = new FileReader();
        String file = fileReader.read(data.path);
//        System.out.println(file);
        Type movieListType = new TypeToken<List<Movie>>(){}.getType();
        List<Movie> m = gson.fromJson(file,movieListType);
        m.forEach(mov -> {System.out.println(mov.toString());});
//        System.out.println(gson.toJson(movies));
    }

    private static QueryData parseArgs(String[] args) {
        int n = -1;
        int tope = -1;
        String path = null;
        for(String arg: args) {
            String[] argSplitted = arg.split("=");
            String argName = argSplitted[0].toLowerCase();
            String argValue = argSplitted[1];
            if(argName.equals("n")) {
                n = Integer.parseInt(argValue);
            } else if(argName.equals("tope")) {
                tope = Integer.parseInt(argValue);
            } else if(argName.equals("path")) {
                path = argValue;
            }
        }
        return new QueryData(n, tope, path);
    }

    private static class QueryData {
        int n;
        int tope;
        String path;

        public QueryData(int n, int tope, String path) {
            this.n = n;
            this.tope = tope;
            this.path = path;
        }
    }

}
