package com.zee.zee5;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Series;
import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.service.Movie_Service;
import com.zee.zee5.service.Series_Service;
import com.zee.zee5.service.Subscription_Service;

public class Main {
	public static void main(String[] args)
	{
	Subscription_Service s_service1=Subscription_Service.getInstance();
	
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
	String value1 =s_service1.deleteSubscription("g3");
	System.out.println(value1);
	Subscriptions s2=s_service1.getSubscription("g5");
	s2.setAutorenewal("No");
	s2.setDateofpurchase("18-05-2021");
	s2.setExpirydate("18-05-2022");
	Subscriptions value2=s_service1.updatesubscription("g5",s2);
	System.out.println(value2);
	Subscriptions value3=s_service1.getSubscription("g4");
	System.out.println(value3);
//	Subscriptions[] value4=s_service1.getallSubscription();
//	System.out.println("Subscription values");
//	for(Subscriptions s3:value4) {
//		System.out.println(s3);
//	}
	
	Movie_Service ms=Movie_Service.getInstance();
	Movies m=new Movies();
	m.setId("1");
	m.setLanguage("English");
	m.setMoviename("Avengers");
	m.setReleasedate("2014");
	String[] cast= {"A","B","C"};
	m.setCast(cast);
	Movies m1=new Movies();
	m1.setId("2");
	m1.setLanguage("English");
	m1.setMoviename("Avengers End Game");
	m1.setReleasedate("2019");
	m1.setCast(cast);
	String value5=ms.addMovie(m1);
	String value6 =ms.addMovie(m);
	System.out.println(value5);
	System.out.println(value6);
	Movies value7=ms.getMoviedetails("Avengers");
	System.out.println("movie details"+ value7);
	String value8 =ms.deleteMovie("2");
	System.out.println( value8);
	m.setTrailer("movie link");
	Movies value9=ms.updatemoviedetails("1",m);
	System.out.println("Updated details\n"+value9);
	
	//Series
	Series_Service ss=Series_Service.getInstance();
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
	Series[] value14=ss.getallSeries();
	System.out.println("values");
	for(Series k:value14)
		System.out.println(k);
	System.out.println(value10);
	System.out.println(value11);
	Series value12=ss.updateseriesdetails("1", s6);
	String[] friendscast= {"chandler","joey","ross"};
	s6.setCast(friendscast);
	System.out.println("updatedseries\n"+s7);
	System.out.println("next");
	String value13=ss.deleteSeries("Friends");
	System.out.println(value13);
	
}	
}