import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String[] rowsCols = reader.readLine().split(" ");
            int rows = Integer.parseInt(rowsCols[0]);
            int cols = Integer.parseInt(rowsCols[1]);
            int[][] floor = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                String[] line = reader.readLine().split(" ");
                for (int c = 0; c < line.length; c++) {
                    floor[r][c] = Integer.parseInt(line[c]);
                }
            }

            int solution = calculateInterest(floor);

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static int calculateInterest(int[][] floor) {
        int sum = 0;
        List<String> toRemove = new ArrayList<>();
        for (int r = 0; r < floor.length; r++) {
            for (int c = 0; c < floor[0].length; c++) {
                int dancer = floor[r][c];
                if (dancer != -1) {
                    sum += dancer;
                    BigDecimal average = calculateAverage(r, c, floor);
                    if (average.compareTo(BigDecimal.valueOf(dancer)) > 0) {
                        toRemove.add(r + " " + c);
                    }
                }
            }
        }
        if (toRemove.isEmpty()) {
            return sum;
        }
        remove(floor, toRemove);
        return sum + calculateInterest(floor);
    }

    private static BigDecimal calculateAverage(int r, int c, int[][] floor) {
        List<Integer> dancers = new ArrayList<>();
        findDancer(r, c, floor, -1, 0, dancers);
        findDancer(r, c, floor, 1, 0, dancers);
        findDancer(r, c, floor, 0, 1, dancers);
        findDancer(r, c, floor, 0, -1, dancers);
        int sum = 0;
        for (Integer dancer : dancers) {
            sum += dancer;
        }
        if (dancers.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(dancers.size()), RoundingMode.CEILING);
    }

    private static void findDancer(int r, int c, int[][] floor, int moveRow, int moveCol, List<Integer> dancers) {
        int newRow = r + moveRow;
        int newCol = c + moveCol;
        while (newRow >= 0 && newRow < floor.length && newCol >= 0 && newCol < floor[0].length) {
            int dancer = floor[newRow][newCol];
            if (dancer != -1) {
                dancers.add(dancer);
                return;
            }
            newRow += moveRow;
            newCol += moveCol;
        }
    }

    private static void remove(int[][] floor, List<String> toRemove) {
        for (String dancer : toRemove) {
            String[] coords = dancer.split(" ");
            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            floor[row][col] = -1;
        }
    }
}