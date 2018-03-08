
/* 
 * Game is in charge of user input and validation
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #5
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/08/18 
 */
import java.util.Scanner;
import java.util.Arrays;

public class Game {
    private final int diceAmount = 5;
    private Scanner scanner = new Scanner(System.in);
    private ScoreCard scoreCard = new ScoreCard();

    /*
    * Game constructor creates a new game and starts playing
    * 
    * @param null
    * @returns a new Game
    * @throw null
    */
    public Game() {
        this.play();
    }

    /*
    * Play continues to play the game forever unless the user intervenes
    * 
    * @param null
    * @returns null
    * @throw null
    */
    private void play() {
        do {
            Dice[] currentDices = rollDices(diceAmount);
            Arrays.sort(currentDices);
            System.out.println("Sorted hand: " + Dice.toString(currentDices));
            scoreCard.calculate(currentDices);
            System.out.println(scoreCard);
        } while (continuePlaying());
    }

    /*
    * continuePlaying checks if the user wants to continue playing
    * 
    * @param null
    * @returns boolean representing the user's decision
    * @throw null
    */
    private boolean continuePlaying() {
        System.out.print("Do you want to continue playing (y or n): ");
        return scanner.nextLine().charAt(0) == 'y';
    }

    /*
    * rollDices rolls n amount of dices up to three times
    * 
    * @param int diceAmount representing the amount of dices
    * @returns Dice[] representing the dice array
    * @throw null
    */
    private Dice[] rollDices(int diceAmount) {
        Dice[] output = new Dice[diceAmount];
        for (int i = 2; i > 0; i--) {
            output = Dice.roll(diceAmount);
            System.out.println("You rolled: " + Dice.toString(output));
            System.out.printf("Would you like to roll again? (%d remaining rolls) (y or n): ", i);
            if (scanner.nextLine().charAt(0) == 'n')
                return output;
        }
        return output;
    }

}