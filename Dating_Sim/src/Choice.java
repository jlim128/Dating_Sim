/**
 * 
 * Choice class - class to hold information about a choice
 * @author Jonathan Lim
 *
 */
public class Choice {
	private String choice;
	private int lovePoint;
	private String response;
	
	/**
	 * Choice constructor - initializes the choice, response, and love points
	 * @param c - dialogue for the choice
	 * @param r - dialogue for the response
	 * @param p - points gained/lost for the choice
	 */
	public Choice(String c, String r, int p) {
		choice = c;
		lovePoint = p;
		response = r;
	}
	
	/**
	 * Method to return choice
	 * @return choice
	 */
	public String getChoice() {
		return choice;
	}
	
	/**
	 * Method to return response
	 * @return response
	 */
	public String getResponse() {
		return response;
	}
	
	/**
	 * Method to get love points
	 * @return love points
	 */
	public int getLP() {
		return lovePoint;
	}
}
