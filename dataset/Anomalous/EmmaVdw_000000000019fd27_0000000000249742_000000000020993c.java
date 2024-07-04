import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Size of the matrix
            int[][] arr = new int[n][n];
            int trace = 0;
            int indexTrace = 0;
            int r = 0, c = 0;

            // Reading the matrix and calculating the trace
            for (int j = 0; j < n * n; ++j) {
                int y = in.nextInt();
                if (j == indexTrace) {
                    trace += y;
                    indexTrace += (n + 1);
                }
                arr[r][c] = y;
                c++;
                if (c == n) {
                    r++;
                    c = 0;
                }
            }

            int rowCount = 0, colCount = 0;
            boolean[] rowRep = new boolean[n];
            boolean[] colRep = new boolean[n];

            // Checking for duplicate elements in rows and columns
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    int check = arr[j][k];
                    for (int l = 0; l < n; ++l) {
                        if (check == arr[j][l] && k != l && !rowRep[j]) {
                            rowCount++;
                            rowRep[j] = true;
                        }
                        if (check == arr[l][k] && l != j && !colRep[k]) {
                            colCount++;
                            colRep[k] = true;
                        }
                        if (rowRep[j] && colRep[k]) {
                            break;
                        }
                    }
                    if (rowCount == n && colCount == n) {
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}