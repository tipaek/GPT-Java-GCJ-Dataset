import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= totalTests; testCase++) {
            int dim = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[dim][dim];
            int trace = 0, numRows = 0, numCols = 0;
            
            for (int i = 0; i < dim; i++) {
                Set<Integer> rowSet = new HashSet<>();
                String[] rowValues = scanner.nextLine().split("\\s");
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < dim; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        numRows++;
                        rowHasDuplicate = true;
                    }
                }
            }
            
            for (int j = 0; j < dim; j++) {
                trace += matrix[j][j];
                Set<Integer> colSet = new HashSet<>();
                
                for (int i = 0; i < dim; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        numCols++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + numRows + " " + numCols);
        }
    }
}