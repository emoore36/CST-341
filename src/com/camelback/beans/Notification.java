/**
 * 
 */
package com.camelback.beans;

/**
 * @author Eric Moore
 *
 */
public class Notification {

	private String message;

	/**
	 * A notification that will appear at the top of any form page to alert the user
	 * of any actions he/she has taken.
	 */
	public Notification() {
		message = "";
	}

	/**
	 * A notification that will appear at the top of any form page to alert the user
	 * of any actions he/she has taken.
	 * 
	 * @param message
	 *            The message String posted to the UI.
	 */
	public Notification(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
