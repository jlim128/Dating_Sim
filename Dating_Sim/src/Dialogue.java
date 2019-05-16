import javax.swing.JButton;
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
	public void getChoices(JButton[] op) {
		String choice = "";
		for(int i = 0; i < 4; i++) {
			if(choices[i].getChoice().length()>15) {
				op[i].setText( i + 1 + ") " + choices[i].getChoice().substring(0,7) + "\n" + choices[i].getChoice().substring(7,choices[i].getChoice().length()-1));
			}else {
				op[i].setText( i + 1 + ") " + choices[i].getChoice());
			}
		}
	}
	
	public void addToButton(JButton but, String txt) {
		if(txt.length() >=45) {
			txt = txt.substring(0,15) + "\n" + txt.substring(15,30) + "\n" + txt.substring(30, txt.length()-1);
		}
		but.setText(but.getText() + txt);
	}
	public void getResponses(JButton[] op) {
		String choice = "";
		for(int i = 0; i < 4; i++) {
			op[i].setText(choices[i].getResponse());
		}
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
