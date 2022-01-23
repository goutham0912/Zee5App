package com.zee.zee5.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.exception.LocationNotFound;
import com.zee.zee5.exception.NameNotFound;

public interface MovieInterface {
	public String addmovie(Movies m);
	public String deleteMovie(String id) throws NameNotFound, LocationNotFound;
	public Optional<Movies> getMoviedetails(String name) throws NameNotFound, LocationNotFound;
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound;
	public List<Movies> getallMovies();
	public Movies updatemoviedetails(String id,Movies s) throws NameNotFound, LocationNotFound;
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound;
}
