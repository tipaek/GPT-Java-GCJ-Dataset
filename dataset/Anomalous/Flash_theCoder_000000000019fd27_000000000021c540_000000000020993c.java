import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    rowRepeats++;
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicates = true;
                    }
                }
                
                if (colHasDuplicates) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}