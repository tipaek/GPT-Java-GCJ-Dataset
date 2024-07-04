import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        
        for (int test = 0; test < numTests; test++) {
            int size = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            Integer[][] matrix = new Integer[size][size];
            Integer[][] transposedMatrix = new Integer[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposedMatrix[col][row] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }
            
            for (Integer[] row : matrix) {
                if (hasDuplicates(row)) {
                    duplicateRows++;
                }
            }
            
            for (Integer[] col : transposedMatrix) {
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + (test + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
    
    private static boolean hasDuplicates(Integer[] array) {
        Set<Integer> uniqueElements = new HashSet<>(Arrays.asList(array));
        return array.length != uniqueElements.size();
    }
}