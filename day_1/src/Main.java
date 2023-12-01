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

        BufferedReader br = new BufferedReader(new FileReader("input.txt."));

        int value = 0;

        for(String line : br.lines().toList()) {
            System.out.println(line);

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

            System.out.println(line);

            int first = -1;
            int last = -1;

            for (String s : line.split("")) {
                if (Character.isDigit(s.charAt(0))) {
                    if (first == -1) {
                        first = Integer.parseInt(s);
                    }
                    last = Integer.parseInt(s);
                }
            }
            first  *= 10;
            value += first + last;

            System.out.println(first + last);
        }
        System.out.println("Sum: " + value);
    }
}