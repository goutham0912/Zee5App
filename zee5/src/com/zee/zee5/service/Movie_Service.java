package com.zee.zee5.service;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.repository.Movie_Repository;
import com.zee.zee5.repository.Subscription_Repo;

public class Movie_Service {
	private Movie_Repository repo_m=Movie_Repository.getInstance();
	private static Movie_Service m_service;
	private Movie_Service()
	{
		
	}
	public static Movie_Service getInstance()
	{
		if(m_service==null)
			m_service=new Movie_Service();
		return m_service;
	}
	public String addMovie(Movies s)
	{
		return this.repo_m.addmovie(s);
	}
	public String deleteMovie(String id)
	{
		return this.repo_m.deleteMovie(id);
	}
	public Movies getMoviedetails(String id)
	{
		return this.repo_m.getMoviedetails(id);
	}
	public Movies[] getallMovies()
	{
		
		return this.repo_m.getallMovies();	}
	public Movies updatemoviedetails(String id,Movies s)
	{
		return this.repo_m.updatemoviedetails(id, s);
	}
	public String[] getMovieCast(String id)
	{
		return this.repo_m.getMovieCast(id);
	}
}
