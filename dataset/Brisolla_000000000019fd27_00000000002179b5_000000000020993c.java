import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            Integer n = in.nextInt();

            int k = 0;
            int r = 0;
            int c = 0;

            int[][] matrix = new int[n][n];

            for (int a = 0; a < n; a++) {

                boolean repeatedFound = false;
                Map<Integer, Boolean> columnNumbers = new HashMap<>();

                for (int b = 0; b < n; b++) {

                    matrix[a][b] = in.nextInt();

                    if (a == b)
                        k += matrix[a][b];

                    if (!repeatedFound && columnNumbers.get(matrix[a][b]) != null) {
                        r++;
                        repeatedFound = true;
                    }

                    columnNumbers.put(matrix[a][b], true);
                }
            }

            for (int b = 0; b < n; b++) {

                Map<Integer, Boolean> columnNumbers = new HashMap<>();

                for (int a = 0; a < n; a++) {

                    if (columnNumbers.get(matrix[a][b]) != null) {
                        c++;
                        break;
                    }
                    columnNumbers.put(matrix[a][b], true);
                }
            }
            System.out.format("Case #%d: %d %d %d\n", i, k, r, c);

        }
    }
}
