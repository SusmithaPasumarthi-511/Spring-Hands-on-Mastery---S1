package com.example.question.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_DEFAULT)
public class QuestionDetailsList {

	private int questionid;
    private String questionname;
    private String description;
    private int numberofvotes;
    private int numberofviews;
    private String createdon;
    private String modifiedon;
    private UsersDetails usersDetails;
  
    
    
	public String getModifiedon() {
		return modifiedon;
	}
	public void setModifiedon(String modifiedon) {
		this.modifiedon = modifiedon;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberofvotes() {
		return numberofvotes;
	}
	public void setNumberofvotes(int numberofvotes) {
		this.numberofvotes = numberofvotes;
	}
	public int getNumberofviews() {
		return numberofviews;
	}
	public void setNumberofviews(int numberofviews) {
		this.numberofviews = numberofviews;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	public UsersDetails getUsersDetails() {
		return usersDetails;
	}
	public void setUsersDetails(UsersDetails usersDetails) {
		this.usersDetails = usersDetails;
	}
    
    
    
}
