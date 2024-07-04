import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for row duplicates
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            results[i][0] = trace;
            results[i][1] = rowDuplicates;
            results[i][2] = colDuplicates;
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
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