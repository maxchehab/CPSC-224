
/* 
 * This program computes if two strings are anagrams of each other.
 * CPSC 224-02, Spring 2018
 * Programming Assignment #1
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 1/18/18 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramCheck {

    /*
     * main runs the three different test cases to test the isAnagram 
     * function.
     * 
     * @param String[] args, optional command line arguments.
     * @returns void
     * @throw null
     */
    public static void main(String[] args) {
        System.out.println("Automating tests running");
        testAnagram("hello", "olleh");
        testAnagram("hello", "world");
        testAnagram("hello", "worlsadfdfd");
        testAnagram("rail safety", "fairy tales");

        System.out.println("\nYou may compare any two strings.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("String #1: ");
        String inputA = scanner.nextLine();

        System.out.print("String #2: ");
        String inputB = scanner.nextLine();
        scanner.close();

        testAnagram(inputA, inputB);
    }

    /*
    * testAnagram compares the result of the isAnagram function and prints
    * out either "inputA is an anagram of inputB" or "inputA is not an 
    * anagram of inputB"
    * 
    * @param String inputA, the first input to be compared
    * @param String inputB, the second input to be compared
    * @returns void
    * @throw null
    */
    public static void testAnagram(String inputA, String inputB) {
        System.out.println(inputA + " is " + (isAnagram(inputA, inputB) ? "" : "not") + " an anagram of " + inputB);
    }

    /*
    * isAnagram compares two strings and determines if they are anagrams.
    * 
    * The algorithm uses a HashMap<Character, Integer> by saving inputA 
    * to a hashmap. If there are any duplicates the value is increased. 
    * Then inputB is compared with the hashmap, if there is a value in 
    * inputB that is not already represented in the hashmap, the function
    * exits and returns false. If there is a value that is represented in
    * the hashmap, its value is decreased until it returns to zero at which
    * point the key & value pairs are removed. At the end of the program
    * if the HashMap is empty, true will be returned otherwise false will
    * be returned.
    * 
    * @param String inputA, the first input to be compared
    * @param String inputB, the second input to be compared
    * @returns Boolean 
    * @throw null
    */
    public static Boolean isAnagram(String inputA, String inputB) {
        /*
         * Although comparing the inputs length is not neccessary, 
         * it greatly increases the best case computational time.
         */
        inputA = normalize(inputA);
        inputB = normalize(inputB);

        if (inputA.length() != inputB.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : inputA.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : inputB.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }

        return map.isEmpty();
    }

    /*
    * normalize converts a string to lowercase and removes
    * all whitespace
    * 
    * @param String input, the input to be normalized
    * @returns String
    * @throw null
    */
    public static String normalize(String input) {
        return input.toLowerCase().replaceAll("\\s", "");
    }
}