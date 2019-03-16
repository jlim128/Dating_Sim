
public class DialogueTest {
	public static void main(String[] args) {
		Dialogue d = new Dialogue("Hi", new Choice("Hi", "Bye", 1), new Choice("Hello", "Bye Bye", 0),
									new Choice("Herro", "Bee Bee", 2), new Choice("Henlo", "Adios", 3));
		System.out.println(d.getDialogueBefore());
		System.out.println(d.getChoices());
		for(int i = 1; i <= 4; i++) {
			System.out.println(d.getResponse(i));
			System.out.println(d.getLP(i));
		}
	}
}
