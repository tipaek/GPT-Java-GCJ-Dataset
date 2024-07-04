package maze;

import java.util.Scanner;
import java.io.*;

class Solution {
    public static String[][] M;
    public static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(input.nextLine());
            M = new String[N][N];

            for (int j = 0; j < N; j++) {
                String[] in = input.nextLine().split(" ");
                addRow(j, in);
            }

            output.append(solve(i)).append("\n");
        }

        System.out.print(output);
    }

    public static void addRow(int rowIndex, String[] rowValues) {
        for (int colIndex = 0; colIndex < M.length; colIndex++) {
            M[colIndex][rowIndex] = rowValues[colIndex];
        }
    }

    public static String solve(int caseNumber) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < M.length; i++) {
            trace += Integer.parseInt(M[i][i]);
        }

        // Check for duplicate values in rows
        for (int i = 0; i < M.length; i++) {
            if (hasDuplicates(M[i])) {
                duplicateRows++;
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < M.length; i++) {
            String[] column = new String[M.length];
            for (int j = 0; j < M.length; j++) {
                column[j] = M[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        return "Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols;
    }

    public static boolean hasDuplicates(String[] array) {
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