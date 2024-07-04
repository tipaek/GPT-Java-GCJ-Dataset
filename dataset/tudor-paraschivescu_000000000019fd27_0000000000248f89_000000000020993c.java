import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            // Read array
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    arr[x][y] = scanner.nextInt();
                }
            }

            // Compute trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            // Compute rows with repeated elements
            int rows = 0;
            Set<Integer> set = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                set.clear();
                for (int k = 0; k < n; k++) {
                    if (set.contains(arr[j][k])) {
                        rows++;
                        break;
                    }
                    set.add(arr[j][k]);
                }
            }

            // Compute rows with repeated elements
            int cols = 0;
            for (int j = 0; j < n; j++) {
                set.clear();
                for (int k = 0; k < n; k++) {
                    if (set.contains(arr[k][j])) {
                        cols++;
                        break;
                    }
                    set.add(arr[k][j]);
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + cols);
        }
    }
}
