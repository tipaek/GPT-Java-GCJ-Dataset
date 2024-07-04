import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(sc.nextLine());
        
        for (int index = 0; index < numCases; index++) {
            int size = Integer.parseInt(sc.nextLine());
            int trace = 0;
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
                trace += matrix[i][i];
            }
            
            int[] badCounts = getBadRowAndColCounts(matrix);
            int badRows = badCounts[0];
            int badCols = badCounts[1];
            
            System.out.println("Case #" + (index + 1) + ": " + trace + " " + badRows + " " + badCols);
        }
        
        sc.close();
    }

    private static int[] getBadRowAndColCounts(int[][] matrix) {
        int size = matrix.length;
        int badRows = 0;
        int badCols = 0;

        // Check rows for duplicates
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                int val = matrix[i][j] - 1;
                if (seen[val]) {
                    badRows++;
                    break;
                }
                seen[val] = true;
            }
        }

        // Check columns for duplicates
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size];
            for (int i = 0; i < size; i++) {
                int val = matrix[i][j] - 1;
                if (seen[val]) {
                    badCols++;
                    break;
                }
                seen[val] = true;
            }
        }

        return new int[] { badRows, badCols };
    }
}