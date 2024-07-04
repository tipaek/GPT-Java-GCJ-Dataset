import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int loop = 1; loop <= t; loop++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Count rows with duplicates
            int r = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    r++;
                }
            }

            // Count columns with duplicates
            int c = 0;
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    c++;
                }
            }

            // Print the results
            System.out.println("Case #" + loop + ": " + trace + " " + r + " " + c);
        }
    }

    private static boolean hasDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}