package com.zee.zee5.repository.impl;

import com.zee.zee5.dto.Series;
import com.zee.zee5.repository.SeriesInterface;
import com.zee.zee5.repository.Series_Repository;

public class SeriesImpl implements SeriesInterface {
	Series[] series=new Series[10];
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
		if(count==series.length-1)
		{
			Series[] temp=new Series[series.length*2];	
			System.arraycopy(series, 0, temp, 0, series.length);
			series=temp;
			series[++count]=s;
			return "Success";
			}
		series[++count]=s;
		return "Success";
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		int c=0;
		for(Series s:series)
		{
			
			if(s!=null && id.equals(s.getName()))
			{
				for(int i=c;i<series.length-2;i++)
				{
					series[i]=series[i+1];
					
				}
				series[series.length-1]=null;
				return "Successfully deleted the series";
			}
			c+=1;
		}
		return "ID not found";
	}

	@Override
	public Series getSeriesdetails(String id) {
		// TODO Auto-generated method stub
		for(Series s:series)
		{
			if(s!=null && id.equals(s.getName()))
			{
				return s;
			}
		}
		return null;
	}

	@Override
	public Series[] getallSeries() {
		// TODO Auto-generated method stub
		return series;
	}

	@Override
	public Series updateseriesdetails(String id, Series s) {
		// TODO Auto-generated method stub
		int c=0;
		for(Series s1:series)
		{
			if(s1!=null && id.equals(s1.getSeriesid()))
			{
				
				series[c]=s;
				
				return series[c];
				
				
			}
			c+=1;
		
	}
		return null;
	}

}
