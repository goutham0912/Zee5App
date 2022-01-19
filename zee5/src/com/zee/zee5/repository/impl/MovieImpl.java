package com.zee.zee5.repository.impl;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.repository.MovieInterface;

public class MovieImpl implements MovieInterface {
	Movies[] movies=new Movies[10];
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
		if(count==movies.length-1)
		{
			Movies[] temp=new Movies[movies.length*2];	
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies=temp;
			movies[++count]=m;
			return "Added movie";
			}
		movies[++count]=m;
		return "Added movie";
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		int c=0;
		for(Movies s:movies)
		{
			if(id.equals(s.getId()))
			{
				for(int i=c;i<movies.length-2;i++)
				{
					movies[i]=movies[i+1];
					
				}
				movies[movies.length-1]=null;
				
				return "Successfully deleted the movie";
			}
			c+=1;
		}
		return "ID not found";
	}

	@Override
	public Movies getMoviedetails(String name) {
		// TODO Auto-generated method stub
		for(Movies s:movies)
		{
			if(s!=null && name.equals(s.getMoviename()))
			{
				return s;
			}
		}
		return null;
	}

	@Override
	public String[] getMovieCast(String moviename) {
		// TODO Auto-generated method stub
		for(Movies s:movies)
		{
			if(s!=null && moviename.equals(s.getMoviename()))
			{
				return s.getCast();
			}
		}
		return null;
	}

	@Override
	public Movies[] getallMovies() {
		// TODO Auto-generated method stub
		return movies;
	}

	@Override
	public Movies updatemoviedetails(String id, Movies s) {
		// TODO Auto-generated method stub
		int c=0;
		for(Movies s1:movies)
		{
			if(s1!=null && id.equals(s1.getId()))
			{
				movies[c]=s;
				return movies[c];
			}
			c+=1;
		
	}
		return null;
	}

}
