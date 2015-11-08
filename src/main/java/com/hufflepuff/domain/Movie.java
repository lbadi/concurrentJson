package com.hufflepuff.domain;

public class Movie {

	String title;
	String year;
	String rated;
	String released;
	String runtime;
	String genre;
	String director;
	String writer;
	String actors;
	String plot;
	String languaje;
	String country;
	String awards;
	String poster;
	String metascore;
	String imdbRating;
	String imdbVotes;
	String imdbID;
	String type;
	String tomatoMeter;
	String tomatoImage;
	String tomatoRating;
	String tomatoReviews;
	String tomatoFresh;
	String tomatoRotten;
	String tomatoConsensus;
	String tomatoUserMeter;
	String tomatoUserRating;
	String tomatoUserReviews;
	String dvd;
	String boxOffice;
	String production;
	String website;
	String response;
	
	
	
	public String getTitle() {
		return title;
	}
	public String getRated() {
		return rated;
	}
	public String getReleased() {
		return released;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getYear() {
		return year;
	}
	public Movie setRated(String rated) {
		this.rated = rated;
		return this;
	}
	public Movie setReleased(String released) {
		this.released = released;
		return this;
	}
	public Movie setRuntime(String runtime) {
		this.runtime = runtime;
		return this;
	}
	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}
	public Movie setYear(String year) {
		this.year = year;
		return this;
	}
}


