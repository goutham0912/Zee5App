package com.zee.zee5.dto;

import lombok.Data;

@Data
public class Series implements Comparable<Series> {
	private String seriesid;
	private String name;
	private int no_seasons;
	private String cast[];
	private String episodenames[];
	private String no_episodes;
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.seriesid.compareTo(o.getSeriesid());
	}
	
}

