import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }

            // Checking for row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Checking for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(a[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + p + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}