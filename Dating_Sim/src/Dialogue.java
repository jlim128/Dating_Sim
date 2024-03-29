/**
 * 
 * Dialogue class - class to contain a set of dialogue and choices
 * @author Jonathan Lim
 *
 */
public class Dialogue {
	private String dialogueBefore;
	private Choice[] choices = new Choice[4];
	
	/**
	 * Dialogue constructor - initializes the dialogue before and the choice array
	 * @param d - dialogue before the choice occurs
	 * @param c1 - choice 1
	 * @param c2 - choice 2
	 * @param c3 - choice 3
	 * @param c4 - choice 4
	 */
	public Dialogue(String d, Choice c1, Choice c2, Choice c3, Choice c4) {
		dialogueBefore = d;
		choices[0] = c1;
		choices[1] = c2;
		choices[2] = c3;
		choices[3] = c4;
	}
	
	/**
	 * Method to get the dialogue before the choice
	 * @return dialogue before the choice
	 */
	public String getDialogueBefore() {
		return dialogueBefore;
	}
	
	/**
	 * Method to get specific choice
	 * @param choiceNum - number of the choice
	 * @return choice text
	 */
	public String getChoice(int choiceNum) {
		return choices[choiceNum].getChoice();
	}
	
	/**
	 * Method to get all choices
	 * @return string containing all choices
	 */
	public String getChoices() {
		String choice = "";
		for(int i = 0; i < 4; i++) {
			choice += i + 1 + ") " + choices[i].getChoice() + "\n";
		}
		return choice;
	}
	
	/**
	 * Method to return the response of the given choice
	 * @param choiceNum - number of the choice
	 * @return the response
	 */
	public String getResponse(int choiceNum) {
		return choices[choiceNum].getResponse();
	}
	
	/**
	 * Method to return the love points of the given choice
	 * @param choiceNum - number of the choice
	 * @return the love points
	 */
	public int getLP(int choiceNum) {
		return choices[choiceNum].getLP();
	}
	
}
