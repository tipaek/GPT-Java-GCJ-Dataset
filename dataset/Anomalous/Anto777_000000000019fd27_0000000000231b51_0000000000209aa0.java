import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws Exception {
        int t = ni();
        for (int I = 1; I <= t; I++) {
            int n = ni(), k = ni();
            if (n > 5) {
                pl("-1");
                return;
            } else {
                String temp = "12345";
                String s = temp.substring(0, n);
                String[] perms = getAllPermutations(s);
                int[][] ans = new int[n][n];

                if (solveLatinSquare(n, k, perms, ans)) {
                    printResult(I, ans);
                } else {
                    pl("Case #" + I + ": IMPOSSIBLE");
                }
            }
        }
    }

    private boolean solveLatinSquare(int n, int k, String[] perms, int[][] ans) {
        switch (n) {
            case 2:
                return findLatinSquare(perms, ans, k, 2);
            case 3:
                return findLatinSquare(perms, ans, k, 3);
            case 4:
                return findLatinSquare(perms, ans, k, 4);
            case 5:
                return findLatinSquare(perms, ans, k, 5);
            default:
                return false;
        }
    }

    private boolean findLatinSquare(String[] perms, int[][] ans, int k, int n) {
        int[] indices = new int[n];
        return findLatinSquareRec(perms, ans, k, indices, 0);
    }

    private boolean findLatinSquareRec(String[] perms, int[][] ans, int k, int[] indices, int depth) {
        if (depth == indices.length) {
            int[][] candidate = isLatinSquare(perms, indices);
            if (candidate != null && check(candidate, k)) {
                for (int i = 0; i < candidate.length; i++) {
                    System.arraycopy(candidate[i], 0, ans[i], 0, candidate[i].length);
                }
                return true;
            }
            return false;
        }

        for (int i = depth == 0 ? 0 : indices[depth - 1] + 1; i < perms.length; i++) {
            indices[depth] = i;
            if (findLatinSquareRec(perms, ans, k, indices, depth + 1)) {
                return true;
            }
        }
        return false;
    }

    private int[][] isLatinSquare(String[] perms, int[] indices) {
        int n = indices.length;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = perms[indices[i]];
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = map[i][j];
                for (int k = 0; k < n; k++) {
                    if ((k != j && map[i][k] == num) || (k != i && map[k][j] == num)) {
                        return null;
                    }
                }
            }
        }
        return map;
    }

    private boolean check(int[][] a, int k) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
        }
        return sum == k;
    }

    private String[] getAllPermutations(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add("" + s.charAt(s.length() - 1) + s.charAt(s.length() - 2));
        queue.add("" + s.charAt(s.length() - 2) + s.charAt(s.length() - 1));

        while (queue.peek().length() < s.length()) {
            String string = queue.poll();
            char appChar = s.charAt(s.length() - string.length() - 1);
            queue.add(appChar + string);
            queue.add(string + appChar);
            for (int i = 1; i < string.length(); i++) {
                queue.add(string.substring(0, i) + appChar + string.substring(i));
            }
        }

        return queue.toArray(new String[0]);
    }

    private void printResult(int caseNumber, int[][] ans) {
        StringBuilder res = new StringBuilder(10000);
        res.append("Case #").append(caseNumber).append(": POSSIBLE\n");
        for (int[] row : ans) {
            for (int num : row) {
                res.append(num).append(" ");
            }
            res.setLength(res.length() - 1);
            res.append("\n");
        }
        p(res);
    }

    private String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private void p(Object o) {
        System.out.print(o);
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}