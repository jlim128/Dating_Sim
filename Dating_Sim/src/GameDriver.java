import java.util.*;
import java.io.*;

public class GameDriver {
	private String charTextFiles[] = new String[] {"aristotle.txt", "hume.txt", 
		       "kant.txt", "schopenhauer.txt", "singer.txt"};
	private ArrayList<Character> characters = new ArrayList<Character> ();
	private Scanner input = new Scanner(System.in);
	private Character currentChar;
	
	/**
	 * 
	 */
	public void runGame() {
		inputChars();
		do {
			runOpening();
		} while (scenario() && characters.size() > 0);
		summary();
	}
	
	/**
	 * Method that takes all string files from CharTextFiles, and creates Character objects for Characters List
	 */
	public void inputChars() {
		for(int x = 0;x < charTextFiles.length;x++){
			characters.add(new Character(charTextFiles[x]));
		}
	}
	
	public void runOpening() {
		System.out.println("After a long week of school, you stayed up thinking about life and its complexities. When you arise, "
				+ "you have only one thought in your head, \'It's MATING SEASON!");
		int location = -1;
		System.out.println("\n\n============PICK A LOCATION #NUMBER============");
		for(int x =0; x < characters.size(); x++){
			System.out.println((x +1) + ") " + characters.get(x).getLocation());
		}
		System.out.println();
		System.out.print("Choose location number: ");
		location = reply(characters.size());
		currentChar = characters.get(location);
		System.out.println();
	}
	
	/**
	 * Method that insures that the user will reply
	 * @return user's int response
	 */
	public int reply(int numResponses) {
		int response = 0;
		while(response == 0 || response > numResponses) {
			try {
				response = Integer.parseInt(input.nextLine());
				if( response > numResponses) {
					System.out.print("Please enter a number from 1 to "+ numResponses + ":");
				}
			}catch(Exception e) {
				System.out.print("Please enter a number from 1 to "+ numResponses + ":");
			}
		}
		return response - 1;
	}
	
	/**
	 * Method that will play each character's scenario
	 */
	public boolean scenario() {
		for(int i = 0; i < currentChar.getStoryLength(); i++) {
			Dialogue d = currentChar.getDialogue(i);
			System.out.println(d.getDialogueBefore());
			System.out.println(d.getChoices());
			System.out.print("Enter your choice: ");
			int response = reply(4);
			System.out.println();
			System.out.println(d.getChoice(response));
			System.out.println(d.getResponse(response));
			currentChar.addLovePoints(d.getLP(response));
			System.out.println();
			if (currentChar.checkLose()) {
				if (i == 0) {
					characters.remove(currentChar);
				}
				return i == 0;
			}
		}
		return false;
	}
	
	/**
	* Method that will get a summary of your results
	*/
	public void summary() {
		if (characters.size() > 0) {
			System.out.println(currentChar.getEnding());
		}
		else {
			System.out.println("You missed out on everyone.");
		}
	}

}
