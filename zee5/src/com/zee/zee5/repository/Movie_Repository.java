package com.zee.zee5.repository;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Subscriptions;

public class Movie_Repository {
	Movies[] movies=new Movies[10];
	private static int count=-1;
	private static Movie_Repository movie_repo;
	private Movie_Repository() {
		
	}
	public static Movie_Repository getInstance()
	{
		if(movie_repo==null)
		{
			movie_repo=new Movie_Repository();
			return movie_repo;
		}
		return movie_repo;
	}
	public String addmovie(Movies m)
	{
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
	public String deleteMovie(String id)
	{
		int c=0;
		for(Movies s:movies)
		{
			if(id.equals(s.getId()))
			{
				for(int i=c;i<movies.length-2;i++)
				{
					movies[i]=movies[i+1];
					
				}
				
				return "Successfully deleted the movie";
			}
			c+=1;
		}
		return "ID not found";
	}
	public Movies getMoviedetails(String name)
	{
		for(Movies s:movies)
		{
			if(s!=null && name.equals(s.getMoviename()))
			{
				return s;
			}
		}
		return null;
		
	}
	public String[] getMovieCast(String moviename)
	{
		for(Movies s:movies)
		{
			if(s!=null && moviename.equals(s.getMoviename()))
			{
				return s.getCast();
			}
		}
		return null;
		
	}
	public Movies[] getallMovies() {
		return movies;
	}
	public Movies updatemoviedetails(String id,Movies s)
	{

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
