import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game class that contains a constructor and two methods. 
 * @author Lukas_DeLoach
 * @version 12/05/2021
 */
public class Game {
 
  private Words words;
  private String word;
  private final int totalGuesses = 5;
  private boolean won;
  private Scanner scanner;
  private int count;
  private String userInput;
  private ArrayList<Character> lettersGuessed;
  
  /**
   * Constructor for class Game. Creates Words object, Scanner object, instantiates an ArrayList of Characters,
   * sets the count to one, and sets a string, word, to a random word from the collection of words. 
   */
  public Game()
  {
     words = new Words();
     scanner = new Scanner(System.in);
     count = 1;
     word = words.getRandomWord();
     lettersGuessed = new ArrayList<>();
  }
 
  /**
   * Name: runGame
   * First greets the user. Then goes into a loop checking that the incorrect guess count is less than the total allowed
   * guesses. Then runs the formatWord method while making sure the user has not won. makes sure that the user has not won. 
   * Then calls the internal method to see if the game is won. Asks the user to guess a letter and then
   *  adds that letter to an collection of letters.
   */
  public void runGame()
  {
     System.out.println("Hello user! Thank you for playing.");
     System.out.println("You are allowed 5 incorrect guesses before you lose.");
     System.out.println();
    
     while(count <= totalGuesses && !won)
     {
        if(formatWord(word, lettersGuessed) == true)
        {
           System.out.println("CONGRATS...YOU WIN!");
           won = true;
           break;
        }
        System.out.println("Please guess a missing letter:");
        userInput = scanner.nextLine();
        while(userInput.isEmpty())
        {
        	System.out.println("No guess provided. Please guess again!");
        	userInput = scanner.nextLine();
        }
        
        lettersGuessed.add(userInput.charAt(0));
        wordCheckAndMessage();
        
        if(count>totalGuesses)
        {
           System.out.println("Your word was " + word);
           System.out.println("Better luck next time...");
           System.out.println();
           break;
        }
     }
  }
 
  /**
   * Name: formatWord method
   * Method that prints the first letter of the hidden word and underscores for each following missing letter.
   * Then checks to see if the collection of letters contains the letter of the word at the given index. Else then prints
   * an underscore at the given index. 
   * @param word
   * @param lettersGuessed
   * @return word.length()-1 == guessedCorrect - Boolean value (true or false)
   */
  private boolean formatWord(String word, ArrayList<Character> lettersGuessed)
  {
     System.out.print(word.substring(0, 1));
     int guessedCorrect = 0;
     for (int i = 1; i < word.length(); i++)
     {
        if(lettersGuessed.contains(word.charAt(i)))
        {
           System.out.print(" " + word.charAt(i));
           guessedCorrect++;
        }
        else
        {
           System.out.print(" _");
        }
     }
     System.out.println();
     return (word.length()-1 == guessedCorrect);
  }
  
  /**
   * Name: wordCheckAndMessage
   * Private void method that checks if the word contains the input the user entered. If it does, prints a message.
   * If it does not increments the count and tells the user how many guessed there are left. 
   */
  private void wordCheckAndMessage()
  {
	  if(word.contains(userInput))
      {
         System.out.println("Correct!");
      }
     
      else
      {
         System.out.println("*Incorrect*" );
         count++;
         if ((6-count)==1)
         {
      	   System.out.println("You have " + (6-count) + " guess left.");
         }
         else
         {
      	   System.out.println("You now have " + (6-count) + " guesses left.");
         }
      }
  }
}
