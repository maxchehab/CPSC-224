
/* 
 * ScoreCard keeps track and calculates a Yahtzee scorecard
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #6
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/22/18 
 */

public class ScoreCard {

    private ScoreCardLine[] scoreCard;

    /*
    * ScoreCard resets the score card.
    * 
    * @param null
    * @returns ScoreCard
    * @throw null
    */
    public ScoreCard(int diceSides) {
        this.reset(diceSides);
    }

    /*
    * reset removes all the entries from the scorecard and 
    * re-initializes it with default values. 
    * 
    * @param null
    * @returns void
    * @throw null
    */
    private void reset(int diceSides) {
        scoreCard = new ScoreCardLine[7 + diceSides];
        for (int i = 0; i < diceSides; i++) {
            scoreCard[i] = new ScoreCardLine((i + 1) + " line");
        }

        scoreCard[diceSides] = new ScoreCardLine("3 of a Kind line");
        scoreCard[1 + diceSides] = new ScoreCardLine("4 of a Kind line");
        scoreCard[2 + diceSides] = new ScoreCardLine("Yahtzee line");
        scoreCard[3 + diceSides] = new ScoreCardLine("Small Straight line");
        scoreCard[4 + diceSides] = new ScoreCardLine("Large Straight line");
        scoreCard[5 + diceSides] = new ScoreCardLine("Chance line");
        scoreCard[6 + diceSides] = new ScoreCardLine("Full House line");

    }

    /*
    * complete determines if the scorecard is complete
    * 
    * @param null
    * @returns Boolean representing completeness of the scorecard
    * @throw null
    */
    public Boolean complete() {
        for (ScoreCardLine line : scoreCard) {
            if (!line.isSet()) {
                return false;
            }
        }
        return true;
    }

    /*
    * calculate determines the score of the card based on an array of dice
    * 
    * @param Dice[] representing the dice array, int row representing the chosen row
    *        int diceSides representing the amount of sides per dice
    * @returns void
    * @throw null
    */
    public void calculate(Dice[] dices, int row, int diceSides) {

        if (scoreCard[row].isSet()) {
            return;
        }
        int maxOfAKindFound = ScoreCard.maxOfAKindFound(dices);
        int totalOfDice = ScoreCard.totalOfDice(dices);
        int maxStraightFound = ScoreCard.maxStraightFound(dices);

        scoreCard[row].set(countOfValueInDices(dices, row + 1));

        if (diceSides == row) {
            if (maxOfAKindFound >= 3) {
                scoreCard[row].set(totalOfDice);
            }
        }

        if (1 + diceSides == row) {
            if (maxOfAKindFound >= 4) {
                scoreCard[row].set(totalOfDice);
            }
        }

        if (2 + diceSides == row) {
            if (maxOfAKindFound >= 5) {
                scoreCard[row].set(50);
            }
        }

        if (3 + diceSides == row) {
            if (maxStraightFound >= 4) {
                scoreCard[row].set(30);
            }
        }

        if (4 + diceSides == row) {
            if (maxStraightFound >= 5) {
                scoreCard[row].set(40);
            }
        }

        if (5 + diceSides == row) {
            scoreCard[row].set(totalOfDice);
        }
        if (6 + diceSides == row) {
            if (fullHouseFound(dices)) {
                scoreCard[row].set(25);
            }
        }

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
        for (int i = 0; i < scoreCard.length; i++) {
            output += i + ") " + scoreCard[i] + "\n";
        }
        return output;
    }

    /*
    * printAvailable prints all the available lines of the scorecard
    * 
    * @param null
    * @returns null
    * @throw null
    */
    public void printAvailable() {
        for (int i = 0; i < scoreCard.length; i++) {
            if (!scoreCard[i].isSet()) {
                System.out.println(i + ") " + scoreCard[i]);
            }
        }
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
        for (int counter = 0; counter < dices.length - 1; counter++) {
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