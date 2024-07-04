import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        
        for (int t = 1; t <= noOfTestCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
                if (colSet.size() < n) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}