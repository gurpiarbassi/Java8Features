package com.gurps.newstuff.streams;

import java.math.BigDecimal;

public class Student {

	private String name;
	private BigDecimal score;
	private Long year;
	
	
	public Student(String name, BigDecimal score, Long year) {
		super();
		this.name = name;
		this.score = score;
		this.year = year;
	}

	public String getName() {
		return name;
	}


	public BigDecimal getScore() {
		return score;
	}


	public Long getYear() {
		return year;
	}
}
