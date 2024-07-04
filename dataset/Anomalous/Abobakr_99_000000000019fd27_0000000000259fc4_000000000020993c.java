import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            
            Integer[][] matrix = new Integer[matrixSize][matrixSize];
            Integer[][] transposedMatrix = new Integer[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    transposedMatrix[j][i] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }
            
            int duplicateRows = countDuplicates(matrix);
            int duplicateCols = countDuplicates(transposedMatrix);
            
            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateCols);
        }
        
        scanner.close();
    }

    private static int countDuplicates(Integer[][] array) {
        int duplicateCount = 0;
        
        for (Integer[] row : array) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (Integer element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < row.length) {
                duplicateCount++;
            }
        }
        
        return duplicateCount;
    }
}