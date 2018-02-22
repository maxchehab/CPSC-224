
/* 
 * This program converts a string into a zigzag string.
 * CPSC 224-02, Spring 2018
 * Programming Assignment #2
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/02/18 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZIGZAG {

    /*
    * main runs the three different test cases to test the ZIGZAG_CONVERSION 
    * function and allows for user input.
    * 
    * @param String[] args, optional command line arguments.
    * @returns void
    * @throw null
    */
    public static void main(String[] args) {
        testZIGZAG("ABCDEFGH", 2);
        testZIGZAG("ABCDEFGHIJKLMNO", 3);
        testZIGZAG("HELLO WORLD", 5);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInput: ");
        String input = scanner.nextLine();
        System.out.print("Rows: ");
        int rows = Integer.parseInt(scanner.nextLine());
        testZIGZAG(input, rows);
        scanner.close();
    }

    /*
    * testZIGZAG prints out the result of ZIGZAG_CONVERSION
    * 
    * @param String input, the string input to be converted.
    * @param int rows, the amount of rows to be converted.
    * @returns void
    * @throw null
    */
    public static void testZIGZAG(String input, int rows) {
        System.out.println(ZIGZAG_CONVERSION(input, rows));
    }

    /*
    * ZIGZAG_CONVERSION takes a string input and converts it into a 
    * "zigzag" that is determined by the int rows passed into the 
    * function.
    * 
    * The algorithim uses a StringBuilder to compile the input
    * string into a zigzag pattern.
    * 
    * @param String inputA, the string input to be converted
    * @param int rows, the number of rows
    * @returns String 
    * @throw null
    */
    public static String ZIGZAG_CONVERSION(String input, int rows) {
        //Sanitize input
        input = input.replaceAll("\\s", "");

        //No need to convert if rows are less than 1.
        if (rows <= 1)
            return input;

        StringBuilder builder = new StringBuilder();
        //This calculates the size of the jump between index per row.
        int jump = (rows * 2) - 2;

        for (int i = 0; i < rows; i++) {
            //If the row is only the first and last row, we want place a character at each jump + 1 starting at the current row.
            if (i == 0 || i == rows - 1) {
                for (int j = i; j < input.length(); j = j + jump) {
                    builder.append(input.charAt(j));
                }
            } else {
                //Swap is used to alternate jumps.
                boolean swap = true;
                //Recalculate jumps per row. The jump needs to lower if rows is lower.
                int jumpA = (rows - 1 - i) * 2;
                int jumpB = jump - jumpA;

                for (int j = i; j < input.length();) {
                    builder.append(input.charAt(j));
                    if (swap)
                        j = j + jumpA;
                    else
                        j = j + jumpB;
                    swap = !swap;
                }
            }
        }

        return builder.toString();
    }
}
