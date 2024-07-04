import java.util.Scanner;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                for (int j = 0; j < size; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], true);
                    }
                }
            }
            
            int duplicateCols = 0;
            for (int j = 0; j < size; j++) {
                HashMap<Integer, Boolean> colMap = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    if (colMap.containsKey(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    } else {
                        colMap.put(matrix[i][j], true);
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}