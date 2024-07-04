import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            int[] trace = new int[testCases];
            int[] rowRepeats = new int[testCases];
            int[] colRepeats = new int[testCases];

            for (int t = 0; t < testCases; t++) {
                int n = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] rowValues = scanner.nextLine().split(" ");
                    boolean rowHasDuplicate = false;

                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(rowValues[j]);

                        if (i == j) {
                            trace[t] += matrix[i][j];
                        }

                        if (!rowHasDuplicate) {
                            for (int k = 0; k < j; k++) {
                                if (matrix[i][j] == matrix[i][k]) {
                                    rowHasDuplicate = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (rowHasDuplicate) {
                        rowRepeats[t]++;
                    }
                }

                for (int j = 0; j < n; j++) {
                    boolean colHasDuplicate = false;

                    for (int i = 0; i < n; i++) {
                        if (!colHasDuplicate) {
                            for (int k = 0; k < i; k++) {
                                if (matrix[i][j] == matrix[k][j]) {
                                    colHasDuplicate = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (colHasDuplicate) {
                        colRepeats[t]++;
                    }
                }

                System.out.println("Case #" + (t + 1) + ": " + trace[t] + " " + rowRepeats[t] + " " + colRepeats[t]);
            }
        }
    }
}