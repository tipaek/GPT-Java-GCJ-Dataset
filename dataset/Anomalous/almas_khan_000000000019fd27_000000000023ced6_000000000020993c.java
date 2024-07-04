import java.io.*;
import java.util.*;

class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

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

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][i])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }
}