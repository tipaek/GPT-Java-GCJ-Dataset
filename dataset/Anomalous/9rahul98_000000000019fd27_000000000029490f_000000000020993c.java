import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesNum = in.nextInt();
        
        for (int i = 1; i <= testCasesNum; i++) {
            int matrixSize = in.nextInt();
            List<Integer> matrix = new ArrayList<>();
            
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix.add(in.nextInt());
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int rowMaxCount = countInvalidRows(matrix, matrixSize);
            int colMaxCount = countInvalidCols(matrix, matrixSize);
            
            System.out.println("Case #" + i + ": " + trace + " " + rowMaxCount + " " + colMaxCount);
        }
    }
    
    public static int calculateTrace(List<Integer> matrix, int matrixSize) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix.get(i * matrixSize + i);
        }
        return trace;
    }
    
    public static int countInvalidRows(List<Integer> matrix, int matrixSize) {
        int invalidRows = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                uniqueElements.add(matrix.get(i * matrixSize + j));
            }
            if (uniqueElements.size() < matrixSize) {
                invalidRows++;
            }
        }
        return invalidRows;
    }
    
    public static int countInvalidCols(List<Integer> matrix, int matrixSize) {
        int invalidCols = 0;
        for (int j = 0; j < matrixSize; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < matrixSize; i++) {
                uniqueElements.add(matrix.get(i * matrixSize + j));
            }
            if (uniqueElements.size() < matrixSize) {
                invalidCols++;
            }
        }
        return invalidCols;
    }
}