package com.zee.zee5.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.exception.LocationNotFound;
import com.zee.zee5.exception.NameNotFound;
import com.zee.zee5.repository.MovieInterface;

public class MovieImpl implements MovieInterface {
	Set<Movies> movies=new HashSet<Movies>();
	private static int count=-1;
	private static MovieInterface repo;
	private MovieImpl()
	{
		
	}
	public static MovieInterface getInstance()
	{
		if(repo==null)
		{
			repo=new MovieImpl();
			return repo;
		}
		return repo;
	}
	@Override
	public String addmovie(Movies m) {
		// TODO Auto-generated method stub
		boolean result=movies.add(m);
		if(result)
		{
			return "Movie added successfully";
		}
		else {
			return "Movie not added";
		}
	}

	@Override
	public String deleteMovie(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Optional<Movies> m=getMoviedetails(name);
		
		if(m.isPresent())
		{
			System.out.println(m+"-------");
			boolean result=	movies.remove(m.get());
			if(result)
			return "Successfully deleted";
			else
			{
			 return "Movie Deletion Failed";
			}
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
	}

	@Override
	public Optional<Movies> getMoviedetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Movies m=null;
		for(Movies s:movies)
		{	
			System.out.println(s);
			if(name.equals(s.getMoviename()))
			{
				
				
				m=s;
				break;
				}
				
			}
		
		return Optional.of(Optional.ofNullable(m).orElseThrow(()->new NameNotFound("movie does not exist")));
	}

	@Override
	public String[] getMovieCast(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
Optional<Movies> m=getMoviedetails(name);
		
		if(m.isPresent())
		{
			
			
			return m.get().getCast() ;
			
			
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
	}

	@Override
	public List<Movies> getallMovies() {
		// TODO Auto-generated method stub
		return new ArrayList(movies);
	}

	@Override
	public Movies updatemoviedetails(String name, Movies s) throws NameNotFound, LocationNotFound {
Optional<Movies> m=getMoviedetails(name);
		
		if(m.isPresent())
		{
			boolean result=	movies.remove(m.get());
			movies.add(s);
			
			return s;
			
			
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound {
		System.out.println(moviename);
Optional<Movies> m=getMoviedetails(moviename);
System.out.println(m+"---");
		if(m.isPresent())
		{
			
			if(m.get().getAllowed_locations().contains("India"))
			{
				return "Movie Available";
			}
			else
			{
				throw new  LocationNotFound("Movie is not available in your location");
			}
			
			
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
		
	}
	

}
