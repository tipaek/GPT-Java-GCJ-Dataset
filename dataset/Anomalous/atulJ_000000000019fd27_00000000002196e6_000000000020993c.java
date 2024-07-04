import java.io.*;
import java.util.*;

class News {

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int h = 1; h <= testCases; h++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                for (int i = 0; i < n; i++) {
                    matrix[j][i] = Integer.parseInt(input[i]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] colArray = new int[n];
                for (int i = 0; i < n; i++) {
                    colArray[i] = matrix[i][j];
                }
                if (hasDuplicates(colArray)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + h + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}