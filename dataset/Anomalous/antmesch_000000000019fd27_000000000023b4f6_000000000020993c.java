import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String output = analyzeTest(in);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String analyzeTest(Scanner in) {
        int size = in.nextInt();
        int[][] square = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                square[x][y] = in.nextInt();
            }
        }

        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += square[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(square[i])) {
                duplicateRows++;
            }
        }

        // Check for duplicate columns
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = square[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}