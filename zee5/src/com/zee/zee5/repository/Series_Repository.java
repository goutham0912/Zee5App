package com.zee.zee5.repository;

import com.zee.zee5.dto.Movies;
import com.zee.zee5.dto.Series;

public class Series_Repository {
	Series[] series=new Series[10];
	private static int count=-1;
	private static Series_Repository series_rep;
	private Series_Repository()
	{
		
	}
	public static  Series_Repository getInstance()
	{
		if(series_rep==null)
		{
			series_rep=new Series_Repository();
			return series_rep;
		}
		return series_rep;
	}
	public String addSeries(Series s)
	{
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
	public String deleteSeries(String id)
	{
		int c=0;
		for(Series s:series)
		{
			
			if(s!=null && id.equals(s.getName()))
			{
				for(int i=c;i<series.length-2;i++)
				{
					series[i]=series[i+1];
					
				}
				for(Series s2:series)
				{
					System.out.println(s2);
				}
				return "Successfully deleted the series";
			}
			c+=1;
		}
		return "ID not found";
	}
	public Series getSeriesdetails(String id)
	{
		for(Series s:series)
		{
			if(s!=null && id.equals(s.getName()))
			{
				return s;
			}
		}
		return null;
		
	}
	public Series[] getallSeries() {
		return series;
	}
	public Series updateseriesdetails(String id,Series s)
	{

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
	public String[] getEpisodes(String moviename)
	{
		int c=0;
		for(Series s1:series)
		{
			if(s1!=null && moviename.equals(s1.getName()))
			{
				return s1.getEpisodenames();
			}
			c+=1;
		
	}
		return null;
	}
}
