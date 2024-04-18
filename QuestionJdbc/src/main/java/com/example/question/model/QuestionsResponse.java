package com.example.question.model;

import java.util.List;

public class QuestionsResponse {

	private long totalNoOfQuestions;
	
	
	public long getTotalNoOfQuestions() {
		return totalNoOfQuestions;
	}
	public void setTotalNoOfQuestions(long totalNoOfQuestions) {
		this.totalNoOfQuestions = totalNoOfQuestions;
	}
	


	private List<QuestionDetailsList> questionDetailsList;

	public List<QuestionDetailsList> getQuestionDetailsList() {
		return questionDetailsList;
	}

	public void setQuestionDetailsList(List<QuestionDetailsList> questiondetaillist) {
		this.questionDetailsList = questiondetaillist;
	}

}



 