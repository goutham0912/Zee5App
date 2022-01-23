package com.zee.zee5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Series;
import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.exception.InvalidAmountException;
import com.zee.zee5.exception.LocationNotFound;
import com.zee.zee5.exception.NameNotFound;
import com.zee.zee5.service.Movie_Service;
import com.zee.zee5.service.Movie_Service1;
import com.zee.zee5.service.Series_Service;
import com.zee.zee5.service.Series_Service1;
import com.zee.zee5.service.Subscription_Service;
import com.zee.zee5.service.Subscription_Service1;
import com.zee.zee5.service.impl.MoviesImpl1;
import com.zee.zee5.service.impl.SeriesImpl1;
import com.zee.zee5.service.impl.SubscriptionImpl1;

public class Main {
	public static void main(String[] args)
	{
//	Subscription_Service s_service1=Subscription_Service.getInstance();
	Subscription_Service1 s_service1=SubscriptionImpl1.getInstance();
	System.out.println("SUBSCRIPTION");
	for(int i=0;i<12;i++)
	{
		
		Subscriptions s=new Subscriptions();
		s.setAutorenewal("Yes");
		s.setDateofpurchase("18-06-2021");
		s.setExpirydate("18-06-2022");
		s.setId("g"+i);
		String value=s_service1.addSubscription(s);
		System.out.println(value);
	}
	String value1;
	try {
		value1 = s_service1.deleteSubscription("g3");
		System.out.println(value1);
	} catch (NameNotFound e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Optional<Subscriptions> s2;
	try {
		s2 = s_service1.getSubscription("g5");
		s2.get().setAutorenewal("No");
		s2.get().setDateofpurchase("18-05-2021");
		s2.get().setExpirydate("18-05-2022");
		Subscriptions value2=s_service1.updatesubscription("g5",s2.get());
		System.out.println(value2);
		int no=200;
		System.out.println(s2.get());
		s2.get().setAmount(no);
		
	} catch (NameNotFound | InvalidAmountException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	Optional<Subscriptions> value3;
	try {
		value3 = s_service1.getSubscription("g4");
		System.out.println(value3.get());
	} catch (NameNotFound e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

//	Subscriptions[] value4=s_service1.getallSubscription();
//	System.out.println("Subscription values");
//	for(Subscriptions s3:value4) {
//		System.out.println(s3);
//	}
	
//	Movie_Service ms=Movie_Service.getInstance();
	System.out.println("MOVIE");
	Movie_Service1 ms=MoviesImpl1.getInstance();
	Movies m=new Movies();
	
	m.setId("1");
	m.setLanguage("English");
	m.setMoviename("Avengers");
	m.setReleasedate("2014");
	String[] location= {"India","USA"};
	m.setAllowed_locations(Arrays.asList(location));
	String[] cast= {"A","B","C"};
	m.setCast(cast);
	Movies m1=new Movies();
	m1.setId("2");
	m1.setLanguage("English");
	m1.setMoviename("Avengers End Game");
	m1.setReleasedate("2019");
	String[] location1= {"USA"};
	m1.setAllowed_locations(Arrays.asList(location1));
	m1.setCast(cast);
	String value5=ms.addMovie(m1);
	String value6 =ms.addMovie(m);
	System.out.println(value5);
	System.out.println(value6);
	Optional<Movies> value7;
	String movie_status;
	try {
		movie_status = ms.watchmovie("Avengers End Game");
		System.out.println(movie_status);
	} catch (LocationNotFound | NameNotFound e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		value7 = ms.getMoviedetails("Avengers");
		System.out.println(value7.get());
		String value8 =ms.deleteMovie("Avengers End Game");
		System.out.println( value8+"------");
		System.out.println("movie details"+ value7.get());
	} catch (NameNotFound e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	}
	catch(LocationNotFound e1)
	{
		e1.printStackTrace();
	}
	m.setTrailer("http://www.youtube.com/avengers");
	Movies value9;
	try {
		value9 = ms.updatemoviedetails("Avengers",m);
		System.out.println("Updated details\n"+value9);
		
	
	} catch (NameNotFound | LocationNotFound e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	

	
	
	//Series
	System.out.println("SERIES");
//	Series_Service ss=Series_Service.getInstance();
	Series_Service1 ss=SeriesImpl1.getInstance();
	Series s6=new Series();
	s6.setSeriesid("1");
	s6.setName("Friends");
	s6.setNo_seasons(1);
	String [] episode_names= {"a","b","c"};
	s6.setEpisodenames(episode_names);
	Series s7=new Series();
	s7.setSeriesid("2");
	s7.setName("Office");
	s7.setNo_seasons(1);
	s7.setEpisodenames(episode_names);

	
	String value10=ss.addSeries(s7);
	String value11=ss.addSeries(s6);
	List<Series> value14=ss.getallSeries();
	System.out.println("values");
	for(Series k:value14)
		if(k!=null)
		System.out.println(k);
	System.out.println(value10);
	System.out.println(value11);
	Series value12;
	String[] friendscast= {"chandler","joey","ross"};
	s6.setCast(friendscast);
	try {
		value12 = ss.updateseriesdetails("Friends", s6);
		System.out.println("updatedseries\n"+value12);
	} catch (NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
	String value13;
	try {
		value13 = ss.deleteSeries("Friends");
		System.out.println(value13);
	} catch (NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	List<Series> value15=ss.getallSeries();
	System.out.println("After deletion");
	for(Series k:value15)
		if(k!=null)
		System.out.println(k);
	
	
}	
}