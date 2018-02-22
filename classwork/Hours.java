import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Hours {

    public static void main(String[] strings) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("hours.txt"));
        List<Person> people = new ArrayList<Person>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            Person person = new Person();
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextInt()) {
                    person.id = lineScanner.nextInt();
                } else if (lineScanner.hasNextFloat()) {
                    person.hours.add(lineScanner.nextFloat());
                } else if (lineScanner.hasNext()) {
                    person.name = lineScanner.next();
                }
            }
            lineScanner.close();
            people.add(person);
        }
        scanner.close();

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}

class Person {
    String name;
    Integer id;
    List<Float> hours = new ArrayList<Float>();

    private Float sum() {
        Float sum = 0f;
        for (Float h : this.hours) {
            sum += h;
        }
        return sum;
    }

    @Override
    public String toString() {
        return this.name + " (ID#" + this.id + ") worked " + this.sum() + " hours ("
                + (this.sum() / hours.size() + " hours/day)");
    }
}