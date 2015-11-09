package com.hufflepuff.domain;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Movie implements DataSerializable {

	String Title;
	String Year;
	String Rated;
	String Released;
	String Runtime;
	String Genre;
	String Director;
	String Writer;
	String Actors;
	String Plot;
	String Language;
	String Country;
	String Awards;
	String Poster;
	String Metascore;
	String imdbRating;
	String imdbVotes;
	String imdbID;
	String Type;
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
	String DVD;
	String BoxOffice;
	String Production;
	String Website;
	String Response;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String languaje) {
		Language = languaje;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getTomatoMeter() {
		return tomatoMeter;
	}
	public void setTomatoMeter(String tomatoMeter) {
		this.tomatoMeter = tomatoMeter;
	}
	public String getTomatoImage() {
		return tomatoImage;
	}
	public void setTomatoImage(String tomatoImage) {
		this.tomatoImage = tomatoImage;
	}
	public String getTomatoRating() {
		return tomatoRating;
	}
	public void setTomatoRating(String tomatoRating) {
		this.tomatoRating = tomatoRating;
	}
	public String getTomatoReviews() {
		return tomatoReviews;
	}
	public void setTomatoReviews(String tomatoReviews) {
		this.tomatoReviews = tomatoReviews;
	}
	public String getTomatoFresh() {
		return tomatoFresh;
	}
	public void setTomatoFresh(String tomatoFresh) {
		this.tomatoFresh = tomatoFresh;
	}
	public String getTomatoRotten() {
		return tomatoRotten;
	}
	public void setTomatoRotten(String tomatoRotten) {
		this.tomatoRotten = tomatoRotten;
	}
	public String getTomatoConsensus() {
		return tomatoConsensus;
	}
	public void setTomatoConsensus(String tomatoConsensus) {
		this.tomatoConsensus = tomatoConsensus;
	}
	public String getTomatoUserMeter() {
		return tomatoUserMeter;
	}
	public void setTomatoUserMeter(String tomatoUserMeter) {
		this.tomatoUserMeter = tomatoUserMeter;
	}
	public String getTomatoUserRating() {
		return tomatoUserRating;
	}
	public void setTomatoUserRating(String tomatoUserRating) {
		this.tomatoUserRating = tomatoUserRating;
	}
	public String getTomatoUserReviews() {
		return tomatoUserReviews;
	}
	public void setTomatoUserReviews(String tomatoUserReviews) {
		this.tomatoUserReviews = tomatoUserReviews;
	}
	public String getDVD() {
		return DVD;
	}
	public void setDVD(String dVD) {
		DVD = dVD;
	}
	public String getBoxOffice() {
		return BoxOffice;
	}
	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}
	public String getProduction() {
		return Production;
	}
	public void setProduction(String production) {
		Production = production;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}


	private List<String> actorsAsList;

	public List<String> getActorsAsList() {
		if(actorsAsList == null) {
			actorsAsList = new ArrayList<>();
			String actors = getActors();
			String[] actorsArray = getActors().split(",");
			for (String actor : actorsArray) {
				actorsAsList.add(actor.trim());
			}
		}
		return actorsAsList;
	}

	public long getImdbVotesAsLong() {
		try {
			return Long.parseLong(getImdbVotes().replace(",", ""));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int getYearAsInteger() {
		try {
			return Integer.valueOf(Year);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int getMetascoreAsInteger() {
		try {
			return Integer.valueOf(Metascore);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Movie [Title=" + Title + ", Year=" + Year + ", Rated=" + Rated
				+ ", Released=" + Released + ", Runtime=" + Runtime
				+ ", Genre=" + Genre + ", Director=" + Director + ", Writer="
				+ Writer + ", Actors=" + Actors + ", Plot=" + Plot
				+ ", Language=" + Language + ", Country=" + Country
				+ ", Awards=" + Awards + ", Poster=" + Poster + ", Metascore="
				+ Metascore + ", imdbRating=" + imdbRating + ", imdbVotes="
				+ imdbVotes + ", imdbID=" + imdbID + ", Type=" + Type
				+ ", tomatoMeter=" + tomatoMeter + ", tomatoImage="
				+ tomatoImage + ", tomatoRating=" + tomatoRating
				+ ", tomatoReviews=" + tomatoReviews + ", tomatoFresh="
				+ tomatoFresh + ", tomatoRotten=" + tomatoRotten
				+ ", tomatoConsensus=" + tomatoConsensus + ", tomatoUserMeter="
				+ tomatoUserMeter + ", tomatoUserRating=" + tomatoUserRating
				+ ", tomatoUserReviews=" + tomatoUserReviews + ", DVD=" + DVD
				+ ", BoxOffice=" + BoxOffice + ", Production=" + Production
				+ ", Website=" + Website + ", Response=" + Response + "]";
	}


	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(Title);
		out.writeUTF(Year);
		out.writeUTF(Rated);
		out.writeUTF(Released);
		out.writeUTF(Runtime);
		out.writeUTF(Genre);
		out.writeUTF(Director);
		out.writeUTF(Writer);
		out.writeUTF(Actors);
		out.writeUTF(Plot);
		out.writeUTF(Language);
		out.writeUTF(Country);
		out.writeUTF(Awards);
		out.writeUTF(Poster);
		out.writeUTF(Metascore);
		out.writeUTF(imdbRating);
		out.writeUTF(imdbVotes);
		out.writeUTF(imdbID);
		out.writeUTF(Type);
		out.writeUTF(tomatoMeter);
		out.writeUTF(tomatoImage);
		out.writeUTF(tomatoRating);
		out.writeUTF(tomatoReviews);
		out.writeUTF(tomatoFresh);
		out.writeUTF(tomatoRotten);
		out.writeUTF(tomatoConsensus);
		out.writeUTF(tomatoUserMeter);
		out.writeUTF(tomatoUserRating);
		out.writeUTF(tomatoUserReviews);
		out.writeUTF(DVD);
		out.writeUTF(BoxOffice);
		out.writeUTF(Production);
		out.writeUTF(Website);
		out.writeUTF(Response);
	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		Title = in.readUTF();
		Year = in.readUTF();
		Rated = in.readUTF();
		Released = in.readUTF();
		Runtime = in.readUTF();
		Genre = in.readUTF();
		Director = in.readUTF();
		Writer = in.readUTF();
		Actors = in.readUTF();
		Plot = in.readUTF();
		Language = in.readUTF();
		Country = in.readUTF();
		Awards = in.readUTF();
		Poster = in.readUTF();
		Metascore = in.readUTF();
		imdbRating = in.readUTF();
		imdbVotes = in.readUTF();
		imdbID = in.readUTF();
		Type = in.readUTF();
		tomatoMeter = in.readUTF();
		tomatoImage = in.readUTF();
		tomatoRating = in.readUTF();
		tomatoReviews = in.readUTF();
		tomatoFresh = in.readUTF();
		tomatoRotten = in.readUTF();
		tomatoConsensus = in.readUTF();
		tomatoUserMeter = in.readUTF();
		tomatoUserRating = in.readUTF();
		tomatoUserReviews = in.readUTF();
		DVD = in.readUTF();
		BoxOffice = in.readUTF();
		Production = in.readUTF();
		Website = in.readUTF();
		Response = in.readUTF();
	}
}
