package com.pratik.training.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
	
	private Map<String, List<Question>> questionBank; 
	
	public QuestionBank() {
		questionBank = new HashMap<>(); // gives null pointer exception if not done.
		questionBank.put("Java", new ArrayList<>());
		questionBank.put(".NET", new ArrayList<>());
	}
	
	public Question createQuestionWithOption(String question, int rightAnswer, String ...options) {
		Question qestions = new Question(question);
		List<Option> listOfOptions = new ArrayList<>();
		
		for(int i = 0 ; i < options.length ; i++) {
			boolean isRightAnswer = false;
			if(i == rightAnswer - 1) 
				isRightAnswer = true;
			Option option = new Option(options[i], isRightAnswer);
			listOfOptions.add(option);
		}
		qestions.setOptions(listOfOptions);
		return qestions;
	}
	
	public void addQuestion(String subject, Question question) {
		List<Question> questions = questionBank.get(subject);
		questions.add(question);
	}
	
	public List<Question> getQuestions(String subject) {
		return questionBank.get(subject);
	}
	
}
