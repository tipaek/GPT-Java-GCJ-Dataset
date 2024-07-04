import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeMatrix(matrix, size);
            System.out.println("Case #" + testCase + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix, int size) {
        int[] result = new int[3];
        
        // Calculate the sum of the main diagonal
        for (int i = 0; i < size; i++) {
            result[0] += matrix[i][i];
        }

        // Count rows with duplicate elements
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                result[1]++;
            }
        }

        // Count columns with duplicate elements
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != size) {
                result[2]++;
            }
        }
        
        return result;
    }
}