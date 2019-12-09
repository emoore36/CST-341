package com.camelback.util;

public class DatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5623776766017125741L;

	/**
	 * An instance of the Database Exception
	 * 
	 * @param cause
	 *            The cause of the exception.
	 */
	public DatabaseException(Throwable cause) {

		// do what the superclass does
		super(cause);
	}

}
