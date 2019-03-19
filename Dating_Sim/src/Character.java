import java.util.*;
import java.io.*;

/**
 * Character class - class to contain information about a character
 * @author Jonathan Lim
 *
 */
public class Character {
	private ArrayList <Dialogue> story = new ArrayList <Dialogue> ();
	private String name;
	private int lovePoints = 0;
	private String location;
	private int checkPoint1;
	private int checkPoint2;
	
	/**
	 * Character constructor - initializes name, location and loads dialogue from the file
	 * @param n - name
	 * @param l - location
	 * @param fileName - name of file with dialogue
	 */
	public Character(String n, String l, String fileName, int checkPoint) {
		name = n;
		location = l;
		checkPoint1 = checkPoint;
		checkPoint2 = 3 * checkPoint1; //3 can be changed
		loadText(fileName);
	}
	
	/**
	 * Method to get name of character
	 * @return character's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to get location of character
	 * @return character's location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Method to get current love points
	 * @return current love points of character
	 */
	public int getLovePoints() {
		return lovePoints;
	}
	
	/**
	 * Method to get selected dialogue
	 * @param dialogueNum - number where the dialogue is
	 * @return the dialogue selected
	 */
	public Dialogue getDialogue(int dialogueNum) {
		return story.get(dialogueNum);
	}
	
	private void loadText(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			while(in.hasNext()) {
				String d = in.nextLine();
				Choice c1 = new Choice(in.nextLine(), in.nextLine(), in.nextInt());
				in.nextLine();
				Choice c2 = new Choice(in.nextLine(), in.nextLine(), in.nextInt());
				in.nextLine();
				Choice c3 = new Choice(in.nextLine(), in.nextLine(), in.nextInt());
				in.nextLine();
				Choice c4 = new Choice(in.nextLine(), in.nextLine(), in.nextInt());
				in.nextLine();
				story.add(new Dialogue(d, c1, c2, c3, c4));
			}
		}
		catch(FileNotFoundException e) {
			System.out.print("File not found");
		}
	}
	
}
