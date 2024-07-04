import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] tokens;

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            tokens = reader.readLine().trim().split(" ");
            int N = Integer.parseInt(tokens[0]);
            int K = Integer.parseInt(tokens[1]);

            if (!isPossibleTrace(N, K)) {
                output.append("IMPOSSIBLE").append("\n");
                continue;
            }

            int[][] matrix = getTracedMatrix(N, K);

            output.append("POSSIBLE").append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    output.append(matrix[i][j]).append(" ");
                }

                output.append("\n");
            }
        }

        System.out.print(output);
    }

    private static int[][] getTracedMatrix(int n, int k) {
        int[][] matrix = new int[n][n];

        if (k % n == 0) {
            for (int i = 0; i < n; i++) {
                int counter = k / n - 1;
                for (int j = 0; j < n; j++) {
                    int col = (i + j) % n;

                    matrix[i][col] = counter + 1;
                    counter = (counter + 1) % n;
                }
            }

            return matrix;
        }

        int[] traceElements = getTraceElements(n, k);

        if (traceElements[n - 2] != traceElements[n - 1]) {
            int[] sequence = new int[2 * n];
            sequence[0] = traceElements[n - 2];
            sequence[1] = traceElements[0];
            boolean[] sequenceFlags = new boolean[n + 1];
            sequenceFlags[0] = true;
            sequenceFlags[sequence[0]] = true;
            sequenceFlags[sequence[1]] = true;
            sequence[2] = traceElements[n - 1];
            sequenceFlags[sequence[2]] = true;
            for (int i = 3, counter = 1; i < n; i++) {
                while (sequenceFlags[counter]) {
                    counter = (counter + 1) % (n + 1);
                }

                sequence[i] = counter;
                sequenceFlags[counter] = true;
            }
            System.arraycopy(sequence, 0, sequence, n, n);

            for (int i = 0; i < n; i++) {
                int index = 0;
                while (sequence[index] != traceElements[i]) {
                    index++;
                }
                index = (index - i + n) % n;

                System.arraycopy(sequence, index, matrix[i], 0, n);
            }

            return matrix;
        }

        int[] sequence = new int[2 * n];
        sequence[0] = traceElements[0];
        sequence[1] = traceElements[n - 1];
        boolean[] sequenceFlags = new boolean[n + 1];
        sequenceFlags[0] = true;
        sequenceFlags[sequence[0]] = true;
        sequenceFlags[sequence[1]] = true;
        for (int i = 2, counter = 1; i < n; i++) {
            while (sequenceFlags[counter]) {
                counter = (counter + 1) % (n + 1);
            }

            sequence[i] = counter;
            sequenceFlags[counter] = true;
        }
        System.arraycopy(sequence, 0, sequence, n, n);

        for (int i = 1; i < n - 1; i++) {
            int index = 0;
            while (sequence[index] != traceElements[i]) {
                index++;
            }
            index = (index + i) % n;

            for (int j = 0; j < n; j++) {
                matrix[j][i] = sequence[(index - j + n) % n];
            }
        }

        matrix[0][0] = traceElements[0];
        matrix[n - 1][n - 1] = traceElements[n - 1];
        matrix[n - 2][n - 1] = traceElements[0];
        matrix[n - 3][0] = traceElements[n - 1];
        matrix[0][n - 1] = getRemainingElement(n, matrix[0]);
        matrix[n - 3][n - 1] = getRemainingElement(n, matrix[n - 3]);
        matrix[n - 2][0] = getRemainingElement(n, matrix[n - 2]);
        matrix[n - 1][0] = getRemainingElement(n, matrix[n - 1]);

        for (int i = 1; i < n - 3; i++) {
            int[] elements = getRemainingElements(n, matrix[i]);
            boolean[][] flags = new boolean[2][2];
            for (int e = 0; e < 2; e++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[j][0] == elements[e]) {
                        flags[e][0] = true;
                    }
                    if (matrix[j][n - 1] == elements[e]) {
                        flags[e][1] = true;
                    }
                }
            }

            if (!flags[0][0] || !flags[0][1]) {
                if (flags[0][0]) {
                    matrix[i][0] = elements[1];
                    matrix[i][n - 1] = elements[0];
                } else {
                    matrix[i][0] = elements[0];
                    matrix[i][n - 1] = elements[1];
                }
            } else if (!flags[1][0] || !flags[1][1]) {
                if (flags[1][0]) {
                    matrix[i][0] = elements[0];
                    matrix[i][n - 1] = elements[1];
                } else {
                    matrix[i][0] = elements[1];
                    matrix[i][n - 1] = elements[0];
                }
            }
        }

        return matrix;
    }

    private static int[] getRemainingElements(int n, int[] matrix) {
        boolean[] flags = new boolean[n];
        for (int i : matrix) {
            if (i > 0) {
                flags[i - 1] = true;
            }
        }

        int[] elements = new int[2];
        for (int i = 0, index = 0; i < n; i++) {
            if (!flags[i]) {
                elements[index++] = i + 1;
            }
        }

        return elements;
    }

    private static int getRemainingElement(int n, int[] matrix) {
        boolean[] flags = new boolean[n];
        for (int i : matrix) {
            if (i > 0) {
                flags[i - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                return i + 1;
            }
        }

        return -1;
    }

    private static int[] getTraceElements(int n, int k) {
        int[] traceElements = new int[n];

        int mass = k / n;
        if (mass == n - 1) {
            mass = n;
        }
        for (int i = 0, l = n - 2; i < l; i++) {
            traceElements[i] = mass;
        }

        int sumReq = k - (mass * (n - 2));
        for (int i = 1; i <= n; i++) {
            if (i != mass) {
                for (int j = 1; j <= n; j++) {
                    if (j != mass && i + j == sumReq) {
                        traceElements[n - 2] = i;
                        traceElements[n - 1] = j;
                        return traceElements;
                    }
                }
            }
        }

        return traceElements;
    }

    private static boolean isPossibleTrace(int n, int k) {
        if (n < 4) {
            return k % n == 0;
        }

        return k != (n + 1) && k != (n * n - 1);
    }
}
