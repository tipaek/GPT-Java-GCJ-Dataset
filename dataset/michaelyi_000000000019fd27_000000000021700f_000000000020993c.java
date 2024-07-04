import java.util.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();
            int[][] ar = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    ar[r][c] = sc.nextInt();
                }
            }

            int k = 0;
            int r = 0;
            int c = 0;

            // find matrix
            for (int i = 0; i < n; i++) {
                k += ar[i][i];
            }

            // check rows
            HashSet<Integer> set = new HashSet<>();
            for (int[] row : ar) {
                for (Integer v : row) {
                    if (set.contains(v)) {
                        r++;
                        break;
                    }
                    set.add(v);
                }
                set.clear();
            }

            // check columns
            set.clear();
            for (int column = 0; column < n; column++) {
                for (int row = 0; row < n; row++) {
                    if (set.contains(ar[row][column])) {
                        c++;
                        break;
                    }
                    set.add(ar[row][column]);
                }
                set.clear();

            }

            System.out.println("Case #" + (testCase + 1) + ": " + k + " " + r + " " + c);
        }
    }
}