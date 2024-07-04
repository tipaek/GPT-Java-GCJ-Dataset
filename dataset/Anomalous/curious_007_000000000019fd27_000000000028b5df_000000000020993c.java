import java.util.HashMap;
import java.util.Scanner;

public class Glad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer>[] rowMaps = new HashMap[n];
            HashMap<Integer, Integer>[] colMaps = new HashMap[n];
            int[] rowDuplicates = new int[n];
            int[] colDuplicates = new int[n];
            long trace = 0;
            int rowCount = 0;
            int colCount = 0;
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                rowMaps[j] = new HashMap<>();
                for (int k = 0; k < n; k++) {
                    if (j == 0) {
                        colMaps[k] = new HashMap<>();
                    }
                    matrix[j][k] = sc.nextInt();

                    if (colMaps[k].containsKey(matrix[j][k])) {
                        if (colDuplicates[k] != 1) {
                            colDuplicates[k] = 1;
                            colCount++;
                        }
                    } else {
                        colMaps[k].put(matrix[j][k], 1);
                    }

                    if (rowMaps[j].containsKey(matrix[j][k])) {
                        if (rowDuplicates[j] != 1) {
                            rowDuplicates[j] = 1;
                            rowCount++;
                        }
                    } else {
                        rowMaps[j].put(matrix[j][k], 1);
                    }

                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}