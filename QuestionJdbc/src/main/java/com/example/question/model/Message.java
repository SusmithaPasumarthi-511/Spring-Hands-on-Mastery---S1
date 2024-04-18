package com.example.question.model;

public class Message {
	
	private int code;
    private String desc;
    private String type;
    
    
	public Message(int code, String desc, String type) {
		super();
		this.code = code;
		this.desc = desc;
		this.type = type;
	}
    
	
	
	public Message() {

		
 }


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	
	
    
    
}
