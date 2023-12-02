import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        partOne();
        partTwo();
    }

    private static void partTwo() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("../../input/day_2.txt."));

        int value = 0;

        for (String line : br.lines().toList()) {
            String[] game = line.split(": ");

            HashMap<String, Integer> maxValues = new HashMap<>();
            maxValues.put("green", -1);
            maxValues.put("red", -1);
            maxValues.put("blue", -1);

            for (String draws : game[1].split("; ")) {
                for (String draw : draws.split(", ")) {
                    String[] colorAmount = draw.split(" ");
                    if (Integer.parseInt(colorAmount[0]) > maxValues.get(colorAmount[1])) {
                        maxValues.replace(colorAmount[1], Integer.parseInt(colorAmount[0]));
                    }
                }
            }
            int power = 1;
            for (Map.Entry entry : maxValues.entrySet()) {
                power *= (Integer) entry.getValue();
            }
            value += power;
        }
        System.out.println("Part Two: " + value);
    }

    private static void partOne() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("../../input/day_2.txt."));

        HashMap<String, Integer> max = new HashMap<>();
        max.put("red", 12);
        max.put("green", 13);
        max.put("blue", 14);

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
        System.out.println("Part One: " + value);
    }
}