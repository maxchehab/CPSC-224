
/* 
 * Dice is a representation of a random 6 sided dice.
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #6
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/22/18 
 */
import java.util.Random;

public class Dice implements Comparable<Dice> {
    private int value;

    /*
    * Dice sets a value to the dice's value
    * 
    * @param int value representing value of the dice
    * @returns Dice
    * @throw null
    */
    public Dice(int value) {
        this.value = value;
    }

    /*
    * getValue gets the value of the dice
    * 
    * @param null
    * @returns int representing the dice's value
    * @throw null
    */
    public int getValue() {
        return value;
    }

    /*
    * roll randomly rolls a dice of n length
    * 
    * @param int length representing the amount of dices
    * @returns Dice[] representing the dice array
    * @throw null
    */
    public static Dice[] roll(int length, int sides) {
        Dice[] dices = new Dice[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int randomInteger = random.nextInt(sides) + 1;
            dices[i] = new Dice(randomInteger);
        }
        return dices;
    }

    /*
    * toString converts an array of dices to a string
    * 
    * @param Dice[] representing the dices
    * @returns String representing the dice array as a string
    * @throw null
    */
    public static String toString(Dice[] dices) {
        String output = "[ ";
        for (Dice d : dices) {
            output += d + " ";
        }
        return output + "]";
    }

    /*
    * toString converts a dice to a string
    * 
    * @param null
    * @returns String representing the dice as a string
    * @throw null
    */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /*
    * compareTo compares the current dice with another one by value
    * 
    * @param Dice the other dice to compare with
    * @returns int representing the comparision
    * @throw null
    */
    public int compareTo(Dice d) {
        return this.getValue() - d.getValue();
    }
}