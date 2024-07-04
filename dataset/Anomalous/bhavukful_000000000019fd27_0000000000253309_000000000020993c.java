import java.util.Scanner;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int rowRepeats = 0;
            int colRepeats = 0;
            HashMap<Integer, Boolean> map = new HashMap<>();
            
            // Check for row repetitions
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map.containsKey(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    } else {
                        map.put(matrix[i][j], true);
                    }
                }
                map.clear();
            }
            
            // Check for column repetitions
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (map.containsKey(matrix[i][j])) {
                        colRepeats++;
                        break;
                    } else {
                        map.put(matrix[i][j], true);
                    }
                }
                map.clear();
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}