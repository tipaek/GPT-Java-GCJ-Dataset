import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cases = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            // Input matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = 0;

            // Calculate sum of the primary diagonal
            for (int i = 0; i < n; i++) {
                k += mat[i][i];
            }

            int r = 0, c = 0;

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                boolean hasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int key = mat[i][j];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }

                for (int count : map.values()) {
                    if (count > 1) {
                        r++;
                        hasDuplicate = true;
                        break;
                    }
                }

                if (hasDuplicate) {
                    break;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                boolean hasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int key = mat[j][i];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }

                for (int count : map.values()) {
                    if (count > 1) {
                        c++;
                        hasDuplicate = true;
                        break;
                    }
                }

                if (hasDuplicate) {
                    break;
                }
            }

            // Print the result for the current case
            System.out.println("Case #" + cases + ": " + k + " " + r + " " + c);
            cases++;
        }
    }
}