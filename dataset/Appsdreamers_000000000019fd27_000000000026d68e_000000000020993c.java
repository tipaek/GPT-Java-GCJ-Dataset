import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        int testCaseNumber;
        Scanner scanner = new Scanner(System.in);
        testCaseNumber = scanner.nextInt();
        
        for (int i = 0; i <testCaseNumber; i++) {
            int matrixSize = scanner.nextInt();
            
            int[][] matrix = new int [matrixSize][matrixSize];
            
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            System.out.println(getLatinSquareResult(matrix, matrixSize, i + 1));  
        }
        
        scanner.close();
    }
    
    public static String getLatinSquareResult(int [][] matrix, int size, int caseNumber) {
        String result = "Case #" + caseNumber  + ": ";
        
        int rowRepeatCount = 0;  
        int  colRepeatCount = 0;
        long trace = 0;
        List<Integer> mapper = new ArrayList<Integer>();
            
        for (int i = 0; i < size; i++) {
            mapper.clear();
            for (int j = 0; j < size; j++) {
                if (mapper.contains(matrix[i][j])) {
                    rowRepeatCount++;
                    break;
                } else {
                    mapper.add(matrix[i][j]);
                }
            }
        }
       
        for (int i = 0; i < size; i++) {
            mapper.clear();
            for (int j = 0; j < size; j++) {
                if (mapper.contains(matrix[j][i])) {
                    colRepeatCount++;
                    mapper.clear();
                    break;
                } else {
                    mapper.add(matrix[j][i]);
                }
            }
        }
        
        for (int i = 0; i < size; i++) {
            trace = trace + matrix[i][i];
        }
        
        return result + trace + " "+ rowRepeatCount + " " + colRepeatCount; 
    }
 
}
