import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int m = 1; m <= T; m++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int[] row = new int[n];
            int[] col = new int[n];

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int maxr = 0, maxc = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[j] = matrix[i][j];
                    col[j] = matrix[j][i];
                }
                Arrays.sort(row);
                Arrays.sort(col);
                maxr = Math.max(maxr, countDuplicates(row));
                maxc = Math.max(maxc, countDuplicates(col));
            }

            System.out.println("Case #" + m + ": " + trace + " " + maxr + " " + maxc);
        }
    }

    private static int countDuplicates(int[] array) {
        int duplicates = 0;
        boolean inDuplicateSequence = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                if (!inDuplicateSequence) {
                    duplicates++;
                    inDuplicateSequence = true;
                }
            } else {
                inDuplicateSequence = false;
            }
        }

        return duplicates;
    }
}