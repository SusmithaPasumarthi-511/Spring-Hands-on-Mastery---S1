package com.example.question.model;

public class Response {
	
	private Message message;
    private Question question;
    private Questions questions;
   
    
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question2) {
		this.question = question2;
	}
	   


	public Response() {
		super();

		
	}
    
    
	public Questions getQuestions() {
		return questions;
	
}
}
