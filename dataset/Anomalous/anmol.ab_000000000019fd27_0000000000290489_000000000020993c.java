import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Check for duplicates in each row
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    rowDuplicates++;
                }
            }

            // Check for duplicates in each column
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != size) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}