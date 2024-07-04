import java.io.*;
import java.util.*;

public class Solution {
    private static int[][] solutionMatrix;
    private static boolean globalAnswer;
    private static int[][] matrix;

    public static void main(String[] args) throws Exception {
        InputReader inputReader = new InputReader(System.in);
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = inputReader.readInt();

        for (int t = 0; t < testCaseCount; t++) {
            globalAnswer = false;
            int n = inputReader.readInt();
            int k = inputReader.readInt();
            solutionMatrix = new int[n][n];
            matrix = new int[n][n];

            for (int[] row : solutionMatrix) {
                Arrays.fill(row, -1);
            }

            solve(0, 0, n, k);

            if (globalAnswer) {
                outputWriter.write("Case #" + (t + 1) + ": POSSIBLE");
                outputWriter.newLine();
                for (int[] row : matrix) {
                    for (int val : row) {
                        outputWriter.write(val + " ");
                    }
                    outputWriter.newLine();
                }
            } else {
                outputWriter.write("Case #" + (t + 1) + ": IMPOSSIBLE");
                outputWriter.newLine();
            }
        }
        outputWriter.close();
    }

    private static void solve(int row, int col, int n, int k) {
        if (row >= n || col >= n) return;

        if (row == n - 1 && col == n - 1) {
            for (int val = 1; val <= n; val++) {
                if (isSafe(n - 1, n - 1, val, n)) {
                    solutionMatrix[n - 1][n - 1] = val;
                    int sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += solutionMatrix[i][i];
                    }
                    if (sum == k) {
                        for (int i = 0; i < n; i++) {
                            System.arraycopy(solutionMatrix[i], 0, matrix[i], 0, n);
                        }
                        globalAnswer = true;
                    }
                    solutionMatrix[n - 1][n - 1] = -1;
                }
            }
            return;
        }

        for (int val = 1; val <= n; val++) {
            if (isSafe(row, col, val, n)) {
                solutionMatrix[row][col] = val;
                if (col + 1 >= n) {
                    solve(row + 1, 0, n, k);
                } else {
                    solve(row, col + 1, n, k);
                }
                solutionMatrix[row][col] = -1;
            }
        }
    }

    private static boolean isSafe(int row, int col, int val, int n) {
        for (int i = 0; i < n; i++) {
            if (solutionMatrix[row][i] == val || solutionMatrix[i][col] == val) {
                return false;
            }
        }
        return true;
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1) throw new InputMismatchException();
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}