package com.zee.zee5.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.exception.LocationNotFound;
import com.zee.zee5.exception.NameNotFound;
import com.zee.zee5.repository.MovieInterface;
import com.zee.zee5.repository.SeriesInterface;
import com.zee.zee5.repository.impl.MovieImpl;
import com.zee.zee5.repository.impl.SeriesImpl;
import com.zee.zee5.service.Movie_Service1;
import com.zee.zee5.service.Series_Service1;

public class MoviesImpl1 implements Movie_Service1 {
	MovieInterface service1=MovieImpl.getInstance();
	private static Movie_Service1 service;
	private MoviesImpl1()
	{
		
	}
	public static Movie_Service1 getInstance()
	{
		if(service==null)
		{
			service=new MoviesImpl1();
			return service;
		}
		return service;
	}
	@Override
	public String addMovie(Movies m) {
		// TODO Auto-generated method stub
		return service1.addmovie(m);
	}

	@Override
	public String deleteMovie(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.deleteMovie(id);
	}

	@Override
	public Optional<Movies> getMoviedetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.getMoviedetails(name);
	}

	@Override
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.getMovieCast(moviename);
	}

	@Override
	public List<Movies> getallMovies() {
		// TODO Auto-generated method stub
		return service1.getallMovies();
	}

	@Override
	public Movies updatemoviedetails(String id, Movies s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.updatemoviedetails(id, s);
	}
	@Override
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound {
		// TODO Auto-generated method stub
		return this.service1.watchmovie(moviename);
	}

}
