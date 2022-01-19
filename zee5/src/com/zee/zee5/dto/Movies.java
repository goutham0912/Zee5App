package com.zee.zee5.dto;

import lombok.Data;

@Data
public class Movies {
	private String moviename;
	private String category;
	private String releasedate;
	private String trailer;
	private String  language;
	private String cast[];
	private String length;
	private String id;
}
