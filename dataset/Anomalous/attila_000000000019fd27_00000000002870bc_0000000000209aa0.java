import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            byte[][] solution = null;
            if (k < n || k > n * n) {
                // Not possible
            } else if (k % n == 0) {
                solution = createMatrix(n, (byte) (k / n));
            } else if (k == n + 1 || k == n * n - 1) {
                // Not possible
            } else if (n > 3 && k % n == n - 1) {
                solution = create3WayMatrix((byte) n, (byte) (k / n + 1), false);
            } else if (n > 3 && k % n == 1) {
                solution = create3WayMatrix((byte) n, (byte) (k / n), true);
            } else if (n > 3) {
                int remainder = k % n;
                if (remainder == 1 || remainder == (n - 1)) {
                    throw new IllegalStateException("still left to be done");
                } else {
                    int a = k / n;
                    int b = a + 1;
                    int countB = remainder;
                    int countA = n - remainder;
                    solution = createMatrix(countA, a, countB, b, (byte) n);
                }
            }

            if (solution != null) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                printMatrix(solution);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static byte[][] create3WayMatrix(byte n, byte mid, boolean reverse) {
        byte next = (byte) (reverse ? (mid - 1) : (mid + 1));
        byte prev = (byte) (reverse ? (mid + 1) : (mid - 1));
        byte[][] matrix = new byte[n][n];
        matrix[0][0] = next;
        matrix[1][1] = prev;
        matrix[2][2] = prev;
        for (int i = 3; i < n; i++) {
            matrix[i][i] = mid;
            matrix[i][(i + 1) % n] = prev;
            matrix[i - 1][i - 2] = next;
        }
        matrix[0][1] = mid;
        matrix[1][2] = mid;
        matrix[2][0] = mid;
        matrix[0][3] = prev;
        matrix[n - 1][n - 2] = next;
        matrix[1][n - 1] = next;

        Set<Integer> remainingValues = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            remainingValues.add(i);
        }
        remainingValues.remove((int) mid);
        remainingValues.remove((int) prev);
        remainingValues.remove((int) next);

        fillRemainingCells(n, matrix, remainingValues);

        return matrix;
    }

    private static byte[][] createMatrix(int countA, int a, int countB, int b, byte n) {
        byte[][] matrix = new byte[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = (byte) (i < countA ? a : b);
        }
        for (int i = 0; i < countA - 1; i++) {
            matrix[i][i + 1] = (byte) b;
        }
        matrix[countA - 1][0] = (byte) b;

        for (int i = countA; i < n - 1; i++) {
            matrix[i][i + 1] = (byte) a;
        }
        matrix[n - 1][countA] = (byte) a;

        Set<Integer> remainingValues = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            remainingValues.add(i);
        }
        remainingValues.remove(a);
        remainingValues.remove(b);

        fillRemainingCells(n, matrix, remainingValues);

        return matrix;
    }

    private static void fillRemainingCells(byte n, byte[][] matrix, Set<Integer> remainingValues) {
        int rm = 2;
        while (rm < n) {
            while (rm < n && !isFree(rm, matrix)) {
                rm++;
            }
            if (rm < n) {
                final Iterator<Integer> iterator = remainingValues.iterator();
                int nextValue = iterator.next();
                iterator.remove();
                for (int i = 0; i < n; i++) {
                    matrix[i][(i + rm) % n] = (byte) nextValue;
                }
                rm++;
            }
        }

        if (remainingValues.size() == 2) {
            final Iterator<Integer> iterator = remainingValues.iterator();
            int value1 = iterator.next();
            int value2 = iterator.next();
            fillLastTwo(matrix, (byte) value1, (byte) value2);
        } else if (remainingValues.size() == 1) {
            final Iterator<Integer> iterator = remainingValues.iterator();
            int value = iterator.next();
            fillLastOne(matrix, (byte) value);
        }
    }

    private static void fillLastOne(byte[][] matrix, byte value) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = value;
                }
            }
        }
    }

    private static void fillLastTwo(byte[][] matrix, byte value1, byte value2) {
        int n = matrix.length;
        int[] rowCount = new int[n];
        int[] colCount = new int[n];
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                colCount[i]++;
                if (first) {
                    matrix[0][i] = value1;
                    first = false;
                } else {
                    matrix[0][i] = value2;
                    break;
                }
            }
        }
        rowCount[0] += 2;
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;

        boolean hasMoreValues = true;
        while (hasMoreValues) {
            hasMoreValues = false;
            boolean hasMore = true;
            while (hasMore) {
                hasMore = false;
                for (int i = 0; i < n; i++) {
                    if (colCount[i] == 1) {
                        int missingValue = xor;
                        int missingRow = -1;
                        for (int j = 0; j < n; j++) {
                            missingValue ^= matrix[j][i];
                            if (matrix[j][i] == 0) {
                                missingRow = j;
                            }
                        }
                        matrix[missingRow][i] = (byte) missingValue;
                        rowCount[missingRow]++;
                        colCount[i]++;
                        hasMore = true;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (rowCount[i] == 1) {
                        int missingValue = xor;
                        int missingCol = -1;
                        for (int j = 0; j < n; j++) {
                            missingValue ^= matrix[i][j];
                            if (matrix[i][j] == 0) {
                                missingCol = j;
                            }
                        }
                        matrix[i][missingCol] = (byte) missingValue;
                        colCount[missingCol]++;
                        rowCount[i]++;
                        hasMore = true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (rowCount[i] == 0) {
                    first = true;
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 0) {
                            colCount[j]++;
                            if (first) {
                                matrix[i][j] = value1;
                                first = false;
                            } else {
                                matrix[i][j] = value2;
                                break;
                            }
                        }
                    }
                    rowCount[i] += 2;
                    hasMoreValues = true;
                    break;
                }
            }
        }
    }

    private static boolean isFree(int rm, byte[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][(i + rm) % n] != 0) {
                return false;
            }
        }
        return true;
    }

    private static byte[][] createMatrix(int n, byte diag) {
        byte[][] matrix = new byte[n][n];
        for (byte i = 0; i < n; i++) {
            for (byte j = 0; j < n; j++) {
                byte x = (byte) (j - i);
                matrix[i][j] = (byte) ((diag + x + n) % n);
                if (matrix[i][j] == 0) matrix[i][j] = (byte) n;
            }
        }
        return matrix;
    }

    private static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}