/* 
 * ScoreCardLine keeps track of a label and value for each line in a scorecard
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #6
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 3/22/18 
 */

public class ScoreCardLine {
    private String label;
    private int value;

    private Boolean isSet = false;

    /*
    * ScoreCardLine assigns a label to the ScoreCardLine
    * 
    * @param null
    * @returns ScoreCard
    * @throw null
    */
    public ScoreCardLine(String label) {
        this.label = label;
    }

    /*
    * set assigns a value to the line
    * 
    * @param int value
    * @returns null
    * @throw null
    */
    public void set(int value) {
        this.isSet = true;
        this.value = value;
    }

    /*
    * isSet checks if the line has been used
    * 
    * @param null
    * @returns Boolean 
    * @throw null
    */
    public Boolean isSet() {
        return this.isSet;
    }

    /*
    * toString converts a ScoreCardLine to a string
    * 
    * @param null
    * @returns String representing the converted ScoreCardLine
    * @throw null
    */
    @Override
    public String toString() {
        return "Score " + this.value + " on the " + this.label;
    }
}