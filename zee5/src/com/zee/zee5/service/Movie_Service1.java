package com.zee.zee5.service;

import com.zee.zee5.dto.Movies;

public interface Movie_Service1 {
	public String addMovie(Movies m);
	public String deleteMovie(String id);
	public Movies getMoviedetails(String name);
	public String[] getMovieCast(String moviename);
	public Movies[] getallMovies();
	public Movies updatemoviedetails(String id,Movies s);
}
