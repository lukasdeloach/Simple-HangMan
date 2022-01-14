import java.util.Scanner; 

/**
 * Driver Class that contains the main method to run the game. 
 * @author Lukas_DeLoach
 * @version 12/06/2021
 */
public class Driver {
 
	/**
	 * Main method that calls the play method and runs the game. First runs the game then asks the user if they want to keep playing. 
	 * @param args
	 */
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
    
		play();
		System.out.println("PlAY AGAIN? Y/N");
		String userInput = scan.nextLine();
    
		while(userInput.equalsIgnoreCase("y"))
		{
			System.out.println();
			play();
			System.out.println("PlAY AGAIN? Y/N");
			userInput = scan.nextLine();
		}
		scan.close();
		System.out.println("THANKS FOR PLAYING!");

    
	}
 
	/**
	 * Name: play
	 * Method that prints heading, creates a Game object, and calls and calls the external Game method runGame.
	 */
	public static void play()
	{
		System.out.println("\t~ HANGMAN ~");
		System.out.println("\t~ AUTHOR: LUKAS DELOACH ~");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		Game game = new Game();
		game.runGame();
	}
}
