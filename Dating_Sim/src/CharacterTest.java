
public class CharacterTest {
	public static void main(String[] args) {
		Character test = new Character("test", "testing site", "singer.txt", new Checkpoint(1, 1), new Checkpoint(2, 2));
		for(int i = 0; i < test.story.size(); i++) {
			Dialogue d = test.getDialogue(i);
			System.out.println(d.getDialogueBefore());
			System.out.println(d.getChoices());
			for(int j = 1; j <= 4; j++) {
				System.out.println(d.getResponse(j));
				System.out.println(d.getLP(j));
			}
			System.out.println();
		}
	}
}
