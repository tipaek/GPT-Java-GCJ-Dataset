import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static String findTraceAndDuplicates(int n, int[][] matrix) {
        HashMap<Integer, Set<Integer>> rowElements = new HashMap<>();
        HashMap<Integer, Set<Integer>> colElements = new HashMap<>();

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            rowElements.put(i, new HashSet<>());
            colElements.put(i, new HashSet<>());
        }

        int rowDuplicates = 0;
        int colDuplicates = 0;
        
        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateCols = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowElements.get(i).contains(matrix[i][j]) && !duplicateRows.contains(i)) {
                    duplicateRows.add(i);
                    rowDuplicates++;
                }
                rowElements.get(i).add(matrix[i][j]);

                if (colElements.get(j).contains(matrix[i][j]) && !duplicateCols.contains(j)) {
                    duplicateCols.add(j);
                    colDuplicates++;
                }
                colElements.get(j).add(matrix[i][j]);
            }
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        int caseNumber = 1;

        while (numberOfTests > 0) {
            numberOfTests--;

            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + findTraceAndDuplicates(n, matrix));
        }

        scanner.close();
    }
}