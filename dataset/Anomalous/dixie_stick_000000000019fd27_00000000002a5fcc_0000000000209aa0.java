import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            processTestCase(testCase, N, K);
        }
    }

    private static void processTestCase(int testCase, int N, int K) {
        System.out.print("Case #" + testCase + ": ");
        if (isPossible(N, K)) {
            System.out.println("POSSIBLE");
            printSolution(N, K);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean isPossible(int N, int K) {
        if (N == 2) {
            return K != 3;
        } else if (N == 3) {
            return K == 3 || K == 6;
        } else if (N == 4) {
            return K == 4 || K == 8 || K == 12 || K == 16;
        } else if (N == 5) {
            return K == 5 || K == 10 || K == 15 || K == 20 || K == 25;
        }
        return false;
    }

    private static void printSolution(int N, int K) {
        if (N == 2) {
            if (K == 2) {
                printMatrix(new int[][]{{1, 2}, {2, 1}});
            } else {
                printMatrix(new int[][]{{2, 1}, {1, 2}});
            }
        } else if (N == 3) {
            if (K == 3) {
                printMatrix(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}});
            } else if (K == 6) {
                printMatrix(new int[][]{{2, 1, 3}, {3, 2, 1}, {1, 3, 2}});
            } else {
                printMatrix(new int[][]{{3, 1, 2}, {2, 3, 1}, {1, 2, 3}});
            }
        } else if (N == 4) {
            if (K == 4) {
                printMatrix(new int[][]{{1, 2, 3, 4}, {3, 1, 4, 2}, {2, 4, 1, 3}, {4, 3, 2, 1}});
            } else if (K == 8) {
                printMatrix(new int[][]{{2, 4, 1, 3}, {1, 2, 3, 4}, {4, 3, 2, 1}, {3, 1, 4, 2}});
            } else if (K == 12) {
                printMatrix(new int[][]{{3, 1, 4, 2}, {4, 3, 2, 1}, {1, 2, 3, 4}, {2, 4, 1, 3}});
            } else {
                printMatrix(new int[][]{{4, 3, 2, 1}, {2, 4, 1, 3}, {3, 1, 4, 2}, {1, 2, 3, 4}});
            }
        } else if (N == 5) {
            if (K == 5) {
                printMatrix(new int[][]{{1, 2, 3, 4, 5}, {5, 1, 4, 3, 2}, {4, 5, 1, 2, 3}, {2, 3, 5, 1, 4}, {3, 4, 2, 5, 1}});
            } else if (K == 10) {
                printMatrix(new int[][]{{2, 3, 5, 1, 4}, {1, 2, 3, 4, 5}, {3, 4, 2, 5, 1}, {4, 5, 1, 2, 3}, {5, 1, 4, 3, 2}});
            } else if (K == 15) {
                printMatrix(new int[][]{{3, 4, 2, 5, 1}, {2, 3, 5, 1, 4}, {1, 2, 3, 4, 5}, {5, 1, 4, 3, 2}, {4, 5, 1, 2, 3}});
            } else if (K == 20) {
                printMatrix(new int[][]{{4, 5, 1, 2, 3}, {3, 4, 2, 5, 1}, {5, 1, 4, 3, 2}, {1, 2, 3, 4, 5}, {2, 3, 5, 1, 4}});
            } else {
                printMatrix(new int[][]{{5, 1, 4, 3, 2}, {4, 5, 1, 2, 3}, {2, 3, 5, 1, 4}, {3, 4, 2, 5, 1}, {1, 2, 3, 4, 5}});
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }
    }
}