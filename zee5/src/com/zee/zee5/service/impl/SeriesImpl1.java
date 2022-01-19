package com.zee.zee5.service.impl;

import com.zee.zee5.dto.Series;
import com.zee.zee5.repository.SeriesInterface;
import com.zee.zee5.repository.impl.SeriesImpl;
import com.zee.zee5.service.Series_Service1;
import com.zee.zee5.service.Subscription_Service1;

public class SeriesImpl1 implements Series_Service1 {
	SeriesInterface service1=SeriesImpl.getInstance();
	private static Series_Service1 service;
	private SeriesImpl1()
	{
		
	}
	public static Series_Service1 getInstance()
	{
		if(service==null)
		{
			service=new SeriesImpl1();
			return service;
		}
		return service;
	}

	@Override
	public String addSeries(Series s) {
		// TODO Auto-generated method stub
		return service1.addSeries(s);
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return service1.deleteSeries(id);
	}

	@Override
	public Series getSeriesdetails(String id) {
		// TODO Auto-generated method stub
		return service1.getSeriesdetails(id);
	}

	@Override
	public Series[] getallSeries() {
		// TODO Auto-generated method stub
		return service1.getallSeries();
	}

	@Override
	public Series updateseriesdetails(String id, Series s) {
		// TODO Auto-generated method stub
		return service1.updateseriesdetails(id, s);
	}

}
