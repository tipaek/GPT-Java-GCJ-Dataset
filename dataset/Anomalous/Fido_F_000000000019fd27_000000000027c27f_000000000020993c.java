import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                boolean[] rowCheck = new boolean[101];
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(rowValues[j]);
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (rowCheck[value] && !rowHasDuplicate) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                    rowCheck[value] = true;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[101];
                boolean colHasDuplicate = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    int value = matrix[i][j];
                    
                    if (colCheck[value] && !colHasDuplicate) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                    colCheck[value] = true;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}