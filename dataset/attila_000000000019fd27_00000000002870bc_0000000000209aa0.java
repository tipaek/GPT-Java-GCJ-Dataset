import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            byte[][] solution = null;
            if (k < n || k > n * n) {
                // not possible
            } else if (k % n == 0) {
                solution = make(n, (byte) (k / n));
            } else if (k == n + 1 || k == n * n - 1) {
                // not possible
            } else if (n > 3 && k % n == n - 1) {
                solution = make3Way((byte) n, (byte) (k / n + 1), false);
            } else if (n > 3 && k % n == 1) {
                solution = make3Way((byte) n, (byte) (k / n), true);
            } else if (n > 3) {
                int diff = k % n;
                if (diff == 1 || (diff == (n - 1))) {
                    throw new IllegalStateException("still left to be done");
                } else {
                    int a = k / n;
                    int b = a + 1;
                    int countB = diff;
                    int countA = n - diff;
                    solution = make(countA, a, countB, b, (byte) n);
                }
            }

            if (solution != null) {
                System.out.println("Case #" + tt + ": POSSIBLE");
                print(solution);
                // validate(solution, k);
            } else {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }
        }
    }

    private static byte[][] make3Way(byte n, byte mid, boolean rev) {
        byte next = (byte) (rev ? (mid - 1) : (mid + 1));
        byte prev = (byte) (rev ? (mid + 1) : (mid - 1));
        byte[][] m = new byte[n][n];
        m[0][0] = next;
        m[1][1] = prev;
        m[2][2] = prev;
        for (int i = 3; i < n; i++) {
            m[i][i] = mid;
            m[i][(i + 1) % n] = prev;
            m[i - 1][i - 2] = next;
        }
        m[0][1] = mid;
        m[1][2] = mid;
        m[2][0] = mid;
        m[0][3] = prev;
        m[n - 1][n - 2] = next;
        m[1][n - 1] = next;


        Set<Integer> left = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            left.add(i);
        }
        left.remove((int) mid);
        left.remove((int) prev);
        left.remove((int) next);

        fillRemaining(n, m, left);

        return m;
    }

    private static byte[][] make(int countA, int a, int countB, int b, byte n) {
        byte[][] m = new byte[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = (byte) (i < countA ? a : b);
        }
        for (int i = 0; i < countA - 1; i++) {
            m[i][i + 1] = (byte) b;
        }
        m[countA - 1][0] = (byte) b;

        for (int i = countA; i < n - 1; i++) {
            m[i][i + 1] = (byte) a;
        }
        m[n - 1][countA] = (byte) a;

        Set<Integer> left = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            left.add(i);
        }
        left.remove(a);
        left.remove(b);

        fillRemaining(n, m, left);

        return m;
    }

    private static void fillRemaining(byte n, byte[][] m, Set<Integer> left) {
        int rm = 2;
        while (rm < n) {

            while (rm < n && !isFree(rm, m)) {
                rm++;
            }

            if (rm < n) {
                final Iterator<Integer> iterator = left.iterator();
                int next = iterator.next();
                iterator.remove();
                for (int i = 0; i < n; i++) {
                    m[i][(i + rm) % n] = (byte) next;
                }
                rm++;
            }
        }

        if (left.size() == 2) {
            final Iterator<Integer> iterator = left.iterator();
            int ax = iterator.next();
            int ay = iterator.next();
            lastTwo(m, (byte) ax, (byte) ay);
        } else if (left.size() == 1) {
            final Iterator<Integer> iterator = left.iterator();
            int ax = iterator.next();
            lastOne(m, (byte) ax);
        }
    }

    private static void lastOne(byte[][] m, byte a1) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) {
                    m[i][j] = a1;
                }
            }
        }
    }

    private static void lastTwo(byte[][] m, byte a1, byte a2) {
        int n = m.length;
        int[] rCount = new int[n];
        int[] cCount = new int[n];
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (m[0][i] == 0) {
                cCount[i]++;
                if (first) {
                    m[0][i] = a1;
                    first = false;
                } else {
                    m[0][i] = a2;
                    break;
                }
            }
        }
        rCount[0] += 2;
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;

        boolean reallyHasMore = true;
        while (reallyHasMore) {
            reallyHasMore = false;
            boolean hasMore = true;
            while (hasMore) {
                hasMore = false;
                for (int i = 0; i < n; i++) {
                    if (cCount[i] == 1) {
                        int missing = xor;
                        int missingR = -1;
                        for (int j = 0; j < n; j++) {
                            missing ^= m[j][i];
                            if (m[j][i] == 0) {
                                missingR = j;
                            }
                        }
                        m[missingR][i] = (byte) missing;
                        rCount[missingR]++;
                        cCount[i]++;
                        hasMore = true;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (rCount[i] == 1) {
                        int missing = xor;
                        int missingC = -1;
                        for (int j = 0; j < n; j++) {
                            missing ^= m[i][j];
                            if (m[i][j] == 0) {
                                missingC = j;
                            }
                        }
                        m[i][missingC] = (byte) missing;
                        cCount[missingC]++;
                        rCount[i]++;
                        hasMore = true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (rCount[i] == 0) {
                    first = true;
                    for (int j = 0; j < n; j++) {
                        if (m[i][j] == 0) {
                            cCount[j]++;
                            if (first) {
                                m[i][j] = a1;
                                first = false;
                            } else {
                                m[i][j] = a2;
                                break;
                            }
                        }
                    }
                    rCount[i] += 2;
                    reallyHasMore = true;
                    break;
                }
            }
        }
    }

    private static boolean isFree(int rm, byte[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            if (m[i][(i + rm) % n] != 0) {
                return false;
            }
        }
        return true;
    }

    private static byte[][] make(int n, byte diag) {
        byte[][] m = new byte[n][n];

        for (byte i = 0; i < n; i++) {
            for (byte j = 0; j < n; j++) {
                byte x = (byte) (j - i);
                m[i][j] = (byte) ((diag + x + n) % n);
                if (m[i][j] == 0) m[i][j] = (byte) n;
            }
        }

        return m;
    }

    private static void print(byte[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    private static void validate(byte[][] matrix, int sum) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i][i];
        }
        boolean goodSum = total == sum;
        boolean has0 = false;
        int n = matrix.length;
        boolean[][] rows = new boolean[n][n + 1];
        boolean[][] cols = new boolean[n][n + 1];
        Set<Integer> duplicateCols = new HashSet<Integer>();
        Set<Integer> duplicateRows = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nrr = matrix[i][j];
                if (nrr == 0) {
                    has0 = true;
                    continue;
                }
                if (!rows[i][nrr]) {
                    rows[i][nrr] = true;
                } else {
                    duplicateRows.add(i);
                }
                if (!cols[j][nrr]) {
                    cols[j][nrr] = true;
                } else {
                    duplicateCols.add(j);
                }
            }
        }
        if (!goodSum) {
            throw new IllegalStateException("bad sum");
        }
        if (has0) {
            throw new IllegalStateException("has 0");
        }
        if (!duplicateCols.isEmpty()) {
            throw new IllegalStateException("cols");
        }
        if (!duplicateRows.isEmpty()) {
            throw new IllegalStateException("row");
        }
    }
}
