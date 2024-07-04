import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static boolean test(int[][] a, int n, int k) {
        final boolean ok = (a.length == n) && IntStream.range(0, n).allMatch(i -> a[i].length == n);
        final Set<Integer> u = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        final int trace = IntStream.range(0, n).map(i -> a[i][i]).sum();
        final int rows = IntStream.range(0, n).map(i -> (IntStream.range(0, n).map(j -> a[i][j]).boxed().collect(Collectors.toSet()).equals(u)) ? 0 : 1).sum();
        final int cols = IntStream.range(0, n).map(j -> (IntStream.range(0, n).map(i -> a[i][j]).boxed().collect(Collectors.toSet()).equals(u)) ? 0 : 1).sum();
        return ok && (trace == k) && (cols == 0) && (rows == 0);
    }

    private static String build(int[][] a) {
        return (a == null) ? "IMPOSSIBLE" : Arrays.stream(a)
                .map(r -> Arrays.stream(r).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n", "POSSIBLE\n", ""));
    }

    private static int[] split(int n, int k) {
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= n; ++y) {
                if (x == y) {
                    continue;
                }
                int z = k - (n - 2) * x - y;
                if ((z >= 1) && (z <= n) && (x != z)) {
                    return new int[]{x, y, z};
                }
            }
        }
        return null;
    }

    private static int[] move(int[] p, int offset) {
        final int n = p.length;
        return IntStream.range(0, n).map(i -> p[(n + i + offset) % n]).toArray();
    }

    private static int[][] pattern(int[] p) {
        final int n = p.length;
        final int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = p[(n - i + j) % n];
            }
        }
        return a;
    }

    private static int[][] solve(int n, int k) {
        if ((n < 2) || (k < n) || (k > (n * n))) {
            return null;
        }
        if (k % n == 0) {
            int[] p = IntStream.iterate(k / n, i -> i % n + 1).limit(n).toArray();
            return pattern(p);
        }
        if ((n < 4) || (k == (n + 1)) || (k == ((n * n) - 1))) {
            return null;
        }

        int[] u = split(n, k);
        if (u == null) {
            return null;
        }

        if (u[1] == u[2]) {
            int[] t = IntStream.rangeClosed(1, n).toArray();
            int[] p = new int[n];
            p[0] = u[0];
            p[1] = u[1];
            Arrays.stream(u).forEach(x -> t[x - 1] = 0);
            for (int i = 2, j = 0; i < n; ++i) {
                while (t[j] == 0) {
                    ++j;
                }
                p[i] = t[j];
                t[j] = 0;
            }
            int[][] a = pattern(p);
            int[][] b = {a[n - 3], a[n - 2], a[n - 1]};
            Arrays.fill(b[0], 0);
            Arrays.fill(b[1], 0);
            Arrays.fill(b[2], 0);
            b[0][n - 3] = p[0];
            b[0][n - 2] = p[n - 1];
            b[0][n - 1] = p[2];
            b[1][n - 2] = p[1];
            b[1][n - 1] = p[0];
            b[2][n - 2] = p[0];
            b[2][n - 1] = p[1];
            for (int i = 0, j = 1; i < n - 2; ++i, ++j) {
                if (i % 2 == 0) {
                    if ((b[0][i] == 0)) {
                        b[0][i] = p[j % n];
                        b[1][i] = p[(j + 1) % n];
                        b[2][i] = p[(j + 2) % n];
                    } else {
                        b[1][i] = p[j % n];
                        b[2][i] = p[(j + 1) % n];
                    }
                } else {
                    b[2][i] = p[j % n];
                    if (p[(j + 2) % n] == p[n - 1]) {
                        b[1][i] = p[(j + 2) % n];
                        if (b[0][i] == 0) {
                            b[0][i] = p[(j + 1) % n];
                        }
                    } else {
                        b[1][i] = p[(j + 1) % n];
                        if (b[0][i] == 0) {
                            b[0][i] = p[(j + 2) % n];
                        }
                    }
                }
            }
            return a;
        } else {
            int[] t = IntStream.rangeClosed(1, n).toArray();
            int[] p = new int[n];
            p[0] = u[0];
            p[n - 1] = u[1];
            p[1] = u[2];
            Arrays.stream(u).forEach(x -> t[x - 1] = 0);
            for (int i = 2, j = 0; i < n - 1; ++i) {
                while (t[j] == 0) {
                    ++j;
                }
                p[i] = t[j];
                t[j] = 0;
            }
            int[][] a = pattern(p);
            a[n - 2] = move(a[n - 2], -1);
            a[n - 1] = move(a[n - 1], +1);
            return a;
        }
    }

    public static void main(String[] args) {
//        test();
        submit();
    }

    private static void submit() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            String output = build(solve(sc.nextInt(), sc.nextInt()));
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }

        System.out.print(sb);
    }

    private static void test() {
        for (int i = 2; i <= 100; i++) {
            for (int j = i; j <= i * i; j++) {
                final int[][] a = solve(i, j);
                final boolean possible = (i < 4) ? ((j % i) == 0) : ((j != (i + 1)) && (j != ((i * i) - 1)));
                final boolean ok = possible ? ((a != null) && test(a, i, j)) : (a == null);
                if (!ok) {
                    System.out.printf("failed on: %d, %d%n", i, j);
                    return;
                }
                System.out.printf("ok: %d, %d%n", i, j);
            }
        }
    }
}