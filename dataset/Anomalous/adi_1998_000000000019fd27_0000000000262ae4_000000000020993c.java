import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[] frequency = new int[n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                resetFrequency(frequency);
                for (int j = 0; j < n; j++) {
                    frequency[matrix[i][j] - 1]++;
                    if (frequency[matrix[i][j] - 1] > 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column repeats
            for (int i = 0; i < n; i++) {
                resetFrequency(frequency);
                for (int j = 0; j < n; j++) {
                    frequency[matrix[j][i] - 1]++;
                    if (frequency[matrix[j][i] - 1] > 1) {
                        colRepeats++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }

    private static void resetFrequency(int[] frequency) {
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = 0;
        }
    }
}