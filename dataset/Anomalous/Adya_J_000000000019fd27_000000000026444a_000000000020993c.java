import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = Integer.parseInt(sc.nextLine().trim());

            for (int x = 1; x <= t; x++) {
                int trace = 0;
                int n = Integer.parseInt(sc.nextLine().trim());
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] row = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                System.out.print("\nCase #" + x + ": " + trace);
                System.out.print(" " + countDuplicateRows(matrix, n));
                System.out.print(" " + countDuplicateCols(matrix, n));
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}