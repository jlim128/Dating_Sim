import java.util.*;
import java.io.*;

public class GameDriver {
	private static String CharTextFiles[] = new String[] {"aristotle.txt", "friere.txt", "hume.txt", 
		       "kant.txt", "schopenhauer.txt", "singer.txt"};
	private static ArrayList<Character> Characters = new ArrayList<Character> ();
	private static Scanner input = new Scanner(System.in);
	private static Character currentChar;
	private static ArrayList<String> saidYes = new ArrayList<String> ();
	
	
	
	/**
	 * MAIN DRIVER METHOD
	 * @param args
	 */
	public static void main(String[] args) {
		inputChars();
		System.out.println("After a long week of school, you stayed up thinking about life and its complexities. When you arise, "
				+ "you have only one thought in your head, \'It's MATING SEASON!");
		
		do {
			System.out.println("\n\n============PICK A LOCATION #NUMBER============");
			for(int x =0;x < Characters.size();x++){
				System.out.println((x +1) + ") " + Characters.get(x).getLocation());
			}
			int resp = reply();
			currentChar = Characters.get(resp);
			scenario();
			Characters.remove(resp);
		}while(Characters.size() != 0);
		summary();

	}
	
	/**
	 * Method that takes all string files from CharTextFiles, and creates Character objects for Characters List
	 */
	public static void inputChars() {
		for(int x = 0;x< CharTextFiles.length;x++){
			Characters.add(new Character(CharTextFiles[x]));
		}
	}
	
	/**
	 * Method that insures that the user will reply
	 * @return user's int response
	 */
	public static int reply() {
		int response = 0;
		while(response ==0) {
			try {
				System.out.print("\nResponse BRO?: ");
				response = input.nextInt();
			
			}catch(Exception e) {
				System.out.println("Please enter a number from 1 to "+ Characters.size());
			}
		}
		return response;
	}
	
	/**
	 * Method that will play each character's scenario
	 */
	public static void scenario() {
		int response;
		Dialogue currentDia;
		int points = 0;
		for(int x = 0;x<currentChar.getStoryLength(); x++){ 
			currentDia = currentChar.getDialogue(x);
			currentDia.getChoices();
			response = reply();
			currentDia.getResponse(response);
			points += currentDia.getLP(response);
		}
		if(points >= currentChar.getLovePoints()) {
			saidYes.add(currentChar.getName());
		}else {
			System.out.println("Ya hate to see it...");;
		}
		
	}
	
	/**
	* Method that will get a summary of your results
	*/
	public static void summary() {
		System.out.print("After a long day of mingling and floiting, you take out your phone and review the pictures you took today."+
							"\n\n>>>>>>>>>>SUMMARY<<<<<<<<<<\n-You were able to seduce: ");
		for(int x = 0;x<saidYes.size();x++) {
			if(x==saidYes.size()-1) {
				System.out.print(saidYes.get(x));
			}else {
				System.out.print(saidYes.get(x) + ", ");
			}
		}
		System.out.println("\nAfter carfully acessing your decisions, we, the game developers, believe that you are...(enter anything to see results)");
		input.next();
		while(input.next().length() == 0) {
		}
		if(saidYes.size() == 6) {
			System.out.println("A true pleb king, who will always be with a woman, but never have a ring...");
		} else if(saidYes.size() >3) {
			System.out.println("A certified pled, who is ready to woo any female.");
		} else if(saidYes.size() ==1) {
			System.out.println("a true lover, one who is devoted to a specific philosphy/ideology.");
		}else {
			System.out.println("a teeny bopper. Get outta my face, GOMF.");
		}
	}

}
