import java.util.Scanner;
import java.io.*;

class Solution {
    private static String[][] matrix;
    private static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            int size = Integer.parseInt(input.nextLine());
            matrix = new String[size][size];

            for (int j = 0; j < size; j++) {
                String[] row = input.nextLine().split(" ");
                addRow(j, row);
            }

            output.append(solve(i)).append("\n");
        }

        System.out.print(output);
    }

    private static void addRow(int rowIndex, String[] row) {
        for (int colIndex = 0; colIndex < matrix.length; colIndex++) {
            matrix[colIndex][rowIndex] = row[colIndex];
        }
    }

    private static String solve(int caseNumber) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += Integer.parseInt(matrix[i][i]);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicate(matrix[i])) {
                duplicateRows++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            String[] column = new String[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicate(column)) {
                duplicateCols++;
            }
        }

        return "Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols;
    }

    private static boolean hasDuplicate(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}