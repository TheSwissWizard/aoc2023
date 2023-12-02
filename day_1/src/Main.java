import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> numbers = new HashMap<>();
        numbers.put("one", "1e");
        numbers.put("two", "2o");
        numbers.put("three", "3e");
        numbers.put("four", "4r");
        numbers.put("five", "5e");
        numbers.put("six", "6x");
        numbers.put("seven", "7n");
        numbers.put("eight", "8t");
        numbers.put("nine", "9e");

        BufferedReader br = new BufferedReader(new FileReader("../../input/day_1.txt."));

        List<String> values = new ArrayList<>();

        for (String line : br.lines().toList()) {

            int index = Integer.MAX_VALUE;
            while (index == Integer.MAX_VALUE) {
                String first = "";
                for (Map.Entry<String, String> entry : numbers.entrySet()) {
                    int pos = line.indexOf(entry.getKey());
                    if (pos != -1 && pos < index) {
                        index = pos;
                        first = entry.getKey();
                    }
                }
                index = -1;
                if (numbers.containsKey(first)) {
                    line = line.replaceFirst(first, numbers.get(first));
                    index = Integer.MAX_VALUE;
                }
            }


            List<String> list = Arrays.stream(line.split(""))
                    .filter(c -> Character.isDigit(c.charAt(0)))
                    .toList();

            values.add(list.get(0) + list.get(list.size() - 1));
        }
        System.out.println("Sum: " + values.stream().mapToInt(Integer::parseInt).sum());
    }
}