import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= totalTests; testCase++) {
            int dimension = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[dimension][dimension];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            
            for (int i = 0; i < dimension; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                String[] rowValues = scanner.nextLine().split("\\s");
                
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
                trace += matrix[i][i];
            }
            
            for (int j = 0; j < dimension; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int i = 0; i < dimension; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}