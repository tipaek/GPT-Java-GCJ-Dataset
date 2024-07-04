import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (rowSet.contains(matrix[i][j]) && !rowFlag) {
                        rowFlag = true;
                        rowDuplicates++;
                    }
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][i];
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < size; i++) {
                    if (colSet.contains(matrix[i][j]) && !colFlag) {
                        colFlag = true;
                        colDuplicates++;
                    }
                    colSet.add(matrix[i][j]);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}