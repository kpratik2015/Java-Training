package com.pratik.training.collection;

import java.util.List;
import java.util.Scanner;

public class TestQuestionBank {
	public static void main(String[] args) {
		
		QuestionBank qBank = new QuestionBank();
		Question q1 = qBank.createQuestionWithOption("What is Java?", 
				2, 
				"Java is scripting language",
				"Java is programming langauge",
				"Java is a fruit",
				"Java is a database");
		
		
		qBank.addQuestion("Java", q1);
		
		Question q2 = qBank.createQuestionWithOption("Does Java have multiple inheritance?", 
				3, 
				"Yes",
				"Debatable/Maybe",
				"No");
		
		qBank.addQuestion("Java", q2);
		
		Question q3 = qBank.createQuestionWithOption("Do we have pointers in Java?", 
				3, 
				"Yes",
				"Debatable/Maybe",
				"No");
		
		qBank.addQuestion("Java", q3);
		
		List<Question> questions = qBank.getQuestions("Java");
		
		Scanner scanner = new Scanner(System.in);
		int score = 0; // final score
		int qno = 0;
		for(Question question : questions) {
			System.out.println("Q No. "+(++qno) + ". " + question.getQuestion());
			int optionNumber = 0;
			int check = 0;
			for(Option option : question.getOptions()) {
				System.out.println(++optionNumber + ". " + option.getOption());
				if(option.isRightAnswer())
					check = optionNumber;
			}
			System.out.println("Enter your choice (in number): ");
			int choice = scanner.nextInt();
			if(choice == check) {
				score += 5;
			}
		}
		
		System.out.println("You score: " + score + " out of " + qno*5);
	}
}
