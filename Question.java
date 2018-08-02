package com.pratik.training.collection;

import java.util.List;

public class Question {
	
	private String question;
	private List<Option> options;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Question(String question) {
		super();
		this.question = question;
	}

	
	
	
}
