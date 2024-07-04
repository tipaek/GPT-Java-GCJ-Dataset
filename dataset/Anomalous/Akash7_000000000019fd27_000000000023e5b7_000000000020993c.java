import java.io.*;
import java.util.*;

class Solution {

    static void findAnswer(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() < size) {
                duplicateRows++;
            }
            if (colSet.size() < size) {
                duplicateCols++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, duplicateRows, duplicateCols);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            findAnswer(matrix, size, testCase);
        }
    }
}