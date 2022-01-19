package com.zee.zee5.repository;

import com.zee.zee5.dto.Movies;

public interface MovieInterface {
	public String addmovie(Movies m);
	public String deleteMovie(String id);
	public Movies getMoviedetails(String name);
	public String[] getMovieCast(String moviename);
	public Movies[] getallMovies();
	public Movies updatemoviedetails(String id,Movies s);
}
