import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int m = 0; m < t; m++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    rowRepeats++;
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = arr[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + (m + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}