package com.zee.zee5.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Series;
import com.zee.zee5.exception.NameNotFound;

public interface Series_Service1 {
	public String addSeries(Series s);
	public String deleteSeries(String id) throws NameNotFound;
	public Optional<Series> getSeriesdetails(String id) throws NameNotFound;
	public List<Series> getallSeries();
	public Series updateseriesdetails(String id,Series s) throws NameNotFound;
}
