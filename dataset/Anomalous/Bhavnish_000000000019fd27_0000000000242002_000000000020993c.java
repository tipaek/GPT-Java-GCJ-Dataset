import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating the trace
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                    rowSet.add(arr[j][k]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            // Checking for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    colSet.add(arr[k][j]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        in.close();
    }
}