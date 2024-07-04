import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int numberOfCases = Integer.parseInt(reader.readLine());
            
            for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
                int sumDiagonal = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;
                int matrixSize = Integer.parseInt(reader.readLine());
                
                int[][] matrix = new int[matrixSize][matrixSize];
                
                for (int rowIndex = 0; row < matrixSize; rowIndex++) {
                    String[] rowValues = reader.readLine().split(" ");
                    System.out.println(rowValues[0]);
                    
                    for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                        matrix[rowIndex][colIndex] = Integer.parseInt(rowValues[colIndex]);
                        
                        if (rowIndex == colIndex) {
                            sumDiagonal += matrix[rowIndex][colIndex];
                        }
                    }
                }
                
                for (int index = 0; index < matrixSize; index++) {
                    boolean rowHasDuplicates = false;
                    boolean colHasDuplicates = false;
                    
                    for (int innerIndex = 0; innerIndex < matrixSize; innerIndex++) {
                        for (int compareIndex = innerIndex + 1; compareIndex < matrixSize; compareIndex++) {
                            if (matrix[index][innerIndex] == matrix[index][compareIndex]) {
                                rowHasDuplicates = true;
                            }
                            if (matrix[innerIndex][index] == matrix[compareIndex][index]) {
                                colHasDuplicates = true;
                            }
                        }
                    }
                    
                    if (rowHasDuplicates) {
                        repeatedRows++;
                    }
                    if (colHasDuplicates) {
                        repeatedColumns++;
                    }
                }
                
                System.out.println("Case #" + (caseIndex + 1) + ": " + sumDiagonal + " " + repeatedRows + " " + repeatedColumns);
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}