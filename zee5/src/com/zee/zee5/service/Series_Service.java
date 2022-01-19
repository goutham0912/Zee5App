package com.zee.zee5.service;

import com.zee.zee5.dto.Series;
import com.zee.zee5.repository.Series_Repository;

public class Series_Service {
Series_Repository se_repo=Series_Repository.getInstance();
private static Series_Service se_service;
private Series_Service()
{
	
}
public static  Series_Service getInstance()
{
	if(se_service==null)
	{
		se_service=new Series_Service();
		return se_service;
	}
	return se_service;
}
public String addSeries(Series s)
{
	return this.se_repo.addSeries(s);
}
public String deleteSeries(String id)
{
	return this.se_repo.deleteSeries(id);
}
public Series getSeriesdetails(String id)
{
	return this.se_repo.getSeriesdetails(id);
}
public Series[] getallSeries() {
	return this.se_repo.getallSeries();
}
public Series updateseriesdetails(String id,Series s)
{

return this.se_repo.updateseriesdetails(id, s);
}
public String[] getEpisodes(String moviename)
{
	return this.se_repo.getEpisodes(moviename);
}
}
