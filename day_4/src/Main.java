import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("../../input/day_4.txt"));

        int value = 0;
        for (String line : br.lines().toList()) {
            String game = line.split(":")[1].strip();

            List<Integer> myNumbers = Arrays.stream(game.split("\\|")[0].strip().split("\\s+"))
                    .map(Integer::parseInt).toList();
            List<Integer> gameNumbers = Arrays.stream(game.split("\\|")[1].strip().split("\\s+"))
                    .map(Integer::parseInt).toList();

            List<Integer> winningNumbers = myNumbers.stream().filter(gameNumbers::contains).toList();
            value += (int) Math.pow(2, winningNumbers.size() - 1);
        }

        System.out.println(value);
    }
}