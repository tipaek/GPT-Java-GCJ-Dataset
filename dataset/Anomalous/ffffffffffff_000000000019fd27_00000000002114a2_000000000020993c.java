import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}