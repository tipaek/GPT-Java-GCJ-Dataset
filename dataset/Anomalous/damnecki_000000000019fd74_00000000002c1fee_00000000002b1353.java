import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int steps = SCANNER.nextInt();
            List<String> path = new ArrayList<>();
            int row = 1, col = 1;

            path.add(row + " " + col);

            if (steps < 501) {
                for (int i = 1; i < steps; i++) {
                    path.add((++row) + " " + col);
                }
            } else if (steps < 1001) {
                path.add((++row) + " " + col);
                int currentSteps = 2;
                int increment = 1;

                while (currentSteps + (++increment) < steps) {
                    path.add((++row) + " " + (++col));
                    currentSteps += increment;
                }

                if (currentSteps < steps) {
                    path.add(row + " " + (++col));
                    currentSteps++;
                }

                while (currentSteps < steps) {
                    path.add((++row) + " " + (++col));
                    currentSteps++;
                }
            }

            OUTPUT.println("Case #" + t + ":");
            printPath(path);
        }
    }

    private static void printPath(List<String> path) {
        for (String step : path) {
            System.out.println(step);
        }
    }
}