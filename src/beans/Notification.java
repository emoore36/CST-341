/**
 * 
 */
package beans;

/**
 * @author Eric Moore
 *
 */
public class Notification {

	private int action;
	private int result;
	private Object model;

	/**
	 * A notification that will appear at the top of any form page to alert the user
	 * of any actions he/she has taken.
	 */
	public Notification() {
		action = 0;
		result = 0;
		model = null;
	}

	/**
	 * A notification that will appear at the top of any form page to alert the user
	 * of any actions he/she has taken.
	 * 
	 * @param action
	 *            int - The CRUD action taken. 0 = Create, 1 = Read, 2 = Update, 3 =
	 *            Delete
	 * @param result
	 *            int - Whether the action was successful or not. 0 = Fail, 1 =
	 *            Success
	 * @param model
	 *            Object - The model involved in the CRUD action. Can be a user, a
	 *            product, and order, or even nothing (in case of page navigation).
	 */
	public Notification(int action, int result, Object model) {
		this.action = action;
		this.result = result;
		this.model = model;
	}

	/**
	 * @return the action
	 */
	public int getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return the model
	 */
	public Object getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(Object model) {
		this.model = model;
	}

	/**
	 * The message to be displayed based on the current instance of the
	 * Notification.
	 * 
	 * @return String - "[action] of [model] [result]." Example: "Creation of User
	 *         successful."
	 */
	public String message() {

		String str = "";

		// update text based on the action
		switch (action) {
		case 0:
			str += "Creation";
			break;
		case 1:
			str += "Read";
			break;
		case 2:
			str += "Update";
			break;
		case 3:
			str += "Deletion";
			break;
		}

		str += " of ";

		// update text based on the model
		if (model != null)
			str += " " + model.toString();
		else
			str += "";

		// update text based on the result
		if (result == 1)
			str += " successful.";
		else
			str += " failed.";

		return str;
	}

}
