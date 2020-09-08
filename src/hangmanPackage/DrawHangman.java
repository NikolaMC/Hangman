package hangmanPackage;

public class DrawHangman {
	
	int attempts = 2;
	
	public static void draw(int attempts) {
		
		switch (attempts) {
			case 0: {
				println("");
				break;
			}
			case 1: {
				println("_|_");
				break;
			}
			case 2: {
				println(" | \n | \n | \n | \n | \n_|_");
				break;
			}
			case 3: {
				println(" ______\n | \n | \n | \n | \n | \n_|_");
				break;
			}
			case 4: {
				println(" ______\n |    | \n | \n | \n | \n | \n_|_");
				break;
			}
			case 5: {
				println(" ______\n |    | \n |    O \n | \n | \n | \n_|_");
				break;
			}
			case 6: {
				println(" ______\n |    | \n |    O \n |   /|\\ \n | \n | \n_|_");
				break;
			}
			case 7: {
				println(" ______\n |    | \n |    O \n |   /|\\ \n |   / \\ \n | \n_|_");
				break;
			}
		}
		
	}
	
	public static void println(String input) {
		System.out.println(input);
	}
	
}
