
/* 
 * This program calculates the largest within an array of 
 * x-axis coordinates provided from a input file, "data.txt"
 * 
 * CPSC 224-02, Spring 2018
 * Programming Assignment #3
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 2/09/18 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Container {

    /*
    * main reads an array of integers from the input file and 
    * outputs the resutls of MaxContainer, the main algorithm 
    * for this class.
    * 
    * @param String[] args, optional command line arguments.
    * @returns void
    * @throw FileNotFoundException
    */
    public static void main(String[] args) throws FileNotFoundException {
        Integer[] points = ReadPoints();
        int maximumArea = MaxContainer(points);
        System.out.println("Provided set of numbers: " + Arrays.toString(points));
        System.out.println("Maximum area: " + maximumArea);
    }

    /*
    * MaxContainer calculates the largest area of intersecting
    * lines with provided x values and assuming y values relate
    * directly to the index upon which the x value resides in
    * the points array.
    * 
    * @param Integer[] points
    * @returns int
    * @throw null
    */
    public static int MaxContainer(Integer[] points) {
        int maximumArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int height = (points[i] < points[j]) ? points[i] : points[j];
                int width = (i < j) ? j - i : i - j;
                int tempArea = height * width;
                if (tempArea > maximumArea) {
                    maximumArea = tempArea;
                }
            }
        }
        return maximumArea;
    }

    /*
    * ReadPoints converts a file of integers into an Integer[]
    
    * @param void
    * @returns Integer[]
    * @throw FileNotFoundException
    */
    private static Integer[] ReadPoints() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data.txt"));
        List<Integer> points = new ArrayList<Integer>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                points.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        scanner.close();

        return points.toArray(new Integer[0]);
    }
}
