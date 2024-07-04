import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static String calculateVestigium(int[][] matrix) {
        int trace = 0;
        int size = matrix.length;
        int rowRepeats = 0, colRepeats = 0;

        // Calculate trace and row repeats
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Calculate column repeats
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) {
        int[][][] testCases = readInput();
        for (int i = 0; i < testCases.length; i++) {
            String result = calculateVestigium(testCases[i]);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int[][][] readInput() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        int[][][] cases = new int[testCaseCount][][];

        for (int t = 0; t < testCaseCount; t++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            cases[t] = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    cases[t][i][j] = Integer.parseInt(tokens[j]);
                }
            }
        }
        return cases;
    }
}