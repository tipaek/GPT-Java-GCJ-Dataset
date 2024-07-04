import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = calculateLatinSquareProperties(matrix, size);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        
        scanner.close();
    }
    
    private static int[] calculateLatinSquareProperties(int[][] matrix, int size) {
        int[] properties = new int[3];
        
        for (int i = 0; i < size; i++) {
            properties[0] += matrix[i][i];
            
            Set<Integer> rowElements = new HashSet<>();
            boolean rowHasDuplicates = false;
            
            for (int j = 0; j < size; j++) {
                if (!rowElements.add(matrix[i][j])) {
                    rowHasDuplicates = true;
                    break;
                }
            }
            if (rowHasDuplicates) {
                properties[1]++;
            }
            
            Set<Integer> colElements = new HashSet<>();
            boolean colHasDuplicates = false;
            
            for (int j = 0; j < size; j++) {
                if (!colElements.add(matrix[j][i])) {
                    colHasDuplicates = true;
                    break;
                }
            }
            if (colHasDuplicates) {
                properties[2]++;
            }
        }
        
        return properties;
    }
}