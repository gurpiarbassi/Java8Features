package com.gurps.newstuff.streams;


public class Student {

	private String name;
	private int score;
	private Long year;
	
	
	public Student(String name, int score, Long year) {
		super();
		this.name = name;
		this.score = score;
		this.year = year;
	}

	public String getName() {
		return name;
	}


	public int getScore() {
		return score;
	}


	public Long getYear() {
		return year;
	}
}
