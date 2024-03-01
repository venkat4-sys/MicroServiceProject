package com.ait.dto;

import lombok.Data;

@Data
public class Job {
	
    private Integer id;
	
	private String title;
	
	private String description;
	
	private String minSalary;
	
	private String maxSalary;
	
	private String location;
	

}
