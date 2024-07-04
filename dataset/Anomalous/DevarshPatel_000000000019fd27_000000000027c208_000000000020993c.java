import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            results.add(processMatrix(matrix, n));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String processMatrix(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateColumns = countDuplicateColumns(matrix, size);

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicates = 0;

        for (int i = 0; i < size; i++) {
            Map<Integer, Integer> rowElements = new HashMap<>();

            for (int j = 0; j < size; j++) {
                if (rowElements.containsKey(matrix[i][j])) {
                    duplicates++;
                    break;
                } else {
                    rowElements.put(matrix[i][j], 1);
                }
            }
        }

        return duplicates;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicates = 0;

        for (int i = 0; i < size; i++) {
            Map<Integer, Integer> columnElements = new HashMap<>();

            for (int j = 0; j < size; j++) {
                if (columnElements.containsKey(matrix[j][i])) {
                    duplicates++;
                    break;
                } else {
                    columnElements.put(matrix[j][i], 1);
                }
            }
        }

        return duplicates;
    }
}