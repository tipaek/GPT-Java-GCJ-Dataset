import java.util.Scanner;

public class Set1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[][] arr = new int[n][n];
            int repeatedRow = 0, repeatedCol = 0, trace = 0;

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = input.nextInt();
                }
            }

            // Calculate trace
            for (int row = 0; row < n; row++) {
                trace += arr[row][row];
            }

            // Check for repeated elements in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[arr[row][col]]) {
                        repeatedRow++;
                        break;
                    }
                    seen[arr[row][col]] = true;
                }
            }

            // Check for repeated elements in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[arr[row][col]]) {
                        repeatedCol++;
                        break;
                    }
                    seen[arr[row][col]] = true;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRow + " " + repeatedCol);
        }
    }
}