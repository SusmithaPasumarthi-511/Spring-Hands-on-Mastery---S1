package com.example.question.model;

import java.util.List;

public class PagingDetailsList {

	
	private int limits;
    private int totalnumberofpages;
    
    private List<PagingList> pagingList;
	public int getLimits() {
		return limits;
	}
	
	
	public void setLimits(int limits) {
		this.limits = limits;
	}
	public int getTotalnumberofpages() {
		return totalnumberofpages;
	}
	
	public void setTotalnumberofpages(int totalnumberofpages) {
		this.totalnumberofpages = totalnumberofpages;
	}
	public List<PagingList> getPagingList() {
		return pagingList;
	}
	public void setPagingList(List<PagingList> pagingList) {
		this.pagingList = pagingList;
	}
	
	public PagingDetailsList() {
		super();
		
	}
    
    
}
