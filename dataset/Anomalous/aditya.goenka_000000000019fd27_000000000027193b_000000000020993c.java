import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int size = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }

            int duplicateColumns = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}