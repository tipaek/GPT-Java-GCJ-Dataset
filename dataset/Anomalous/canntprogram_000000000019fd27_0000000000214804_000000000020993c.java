import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void solve(int caseNumber, int size, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        // Calculate trace and check for repeated rows
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            boolean rowRepeated = false;
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeated = true;
                }
            }
            if (rowRepeated) {
                repeatedRows++;
            }
        }

        // Check for repeated columns
        for (int j = 0; j < size; j++) {
            Set<Integer> columnSet = new HashSet<>();
            boolean columnRepeated = false;
            for (int i = 0; i < size; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    columnRepeated = true;
                }
            }
            if (columnRepeated) {
                repeatedColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            solve(caseNumber, size, matrix);
        }

        scanner.close();
    }
}