import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static int flagWrongSet(int[] row, int n) {
        Arrays.sort(row);
        for (int i = 0; i < n; i++) {
            if (row[i] != (i + 1)) return 1;
        }
        return 0;
    }

    public static void printMatrix(int[][] matrix, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                bw.write(matrix[i][j] + " ");
            }
            bw.write(matrix[i][size - 1] + "\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("QR20205.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File file = new File("QR20205.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String NO = "IMPOSSIBLE\n";
            String YES = "POSSIBLE\n";
            int tests = Integer.parseInt(line);

            for (int i = 0; i < tests; i++) {
                line = br.readLine();
                String[] params = line.split("\\s+");

                int n = Integer.parseInt(params[0]);
                int y = Integer.parseInt(params[1]);
                int latinSum = n * (n + 1) / 2;

                boolean isConstructed = false;
                int[][] matrix = new int[n][n];

                if (y % n == 0) {
                    int z = y / n;
                    for (int j = 0; j < n; j++) {
                        matrix[0][j] = (z - 1 + j) % n + 1;
                    }

                    for (int k = 1; k < n; k++) {
                        for (int j = 0; j < n; j++) {
                            matrix[k][j] = matrix[k - 1][(j - 1 + n) % n];
                        }
                    }

                    isConstructed = true;
                }

                if (isConstructed) {
                    bw.write("Case #" + (i + 1) + ": " + YES);
                    printMatrix(matrix, n);
                } else {
                    bw.write("Case #" + (i + 1) + ": " + NO);
                }

                bw.flush();
            }

            if (FROM_FILE) {
                bw.close();
            }
        } finally {
            if (FROM_FILE) {
                br.close();
            }
        }
    }
}