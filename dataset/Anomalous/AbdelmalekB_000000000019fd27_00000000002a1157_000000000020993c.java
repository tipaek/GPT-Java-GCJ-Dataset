import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        int[] res = new int[3 * nb];
        int w = 0;

        for (int caseIndex = 0; caseIndex < nb; caseIndex++) {
            int n = sc.nextInt();
            int[][] tab = new int[n][n];
            res[w] = 0;
            res[w + 1] = 0;
            res[w + 2] = 0;

            sc.nextLine(); // Consume the newline character

            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    tab[i][j] = Integer.parseInt(row[j]);
                }
                res[w] += tab[i][i];

                if (hasDuplicate(tab[i])) {
                    res[w + 1]++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(getColumn(tab, i))) {
                    res[w + 2]++;
                }
            }

            w += 3;
        }

        for (int i = 0; i < nb; i++) {
            System.out.println("Case #" + (i + 1) + ": " + res[i * 3] + " " + res[i * 3 + 1] + " " + res[i * 3 + 2]);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}