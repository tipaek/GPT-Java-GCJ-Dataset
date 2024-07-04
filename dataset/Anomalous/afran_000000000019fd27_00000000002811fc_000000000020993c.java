import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            int trace = 0, repeatedRows = 0, repeatedColumns = 0;

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                trace += matrix[i][i];
            }

            repeatedRows = countRepeatedRows(matrix, n);
            repeatedColumns = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}