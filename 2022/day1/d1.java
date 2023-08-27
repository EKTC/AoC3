import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.*;
import java.lang.*;
// Import the Scanner class to read text files
import java.util.*;
import java.util.regex.Pattern;

public class d1 {
    public static void main(String[] args) {
        String fn = args[0];
        try {

            File file = new File(fn);
            Scanner reader = new Scanner(file);

            int max = -1;
            int number = 1;
            int temp_number = 1;
            int temp_max = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (Pattern.matches(".*[0-9]+.*", line)) {
                    temp_max += Integer.parseInt(line);
                } else {
                    if (temp_max > max) {
                        max = temp_max;
                        number = temp_number;
                    }
                    temp_max = 0;
                    temp_number++;
                }
            }

            System.out.println("Elf " + number + " has the most with " + max);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}

// Code releated to lists
// List<String> lines = new ArrayList<String>();
// lines.add(line);