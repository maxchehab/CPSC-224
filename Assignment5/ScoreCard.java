
/* 
 * ScoreCard keeps track and calculates a Yahtzee scorecard
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #5
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/08/18 
 */

import java.util.Map;
import java.util.LinkedHashMap;

public class ScoreCard {

    private Map<String, Integer> scoreCard = new LinkedHashMap<String, Integer>();

    /*
    * ScoreCard resets the score card.
    * 
    * @param null
    * @returns ScoreCard
    * @throw null
    */
    public ScoreCard() {
        this.reset();
    }

    /*
    * reset removes all the entries from the scorecard and 
    * re-initializes it with default values. 
    * 
    * @param null
    * @returns void
    * @throw null
    */
    private void reset() {
        scoreCard.clear();
        scoreCard.put("1 line", 0);
        scoreCard.put("2 line", 0);
        scoreCard.put("3 line", 0);
        scoreCard.put("4 line", 0);
        scoreCard.put("5 line", 0);
        scoreCard.put("6 line", 0);
        scoreCard.put("3 of a Kind line", 0);
        scoreCard.put("4 of a Kind line", 0);
        scoreCard.put("Full House line", 0);
        scoreCard.put("Small Straight line", 0);
        scoreCard.put("Yahtzee line", 0);
        scoreCard.put("Chance line", 0);
    }

    /*
    * calculate determines the score of the card based on an array of dice
    * 
    * @param Dice[] representing the dice array
    * @returns void
    * @throw null
    */
    public void calculate(Dice[] dices) {
        this.reset();

        int maxOfAKindFound = ScoreCard.maxOfAKindFound(dices);
        int totalOfDice = ScoreCard.totalOfDice(dices);
        int maxStraightFound = ScoreCard.maxStraightFound(dices);

        for (int i = 1; i <= 6; i++) {
            scoreCard.put(i + " line", countOfValueInDices(dices, i));
        }

        if (maxOfAKindFound >= 3) {
            scoreCard.put("3 of a Kind line", totalOfDice);
        }

        if (maxOfAKindFound >= 4) {
            scoreCard.put("4 of a Kind line", totalOfDice);
        }

        if (maxOfAKindFound >= 5) {
            scoreCard.put("Yahtzee line", 50);
        }

        if (fullHouseFound(dices)) {
            scoreCard.put("Full House line", 25);
        }

        if (maxStraightFound >= 4) {
            scoreCard.put("Small Straight line", 30);
        }

        if (maxStraightFound >= 5) {
            scoreCard.put("Large Straight line", 40);
        }

        scoreCard.put("Chance line", totalOfDice);
    }

    /*
    * toString converts a scorecard to a string
    * 
    * @param null
    * @returns String representing the converted scorecard
    * @throw null
    */
    @Override
    public String toString() {
        String output = "";
        for (Map.Entry entry : scoreCard.entrySet()) {
            output += "Score " + entry.getValue() + " on the " + entry.getKey() + "\n";
        }
        return output;
    }

    /*
    * countOfValueInDices counts the amount of times a value
    * appears in an array of dice
    * 
    * @param Dice[] representing the dice array, int representing the value
    * @returns int representing the count of occurences
    * @throw null
    */
    static int countOfValueInDices(Dice[] dices, int value) {
        int count = 0;
        for (Dice d : dices) {
            if (d.getValue() == value)
                count++;
        }

        return count;
    }

    /*
    * totalOfDice returns the sum of all dice values
    * 
    * @param Dice[] representing the dice array
    * @returns int representing the sum of all dice values
    * @throw null
    */
    static int totalOfDice(Dice[] dices) {
        int total = 0;
        for (Dice d : dices) {
            total += d.getValue();
        }

        return total;
    }

    /*
    * maxStraightFound finds the largest straight in an array
    * of dices
    * 
    * @param Dice[] representing the dice array
    * @returns int representing the largest straight
    * @throw null
    */
    static int maxStraightFound(Dice[] dices) {
        int maxLength = 1;
        int curLength = 1;
        for (int counter = 0; counter < 4; counter++) {
            if (dices[counter].getValue() + 1 == dices[counter + 1].getValue()) //jump of 1
                curLength++;
            else if (dices[counter].getValue() + 1 < dices[counter + 1].getValue()) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }

    /*
    * fullHouseFound determines if an array of dice contains
    * a full house
    * 
    * @param Dice[] representing the dice array
    * @returns boolean determining if a fullHouse was found
    * @throw null
    */
    static boolean fullHouseFound(Dice[] dices) {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;
        for (int dieValue = 1; dieValue <= dices.length + 1; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < dices.length; diePosition++) {
                if (dices[diePosition].getValue() == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }

    /*
    * maxOfAKindFound find the larges amount of any consecutive
    * value found within an array of dices
    * 
    * @param Dice[] representing the dice array
    * @returns int representing the largest kind
    * @throw null
    */
    static int maxOfAKindFound(Dice[] dices) {
        int maxValue = 0;
        int currentValue = 0;
        for (Dice dice : dices) {
            currentValue = 0;
            for (Dice d : dices) {
                if (dice.getValue() == d.getValue())
                    currentValue++;
            }
            if (currentValue > maxValue)
                maxValue = currentValue;
        }
        return maxValue;
    }
}