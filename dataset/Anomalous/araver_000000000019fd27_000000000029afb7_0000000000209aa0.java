import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[][] matrix;
    private static int[][] rowTracker;
    private static int[][] colTracker;
    private static int[] elementCount;
    private static boolean matrixFilled;

    public static void createPermutationMatrix(int z, int n) {
        matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            matrix[0][j] = (z - 1 + j) % n + 1;
        }

        for (int k = 1; k < n; k++) {
            for (int j = 0; j < n; j++) {
                matrix[k][j] = matrix[k - 1][(j - 1 + n) % n];
            }
        }
    }

    public static void initializeMatrix(int[] trans, int n) {
        matrix = new int[n][n];
        rowTracker = new int[n][n];
        colTracker = new int[n][n];
        elementCount = new int[n];

        for (int j = 0; j < n; j++) {
            matrix[j][j] = trans[j];
            rowTracker[j][trans[j] - 1] = 1;
            colTracker[j][trans[j] - 1] = 1;
            elementCount[trans[j] - 1]++;
        }

        matrixFilled = false;
        fillMatrixRecursively(n, n);
    }

    public static void fillMatrixRecursively(int filledCount, int n) {
        if (filledCount == n * n) {
            matrixFilled = true;
            return;
        }

        for (int i = 0; i < n && !matrixFilled; i++) {
            if (elementCount[i] < n) {
                for (int j = 0; j < n && !matrixFilled; j++) {
                    if (rowTracker[j][i] != 1) {
                        for (int k = 0; k < n && !matrixFilled; k++) {
                            if (matrix[j][k] == 0 && colTracker[k][i] != 1) {
                                colTracker[k][i] = 1;
                                rowTracker[j][i] = 1;
                                matrix[j][k] = i + 1;
                                elementCount[i]++;

                                fillMatrixRecursively(filledCount + 1, n);

                                if (!matrixFilled) {
                                    matrix[j][k] = 0;
                                    colTracker[k][i] = 0;
                                    rowTracker[j][i] = 0;
                                    elementCount[i]--;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isValidSet(int[] row, int n) {
        Arrays.sort(row);
        for (int i = 0; i < n; i++) {
            if (row[i] != (i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            if (!isValidSet(matrix[i].clone(), n)) {
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                bw.write(matrix[i][j] + " ");
            }
            bw.write(matrix[i][n - 1] + "\n");
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
            int tests = Integer.parseInt(line);
            String NO = "IMPOSSIBLE\n";
            String YES = "POSSIBLE\n";

            for (int i = 0; i < tests; i++) {
                line = br.readLine();
                String[] parts = line.split("\\s+");
                int n = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                boolean impossible = (y == n + 1) || (y == n * n - 1);

                if (n <= 3) {
                    impossible = y % n != 0;
                }

                if (impossible) {
                    bw.write("Case #" + (i + 1) + ": " + NO);
                    bw.flush();
                    continue;
                }

                boolean done;
                int z = y / n;
                int rest = y % n;

                if (rest == 0) {
                    createPermutationMatrix(z, n);
                    done = true;
                } else {
                    int[] trans = new int[n];
                    if (rest != 1 && rest != n - 1) {
                        for (int j = 0; j < rest; trans[j++] = z + 1);
                        for (int j = rest; j < n; trans[j++] = z);
                    } else if (rest == 1) {
                        trans[0] = z - 1;
                        trans[1] = z + 1;
                        trans[2] = z + 1;
                        for (int j = 3; j < n; trans[j++] = z);
                    } else {
                        trans[0] = z + 2;
                        trans[1] = z;
                        trans[2] = z;
                        for (int j = 3; j < n; trans[j++] = z + 1);
                    }

                    initializeMatrix(trans, n);
                    done = true;
                }

                if (done) {
                    bw.write("Case #" + (i + 1) + ": " + YES);
                    bw.flush();
                    printMatrix(n);
                } else {
                    printMatrix(n);
                    throw new RuntimeException();
                }
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