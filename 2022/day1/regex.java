import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.*;
import java.lang.*;
// Import the Scanner class to read text files
import java.util.*;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String line = "asd11";
        // x = Pattern.matches("\\d", line);
        System.out.println(line);
        System.out.println(Pattern.matches(".*[0-9]+.*", line));
        System.out.println(Pattern.matches("[0-9]+", line));
    }
}
