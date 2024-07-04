import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            ArrayList<Integer> results = calculateTraceAndDuplicates(matrix, size);
            int trace = results.get(0);
            int rowDuplicates = results.get(1);
            int colDuplicates = results.get(2);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }

    private static ArrayList<Integer> calculateTraceAndDuplicates(int[][] matrix, int size) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                colDuplicates++;
            }
        }

        ArrayList<Integer> results = new ArrayList<>();
        results.add(trace);
        results.add(rowDuplicates);
        results.add(colDuplicates);

        return results;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}