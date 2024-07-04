import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int[] findRepeatedRowsAndColumns(int[][] matrix, int size) {
        int repeatedRows = 0, repeatedColumns = 0;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                columnSet.add(matrix[j][i]);
            }
            
            if (rowSet.size() != size) {
                repeatedRows++;
            }
            if (columnSet.size() != size) {
                repeatedColumns++;
            }
        }
        
        return new int[] { repeatedRows, repeatedColumns };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }
            
            int[] repeatedCounts = findRepeatedRowsAndColumns(matrix, size);
            results[t][0] = diagonalSum;
            results[t][1] = repeatedCounts[0];
            results[t][2] = repeatedCounts[1];
        }
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print(results[t][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}