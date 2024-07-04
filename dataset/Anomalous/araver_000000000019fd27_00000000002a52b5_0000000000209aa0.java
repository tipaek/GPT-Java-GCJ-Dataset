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
    private static boolean isFilled;

    public static void fillPermutationMatrix(int z, int n) {
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

    public static void fillMatrix(int[] trans, int n) {
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

        isFilled = false;
        recursiveFill(n, n);
    }

    public static int findClosestElement(int[] elements, int n) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (elements[i] < n && elements[i] >= max) {
                max = elements[i];
                index = i;
            }
        }
        return index;
    }

    public static void recursiveFill(int soFar, int n) {
        if (soFar == n * n) {
            isFilled = true;
            return;
        }

        int i = findClosestElement(elementCount, n);

        for (int j = 0; j < n && !isFilled; j++) {
            if (rowTracker[j][i] != 1) {
                for (int k = 0; k < n && !isFilled; k++) {
                    if (matrix[j][k] == 0 && colTracker[k][i] != 1) {
                        colTracker[k][i] = 1;
                        rowTracker[j][i] = 1;
                        matrix[j][k] = i + 1;
                        elementCount[i]++;

                        recursiveFill(soFar + 1, n);

                        if (!isFilled) {
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

    public static int flagWrongSet(int[] row, int n) {
        Arrays.sort(row);
        for (int i = 0; i < n; i++) {
            if (row[i] != i + 1) return 1;
        }
        return 0;
    }

    public static boolean checkMatrix(int[][] c, int n) {
        for (int i = 0; i < n; i++) {
            if (flagWrongSet(c[i].clone(), n) == 1) {
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
            String[] p;
            String NO = "IMPOSSIBLE\n";
            String YES = "POSSIBLE\n";
            int tests = Integer.parseInt(line);

            for (int i = 0; i < tests; i++) {
                line = br.readLine();
                p = line.split("\\s+");

                int n = Integer.parseInt(p[0]);
                int y = Integer.parseInt(p[1]);

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
                    fillPermutationMatrix(z, n);
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

                    fillMatrix(trans, n);
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