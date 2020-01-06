package com.priyanshi.learn.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String message;

	public BadRequestException(String message) {
		super(message);
		this.message = message;
	}

	public BadRequestException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
