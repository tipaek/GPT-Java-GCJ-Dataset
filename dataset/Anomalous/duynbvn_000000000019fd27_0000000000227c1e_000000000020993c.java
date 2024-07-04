import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int rowRepeats = 0;
            int columnRepeats = 0;
            int trace = 0;
            
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int column = 0; column < matrixSize; column++) {
                    int value = scanner.nextInt();
                    matrix[row][column] = value;
                    
                    if (row == column) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        rowHasDuplicate = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }
            
            for (int column = 0; column < matrixSize; column++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean columnHasDuplicate = false;
                
                for (int row = 0; row < matrixSize; row++) {
                    if (!columnSet.add(matrix[row][column])) {
                        columnHasDuplicate = true;
                    }
                }
                
                if (columnHasDuplicate) {
                    columnRepeats++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}