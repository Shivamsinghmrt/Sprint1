package com.capgemini.go.exception;

public class RetailerException extends RuntimeException {
	public RetailerException(String msg) {
		System.err.println(msg);
	}

}
