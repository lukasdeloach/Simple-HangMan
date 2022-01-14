import java.util.ArrayList;
import java.util.Random;

/**
 * Words Class that holds a collection of words with 3 methods and one constructor. 
 * @author Lukas_DeLoach
 * @version 12/05/2021
 */
public class Words {
 
  private ArrayList<String> words; 
  private Random random = new Random();
 
  /**
   * Constructor for Class Words. Instantiates the words field and then adds values to it. 
   */
  public Words()
  {
     words = new ArrayList<String>();
     words.add("apple");
     words.add("microsoft");
     words.add("java");
     words.add("python");
     words.add("object");
     words.add("final");
  }
 
  /**
   * Name: getWords
   * Getter method of type ArrayList<String> that returns words
   * @return words
   */
  public ArrayList<String> getWords()
  {
     return words;
  }
 
  /**
   * Name: addWord 
   * Mutator method that adds a word to the collection of words.
   * @param word
   */
  public void addWord(String word)
  {
     if(word != null)
     {
        words.add(word);
     }
  }
 
  /**
   * Name: getRandomWord
   * Getter method that returns a random word from the collection of words within the bounds of the size of words
   * @return words.get(random.nextInt(words.size()))
   */
  public String getRandomWord()
  {
     return words.get(random.nextInt(words.size()));
  }
}