import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculating trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Checking for row repetitions
            for (int row = 0; row < size; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() < size) {
                    rowRepeats++;
                }
            }

            // Checking for column repetitions
            for (int col = 0; col < size; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() < size) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}