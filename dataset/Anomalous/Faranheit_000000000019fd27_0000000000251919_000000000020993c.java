import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(sc.readLine());
            int[][] arr = new int[n][n];
            int trace = 0, rowcount = 0, colcount = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(sc.readLine());
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check rows for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rowcount++;
                        break;
                    }
                }
            }

            // Check columns for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][i])) {
                        colcount++;
                        break;
                    }
                }
            }

            // Print result for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowcount + " " + colcount);
            caseNumber++;
        }
    }
}