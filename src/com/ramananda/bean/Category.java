package com.ramananda.bean;

public class Category {
	private String title;
	private String state;

	
	public Category(String title) {
		this.title = title;
	}

	public Category(String title, String state) {
		this.title = title;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
