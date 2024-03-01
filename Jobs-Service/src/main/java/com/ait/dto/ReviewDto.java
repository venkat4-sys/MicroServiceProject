package com.ait.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Integer id;
	
	private String title;
	
	private String description;
	
	private Double rating;

}
