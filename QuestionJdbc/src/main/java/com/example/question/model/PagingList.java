package com.example.question.model;

public class PagingList {
	
	String id;
    int pagenumber;
    
    
    
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	
	
	
	public PagingList(String id, int pagenumber) {
		super();
		this.id = id;
		this.pagenumber = pagenumber;
	}
	
	
	public PagingList() {
		super();
	}

    
    
}
