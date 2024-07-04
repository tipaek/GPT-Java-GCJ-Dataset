import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int size = in.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[size][size];
            
            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            
            // Calculate trace and check for row and column duplicates
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
                
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                
                if (hasColumnDuplicates(matrix, i)) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
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
    
    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            if (!set.add(row[colIndex])) {
                return true;
            }
        }
        return false;
    }
}