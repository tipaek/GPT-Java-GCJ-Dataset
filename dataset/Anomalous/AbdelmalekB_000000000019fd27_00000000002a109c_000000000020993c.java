import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        int[] results = new int[3 * nb];

        for (int w = 0; w < nb; w++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            sc.nextLine(); // consume the remaining newline

            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            results[3 * w] = trace;
            results[3 * w + 1] = rowRepeats;
            results[3 * w + 2] = colRepeats;
        }

        for (int w = 0; w < nb; w++) {
            System.out.println("Case #" + (w + 1) + ": " + results[3 * w] + " " + results[3 * w + 1] + " " + results[3 * w + 2]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // assuming values are 1 to n
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}