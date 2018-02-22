import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GasPrice {

    public static void main(String[] strings) throws FileNotFoundException {
        ArrayList<Float> prices = new ArrayList<Float>();

        Scanner scanner = new Scanner(new File("gasprices.txt"));
        while (scanner.hasNext()) {
            if (scanner.hasNextFloat()) {
                prices.add(scanner.nextFloat());
            } else {
                scanner.next();
            }
        }
        scanner.close();

        float average = 0;
        for (Float p : prices) {
            average += p;
        }
        average /= prices.size();

        System.out.println("Average price: " + average);
    }

}