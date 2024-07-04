import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate trace
            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
            }

            // Check for duplicate rows
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < matrixSize; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < matrixSize; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            results.add("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        sc.close();

        for (String result : results) {
            System.out.println(result);
        }
    }
}