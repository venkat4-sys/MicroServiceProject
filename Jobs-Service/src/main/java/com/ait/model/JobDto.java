package com.ait.model;

import lombok.Data;

@Data
public class JobDto {
	private Integer id;

	private String title;

	private String description;

	private String minSalary;

	private String maxSalary;

	private String location;
	
	private Integer companyId;

}
