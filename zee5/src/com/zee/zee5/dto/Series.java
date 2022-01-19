package com.zee.zee5.dto;

import lombok.Data;

@Data
public class Series {
	private String seriesid;
	private String name;
	private int no_seasons;
	private String cast[];
	private String episodenames[];
	
}

