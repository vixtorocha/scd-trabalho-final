package servidor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Filme {
  public final String Title;
  public final String Year;
  public final String Rated;
  public final String Released;
  public final String Runtime;
  public final String Genre;
  public final String Director;
  public final String Writer;
  public final String Actors;
  public final String Plot;
  public final String Language;
  public final String Country;
  public final String Awards;
  public final String Poster;
  public final List Ratings;
  public final String Metascore;
  public final String imdbRating;
  public final String imdbVotes;
  public final String imdbID;
  public final String Type;
  public final String DVD;
  public final String BoxOffice;
  public final String Production;
  public final String Website;
  public final String Response;

  public Filme(
      @JsonProperty("Title") String Title,
      @JsonProperty("Year") String year,
      @JsonProperty("Rated") String rated,
      @JsonProperty("Released") String released,
      @JsonProperty("Runtime") String runtime,
      @JsonProperty("Genre") String genre,
      @JsonProperty("Director") String director,
      @JsonProperty("Writer") String writer,
      @JsonProperty("Actors") String actors,
      @JsonProperty("Plot") String plot,
      @JsonProperty("Language") String language,
      @JsonProperty("Country") String country,
      @JsonProperty("Awards") String awards,
      @JsonProperty("Poster") String poster,
      @JsonProperty("Ratings") List ratings,
      @JsonProperty("Metascore") String metascore,
      @JsonProperty("imdbRating") String imdbRating,
      @JsonProperty("imdbVotes") String imdbVotes,
      @JsonProperty("imdbID") String imdbID,
      @JsonProperty("Type") String type,
      @JsonProperty("DVD") String dvd,
      @JsonProperty("BoxOffice") String boxOffice,
      @JsonProperty("Production") String production,
      @JsonProperty("Website") String website,
      @JsonProperty("Response") String response) {
    this.Title = Title;
    Year = year;
    Rated = rated;
    Released = released;
    Runtime = runtime;
    Genre = genre;
    Director = director;
    Writer = writer;
    Actors = actors;
    Plot = plot;
    Language = language;
    Country = country;
    Awards = awards;
    Poster = poster;
    Ratings = ratings;
    Metascore = metascore;
    this.imdbRating = imdbRating;
    this.imdbVotes = imdbVotes;
    this.imdbID = imdbID;
    Type = type;
    DVD = dvd;
    BoxOffice = boxOffice;
    Production = production;
    Website = website;
    Response = response;
  }
}
