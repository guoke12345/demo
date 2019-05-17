package com.springboot.common.exception;

public class DBException extends RuntimeException{

	/**
	 * @Fields serialVersionUID : default
	*/ 
	private static final long serialVersionUID = 1L;
	
	public DBException(String message) {
		super(message,new Throwable());
	}


	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
	
}