package com.ait.dto;

import java.util.List;

import lombok.Data;

@Data
public class JobWithCompany {
	
	private Job job;
	private Company company;
	private List<ReviewDto> review;

}
