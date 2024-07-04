import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        // Iterate on matrix's number
        for (int i = 1; i <= t; ++i) {
            // Size of matrix
            int n = in.nextInt();
            Integer[][] matrix = new Integer[n][n];
            Integer[][] reverseMatrix = new Integer[n][n];
            System.out.println("Matrix " + i + ":");
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            // Iterate on rows
            for (int j = 0; j < n; j++) {

                // Iterate on columns
                for (int k = 0; k < n; k++) {
                    int nextInt = in.nextInt();
                    matrix[j][k] = nextInt;
                    reverseMatrix[k][j] = nextInt;
                    if (k == j) {
                        trace += nextInt;
                    }
                    System.out.print(matrix[j][k]);
                }
                repeatedRows += hasRepeatedElements(matrix[j]);
                System.out.println();
            }

            for (int j = 0; j < n; j++) {
                repeatedColumns += hasRepeatedElements(reverseMatrix[j]);
            }
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int hasRepeatedElements(Integer[] tab) {
        if (tab.length   == new HashSet<>(Arrays.asList(tab)).size()) {
            return 0;
        }
        return 1;
    }
}