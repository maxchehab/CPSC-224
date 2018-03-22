
/* 
 * Game is in charge of user input and validation
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #6
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/22/18 
 */
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {
    private int diceAmount = 5;
    private int sidesAmount = 6;
    private int numberOfRolls = 3;
    private Scanner scanner = new Scanner(System.in);
    private ScoreCard scoreCard;

    /*
    * Game constructor creates a new game and starts playing
    * 
    * @param null
    * @returns a new Game
    * @throw null
    */
    public Game() {
        try {
            this.configure();
        } catch (FileNotFoundException f) {
            System.out.println("Could not find `yahtzeeConfig.txt`");
        }
        this.play();
    }

    /*
    * Configure loads the yahtzeeConfig file and allows the user to make changes
    * 
    * @param null
    * @returns null
    * @throw FileNotFoundException
    */
    private void configure() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("yahtzeeConfig.txt"));
        try {
            sidesAmount = scanner.nextInt();
            diceAmount = scanner.nextInt();
            numberOfRolls = scanner.nextInt();
        } finally {
            scanner.close();
        }

        System.out.printf("you are playing %d %d-sided dice\nyou get %d rolls per hand\n\n", diceAmount, sidesAmount,
                numberOfRolls);
        if (promptUser("enter 'y' if you would like to change the configuration: ")) {
            sidesAmount = promptInt("enter the number of sides on each die: ");
            diceAmount = promptInt("enter the number of dice in play: ");
            numberOfRolls = promptInt("enter the number of rolls per hand: ");
        }
        System.out.println();
        scoreCard = new ScoreCard(sidesAmount);
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
            Dice[] currentDices = rollDices(diceAmount, sidesAmount);
            Arrays.sort(currentDices);
            System.out.println("sorted hand: " + Dice.toString(currentDices));
            scoreCard.printAvailable();

            scoreCard.calculate(currentDices, promptInt("which line would you like to record: "), sidesAmount);
            System.out.println(scoreCard);
        } while (!scoreCard.complete());
    }

    /*
    * promptUser checks if a user returns a 'y' from a specific prompt
    * 
    * @param String prompt
    * @returns boolean representing the user's decision
    * @throw null
    */
    private boolean promptUser(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().charAt(0) == 'y';
    }

    /*
    * promptInt returns an integer specified from the user
    * 
    * @param String prompt
    * @returns int representing the user's input
    * @throw null
    */
    private int promptInt(String prompt) {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    /*
    * rollDices rolls n amount of dices up to three times
    * 
    * @param int diceAmount representing the amount of dices
    * @returns Dice[] representing the dice array
    * @throw null
    */
    private Dice[] rollDices(int diceAmount, int sidesAmount) {
        Dice[] output = new Dice[diceAmount];
        for (int i = numberOfRolls - 1; i > 0; i--) {
            output = Dice.roll(diceAmount, sidesAmount);
            System.out.println("you rolled: " + Dice.toString(output));
            System.out.printf("enter 'y' if you would like to roll again (%d remaining rolls): ", i);
            if (scanner.nextLine().charAt(0) == 'n')
                return output;
        }
        return output;
    }

}