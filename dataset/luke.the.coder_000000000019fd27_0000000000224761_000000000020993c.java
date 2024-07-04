package compete.p2020.vestigium;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

class Jam {
    /**
     * Scanner of StdIn.
     */
    private final Scanner scanner;

    /**
     * Number of test cases.
     */
    private final int numberOfCases;

    /**
     * The function that reads one test case and returns the solution.
     */
    private final Function<Scanner, String> solution;

    public Jam(Function<Scanner, String> solution) {
        scanner = new Scanner(System.in);
        numberOfCases = scanner.nextInt();
        this.solution = solution;
    }

    public void run() {
        for (int i = 0; i < numberOfCases; i++) {
            final String answer = solution.apply(scanner);
            System.out.printf("Case #%d: %s\n", i + 1, answer);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        new Jam(scanner -> {
            int k = 0, r = 0, c = 0;
            int n = scanner.nextInt();

            int [][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) k += matrix[i][j];
                }
            }

            boolean [] row = new boolean[n];
            boolean [] col = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[j] = false;
                    col[j] = false;
                }
                boolean rowRepeated = false;
                boolean colRepeated = false;
                for (int j = 0; j < n; j++) {
                    int x = matrix[i][j] - 1;
                    if (row[x]) {
                        rowRepeated = true;
                    } else {
                        row[x] = true;
                    }

                    int y = matrix[j][i] - 1;
                    if (col[y]) {
                        colRepeated = true;
                    } else {
                        col[y] = true;
                    }
                }
                if (rowRepeated) r++;
                if (colRepeated) c++;
            }

            return String.format("%d %d %d", k, r, c);
        }).run();
    }
}
