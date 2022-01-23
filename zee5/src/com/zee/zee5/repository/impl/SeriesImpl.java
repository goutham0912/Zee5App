package com.zee.zee5.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Series;
import com.zee.zee5.exception.NameNotFound;
import com.zee.zee5.repository.SeriesInterface;
import com.zee.zee5.repository.Series_Repository;

public class SeriesImpl implements SeriesInterface {
	TreeSet<Series> series=new TreeSet<>();
	private static int count=-1;
	private static SeriesInterface seriesrepo;
	private SeriesImpl()
	{
		
	}
	public static  SeriesInterface getInstance()
	{
		if(seriesrepo==null)
		{
			seriesrepo=new SeriesImpl();
			return seriesrepo;
		}
		return seriesrepo;
	}
	@Override
	public String addSeries(Series s) {
		// TODO Auto-generated method stub
		boolean result=series.add(s);
		if(result)
		{
			return "Series added successfully";
		}
		else {
			return "Series not added";
		}
	}

	@Override
	public String deleteSeries(String name) throws NameNotFound {
		// TODO Auto-generated method stub
Optional<Series> m=getSeriesdetails(name);
		
		if(m.isPresent())
		{
			boolean result=	series.remove(m.get());
			if(result)
			return "Successfully deleted";
			else
			{
			 return "Series Deletion Failed";
			}
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
	}

	@Override
	public Optional<Series> getSeriesdetails(String name) throws NameNotFound {
		// TODO Auto-generated method stub
		Series m=null;
		for(Series s:series)
		{
			if(name.equals(s.getName()))
			{
				m=s;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(m).orElseThrow(()->new NameNotFound("movie does not exist")));
	}

	@Override
	public List<Series> getallSeries() {
		// TODO Auto-generated method stub
		return new ArrayList(series);
	}

	@Override
	public Series updateseriesdetails(String name, Series s) throws NameNotFound {
		// TODO Auto-generated method stub
Optional<Series> m=getSeriesdetails(name);
		
		if(m.isPresent())
		{
			boolean result=	series.remove(m.get());
			series.add(s);
			
			return s;
			
			
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
	}

}
