import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, Integer> max = new HashMap<>();
        max.put("red", 12);
        max.put("green", 13);
        max.put("blue", 14);

        BufferedReader br = new BufferedReader(new FileReader("../../input/day_2.txt."));

        int value = 0;

        for (String line : br.lines().toList()) {
            int gameID = Integer.parseInt(line.split(":")[0].split(" ")[1]);
            boolean valid = true;

            String game = line.split(":")[1];
            String[] draws = game.split(";");

            for (String draw : draws) {
                String[] colors = draw.strip().split(",");

                for (String color: colors) {
                    String [] colorAmount = color.strip().split(" ");
                    if (Integer.parseInt(colorAmount[0]) > max.get(colorAmount[1])) {
                        valid = false;
                    }
                }
            }
            if (valid) {
                value += gameID;
            }
        }
        System.out.println("Sum: " + value);
    }
}