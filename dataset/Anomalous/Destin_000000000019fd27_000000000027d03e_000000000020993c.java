import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int[] vestigium(int[][] matrix) {
        int[] result = new int[3];
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;
            
            for (int j = 0; j < n; j++) {
                if (!rowHasRepeat) {
                    if (!rowSet.add(matrix[i][j])) {
                        result[1]++;
                        rowHasRepeat = true;
                    }
                }
                if (!colHasRepeat) {
                    if (!colSet.add(matrix[j][i])) {
                        result[2]++;
                        colHasRepeat = true;
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int[] results = vestigium(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, results[0], results[1], results[2]);
        }
        
        scanner.close();
    }
}