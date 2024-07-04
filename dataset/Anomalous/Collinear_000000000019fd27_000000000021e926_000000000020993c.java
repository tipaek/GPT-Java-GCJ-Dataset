import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("test.in"));
        int cases = input.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int size = input.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Read matrix input
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = input.nextInt();
                }
            }

            // Calculate trace
            for (int r = 0; r < size; r++) {
                trace += matrix[r][r];
            }

            // Check for duplicate elements in rows
            for (int r = 0; r < size; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in columns
            for (int c = 0; c < size; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Displaying output
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        input.close();
    }
}