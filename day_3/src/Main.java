import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static class Tupel {
        private int x;
        private int y;

        public Tupel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("../../input/day_3.txt"));

        List<String> inputList = br.lines().toList();
        String[][] grid = new String[inputList.size()][inputList.get(0).split("").length];

        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(inputList.get(i).strip().split(""), 0, grid[i], 0, grid[i].length);
        }

        List<Tupel> numberCoordinates = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[i].length; j++) {
                if (Character.isDigit(grid[i][j].charAt(0)) || grid[i][j].charAt(0) == '.') {
                    continue;
                }

            }
        }
    }
}