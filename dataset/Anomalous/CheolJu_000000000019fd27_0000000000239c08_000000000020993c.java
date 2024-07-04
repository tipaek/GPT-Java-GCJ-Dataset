import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Move to the next line

            int[][] matrix = new int[N][N];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                scanner.nextLine(); // Move to the next line
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for row repeats
            for (int i = 0; i < N; i++) {
                boolean[] seen = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for column repeats
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N + 1];
                for (int i = 0; i < N; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Output the result
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}