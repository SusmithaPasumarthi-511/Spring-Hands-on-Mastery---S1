package com.example.question.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_DEFAULT)
public class UsersDetails {

	
  private String username;
  private int reputationscore;
  private int numberofgoldbadges;
  
  private int numberofbronzebadges;
  private int numberofsilverbadges;
  
     
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getReputationscore() {
	return reputationscore;
}
public void setReputationscore(int reputationscore) {
	this.reputationscore = reputationscore;
}
public int getNumberofgoldbadges() {
	return numberofgoldbadges;
}
public void setNumberofgoldbadges(int numberofgoldbadges) {
	this.numberofgoldbadges = numberofgoldbadges;
}
public int getNumberofbronzebadges() {
	return numberofbronzebadges;
}
public void setNumberofbronzebadges(int numberofbronzebadges) {
	this.numberofbronzebadges = numberofbronzebadges;
}
public int getNumberofsilverbadges() {
	return numberofsilverbadges;
}
public void setNumberofsilverbadges(int numberofsilverbadges) {
	this.numberofsilverbadges = numberofsilverbadges;
}



public UsersDetails() {
	super();

}
  
  
  
	
}
