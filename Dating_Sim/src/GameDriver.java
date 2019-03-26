import java.util.*;
import java.io.*;

public class GameDriver {
	private Scanner input = new Scanner(System.in);
	private ArrayList<Character> Characters = new ArrayList<Character> ();
	private ArrayList<String> ChartextFiles = new ArrayList<String> (Arrays.asList("aristotle.txt", "friere.txt", "hume.txt", 
										       "kant.txt", "schopenhauer.txt", "singer.txt"));
	
	public static void main(String[] args) {
		System.out.println("After a long week of school, you stayed up thinking about life and its complexities. When you arise, "
				+ "you have only one thought in your head, 'It's MATING SEASON!");
		System.out.println("\n\n\n\n\n\n============PICK A LOCATION #NUMBER============");
		for(x =0;x < Characters.size();x++){
			System.println((x +1) + ") " + Characters.get(x).getLocation());
		}
		int response = input.nextInt();
		
	}

}
