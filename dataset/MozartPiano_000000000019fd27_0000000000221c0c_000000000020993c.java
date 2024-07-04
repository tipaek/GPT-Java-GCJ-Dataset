import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 0; i < numOfTestCase; i++) { //for every test case
            int n = in.nextInt();
            int base = 0;
            int diagonal = 0;
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) { // for every line of matrix
                for (int k = 0; k < n; k++) { // for every number in the line
                    int num = in.nextInt();
                    if (k == base) {
                        diagonal += num;
                    }
                    matrix[j][k] = num;
                }
                ++base;
            }

            int row = 0;
            Set<Integer> set;

            for (int a = 0; a < matrix.length; a++) {
                set = new HashSet<>();
                for (int b = 0; b < matrix.length; b++) {
                    if (set.contains(matrix[a][b])) {
                        ++row;
                        set.add(matrix[a][b]);
                        b = matrix.length;
                    } else {
                        set.add(matrix[a][b]);
                    }
                }
            }
            int col = 0;
            for (int a = 0; a < matrix.length; a++) {
                set = new HashSet<>();
                for (int b = 0; b < matrix.length; b++) {
                    if (set.contains(matrix[b][a])) {
                        ++col;
                        set.add(matrix[b][a]);
                        b = matrix.length;
                    } else {
                        set.add(matrix[b][a]);
                    }

                }
            }
            System.out.println("Case #" + i + ": " + diagonal + " " + row + " " + col);
        }

    }
}