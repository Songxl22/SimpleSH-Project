/**
 * 
 */
package com.codingyun.core.exception;

import org.springframework.core.NestedRuntimeException;

public class DaoException extends NestedRuntimeException {

	private static final long serialVersionUID = 4027668633550746774L;

	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
