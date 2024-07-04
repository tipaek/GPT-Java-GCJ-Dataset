import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int trace = 0, rowsWithDuplicates = 0, colsWithDuplicates = 0;
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < size; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                }
                
                if (rowDuplicate) {
                    rowsWithDuplicates++;
                }
                if (colDuplicate) {
                    colsWithDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }
}