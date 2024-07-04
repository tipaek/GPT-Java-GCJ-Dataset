import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != size) duplicateRows++;
            }

            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != size) duplicateCols++;
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}