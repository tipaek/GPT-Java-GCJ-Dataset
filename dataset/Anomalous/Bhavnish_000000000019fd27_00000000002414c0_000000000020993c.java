import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(); // Size of the matrix
            int[][] arr = new int[n][n];

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Reading the matrix and calculating the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(arr[k][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        in.close();
    }
}