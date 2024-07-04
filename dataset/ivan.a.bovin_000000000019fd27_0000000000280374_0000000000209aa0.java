import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (int t = 1; t <= T; ++t) {
            final int N = input.nextInt();
            final int K = input.nextInt();
            final Matrix m = new Matrix(N, K);
            boolean impossible = !m.go();
            if (impossible) {
                System.out.format("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.format("Case #%d: POSSIBLE\n", t);
                System.out.println(m.format());
            }
        }
    }

    interface Each {
        void each(int value, int row, int column);
    }

    static class Matrix {
        final int size;
        final int size2;
        final int trace;
        final int[][] data;

        int checkCount = 0;

        Matrix(int N, int K) {
            size = N;
            size2 = N * N;
            trace = K;
            data = new int[N][N];
        }

        String format() {
            return Arrays.stream(data).map(line -> Arrays.stream(line)
                    .mapToObj(v -> v < 10 ? "  " + v : " " + v)
                    .collect(Collectors.joining("")))
                    .collect(Collectors.joining("\n"));
        }

        boolean go() {
            return trace(0);
        }

        boolean trace(int a2) {
            if (a2 == size2) {
                return checkTrace();
            }
            int row = a2 / size;
            int column = a2 % size;
            boolean[] busy = getBusyStatuses(row, column);
            for (int value = 1; value < busy.length; ++value) {
                if (busy[value]) {
                    continue;
                }
                data[row][column] = value;
                if (trace(a2 + 1)) {
                    return true;
                }
            }
            return false;
        }

        private boolean[] getBusyStatuses(int row, int column) {
            boolean[] values = new boolean[size + 1];
            each((v, r, c) -> {
                if ((r < row && c == column) || (r == row && c < column)) {
                    values[v] = true;
                }
            });
            return values;
        }

        private boolean checkTrace() {
            ++checkCount;
            AtomicInteger sum = new AtomicInteger(0);
            each((v, r, c) -> {
                if (r == c) {
                    sum.addAndGet(data[r][c]);
                }
            });
            return sum.get() == trace;
        }

        void each(Each each) {
            for (int row = 0; row < size; ++row) {
                for (int column = 0; column < size; ++column) {
                    int value = data[row][column];
                    each.each(value, row, column);
                }
            }
        }
    }
}
