import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE = "Case #%d: ";
    private static final String OUTPUT_COORDINATES = "%d %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int sum = scanner.nextInt();
        int currentSum = 1;
        boolean direction = false;
        int step = 1;
        List<Coordinate> coordinates = new ArrayList<>();

        while (sum >= currentSum) {
            sum -= currentSum;
            if (direction) {
                for (int i = 1; i <= step; ++i) {
                    coordinates.add(new Coordinate(step, i));
                }
            } else {
                for (int i = step; i > 0; --i) {
                    coordinates.add(new Coordinate(step, i));
                }
            }
            direction = !direction;
            currentSum <<= 1;
            ++step;
        }

        while (sum > 0) {
            --sum;
            if (direction) {
                coordinates.add(new Coordinate(step, 1));
            } else {
                coordinates.add(new Coordinate(step, step));
            }
            ++step;
        }

        System.out.println(String.format(OUTPUT_CASE, caseNum));
        for (Coordinate coord : coordinates) {
            System.out.println(String.format(OUTPUT_COORDINATES, coord.x, coord.y));
        }
    }

    private static class Coordinate {
        public final int x;
        public final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}