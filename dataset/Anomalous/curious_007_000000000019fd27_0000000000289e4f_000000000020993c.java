import java.util.*;

class Glad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            HashMap<Integer, Integer>[] rowMaps = new HashMap[n];
            HashMap<Integer, Integer>[] colMaps = new HashMap[n];
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];

            for (int i = 0; i < n; i++) {
                rowMaps[i] = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        colMaps[j] = new HashMap<>();
                    }
                    matrix[i][j] = sc.nextInt();

                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check duplicates in row
                    if (rowMaps[i].containsKey(matrix[i][j])) {
                        if (!rowFlags[i]) {
                            rowFlags[i] = true;
                            rowCount++;
                        }
                    } else {
                        rowMaps[i].put(matrix[i][j], 1);
                    }

                    // Check duplicates in column
                    if (colMaps[j].containsKey(matrix[i][j])) {
                        if (!colFlags[j]) {
                            colFlags[j] = true;
                            colCount++;
                        }
                    } else {
                        colMaps[j].put(matrix[i][j], 1);
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}