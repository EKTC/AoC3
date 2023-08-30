import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class d2j {
    public static void main(String[] args) {
        String strats = args[0];
        String rounds = args[1];
        try {
            File f1 = new File(strats);
            Scanner r1 = new Scanner(f1);

            // Puts the strategy into a hashmap
            HashMap<String, String> strategem = new HashMap<>();

            while (r1.hasNextLine()) {
                String line = r1.nextLine();
                String[] result = line.split(" ");
                strategem.put(result[0], result[1]);
                // System.out.println(result[0]);
                // System.out.println(result[1]);

            }

            // Initialsie draw hashmap to determine what draws
            // Init win hashmap to determine what wins
            // Init points hashmap to determine points values
            HashMap<String, String> draws = new HashMap<>();
            draws.put("A", "X");
            draws.put("B", "Y");
            draws.put("C", "Z");

            HashMap<String, String> wins = new HashMap<>();
            wins.put("A", "Y");
            wins.put("B", "Z");
            wins.put("C", "X");

            HashMap<String, Integer> pts = new HashMap<>();
            pts.put("X", 1);
            pts.put("Y", 2);
            pts.put("Z", 3);

            int total_pts = 0;

            File f2 = new File(rounds);
            Scanner r2 = new Scanner(f2);
            while (r2.hasNextLine()) {
                String line = r2.nextLine();
                String choice = strategem.get(line).strip();
                String draw_check = draws.get(line).strip();
                String win_check = wins.get(line).strip();

                if (choice.equals(win_check)) {

                    total_pts += 6 + pts.get(choice);
                } else if (choice.equals(draw_check)) {

                    total_pts += pts.get(choice) * 2;
                } else {
                    total_pts += pts.get(choice);
                }
            }
            System.out.println("The max amount of points with this strategy is " + total_pts);
            r1.close();
            r2.close();
        } catch (

        FileNotFoundException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}
