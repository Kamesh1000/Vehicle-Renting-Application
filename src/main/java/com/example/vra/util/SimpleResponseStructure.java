package com.example.vra.util;

public class SimpleResponseStructure {
	private int status;
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static SimpleResponseStructure create(int status, String message) {
		SimpleResponseStructure structure = new SimpleResponseStructure();
		structure.setMessage(message);
		structure.setStatus(status);
		
		return structure;
	}
}
