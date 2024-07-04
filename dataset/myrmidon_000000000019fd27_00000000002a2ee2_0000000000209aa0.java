import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] trace;
    static int[][] prev;
    static int[][] square;
    static ArrayList<Set<Integer>> row, col;
    static boolean filled;


    public static void main(String[] args) throws IOException {
        final int t = Integer.parseInt(br.readLine());
        for (int ti = 1; ti <=t; ti++) {
            final String[] inputArray = br.readLine().split(" ");
            final int n = Integer.parseInt(inputArray[0]);
            final int k = Integer.parseInt(inputArray[1]);

            if (k == (n + 1) || k == (n * n - 1) || specialCase(n, k)) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", ti));
                continue;
            }
            System.out.println(String.format("Case #%d: POSSIBLE", ti));
            trace = new int[n];
            for (int i = 1; i <= n; i++) {
                trace[0] = i;
                createTrace(n, k - i, 2);
                if (validTrace(n)) break;
            }

            row = new ArrayList<>();
            col = new ArrayList<>();
            prev = new int[n][n];
            square = new int[n][n];
            final Set<Integer> perm = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                perm.add(i);
            }
            for (int i = 0; i < n; i++) {
                square[i][i] = trace[i];
                row.add(new HashSet<>(perm));
                row.get(i).remove(trace[i]);
                col.add(new HashSet<>(perm));
                col.get(i).remove(trace[i]);
            }
            filled = false;
            fillSquare(n, 0, 1);

            printSquare(n);
        }
    }

    private static void printSquare(final int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(square[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void fillSquare(final int n, final int i, final int j) {
        if (i == j) {
            fillSquare(n, i, j+1);
            return;
        }
        if (j >= n) {
            fillSquare(n, i+1, 0);
            return;
        }
        if (i == n) {
            filled = true;
            return;
        }
        final Set<Integer> tempRow = new HashSet<>(row.get(i));
        final Set<Integer> tempCol = new HashSet<>(col.get(j));
        for (int x : tempRow) {
            if (tempCol.contains(x)) {
                square[i][j] = x;
                row.get(i).remove(x);
                col.get(j).remove(x);
                fillSquare(n, i, j+1);
                if (filled) {
                    return;
                }
                row.get(i).add(x);
                col.get(j).add(x);
            }
        }
    }

    private static boolean validTrace(final int n) {
        int c1 = count(n, trace[0]);
        int c2 = 0;
        for (int i=0; i<n; i++) {
            if (trace[i]!=trace[0]) {
                c2 = count(n, trace[i]);
                break;
            }
        }
//        System.out.println(c1 + " & " + c2);
        return ((c1 + c2) < n) || ((c1 > 1) && (c2 > 1)) || (c1 * c2 == 0);
    }

    private static int count(final int n, final int x) {
        int sum = 0;
        for (int i=0; i<n; i++) {
            if (trace[i] == x) {
                sum++;
            }
        }
        return sum;
    }

    private static boolean specialCase(final int n, final int k) {
        return n==3 && (k==5 || k==7);
    }

    private static void createTrace(final int n, final int sum,  final int current) {
        if (current > n) return;
        for (int i=1; i<=n; i++) {
            if ((n - current)*n + i >= sum) {
                trace[current-1] = i;
                createTrace(n, sum-i, current+1);
                break;
            }
        }
    }

    private static void fillTrace(final int n, final int k) {
        int sum = k;
        for (int i=1; i<=n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((n - i) * n + j >= sum) {
                    trace[i - 1] = j;
                    sum -= j;
                    break;
                }
            }
        }
    }
}
