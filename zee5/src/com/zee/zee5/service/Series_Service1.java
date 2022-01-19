package com.zee.zee5.service;

import com.zee.zee5.dto.Series;

public interface Series_Service1 {
	public String addSeries(Series s);
	public String deleteSeries(String id);
	public Series getSeriesdetails(String id);
	public Series[] getallSeries();
	public Series updateseriesdetails(String id,Series s);
}
