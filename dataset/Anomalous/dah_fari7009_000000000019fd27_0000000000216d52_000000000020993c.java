import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= totalTests; testCase++) {
            int dimension = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[dimension][dimension];
            int trace = 0, numRowsWithDuplicates = 0, numColsWithDuplicates = 0;
            
            for (int i = 0; i < dimension; i++) {
                Set<Integer> rowSet = new HashSet<>();
                String[] rowElements = scanner.nextLine().split("\\s");
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < dimension; j++) {
                    int element = Integer.parseInt(rowElements[j]);
                    matrix[i][j] = element;
                    
                    if (!rowHasDuplicate && rowSet.contains(element)) {
                        numRowsWithDuplicates++;
                        rowHasDuplicate = true;
                    }
                    
                    rowSet.add(element);
                }
            }
            
            for (int j = 0; j < dimension; j++) {
                trace += matrix[j][j];
                Set<Integer> colSet = new HashSet<>();
                
                for (int i = 0; i < dimension; i++) {
                    int element = matrix[i][j];
                    
                    if (colSet.contains(element)) {
                        numColsWithDuplicates++;
                        break;
                    }
                    
                    colSet.add(element);
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + numRowsWithDuplicates + " " + numColsWithDuplicates);
        }
    }
}