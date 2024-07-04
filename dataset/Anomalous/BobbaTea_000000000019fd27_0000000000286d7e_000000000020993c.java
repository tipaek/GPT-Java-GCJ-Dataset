import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        
        for (int test = 0; test < numTests; test++) {
            int size = input.nextInt();
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            Integer[][] matrix = new Integer[size][size];
            Integer[][] transposedMatrix = new Integer[size][size];
            
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    int value = input.nextInt();
                    matrix[r][c] = value;
                    transposedMatrix[c][r] = value;
                    if (r == c) {
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
        
        input.close();
    }
    
    private static boolean hasDuplicates(Integer[] array) {
        Set<Integer> uniqueElements = new HashSet<>(Arrays.asList(array));
        return uniqueElements.size() != array.length;
    }
}