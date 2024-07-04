import java.util.*;
import java.io.*;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static final int[] offR = {-1, -1, 0, 0, 1, 1};
    private static final int[] offK = {-1, 0, -1, 1, 0, 1};
    private static long[][] pascals;
    private static List<Integer> ansR, ansK;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;
        initializePascalsTriangle(40);

        while (t-- > 0) {
            long n = nextInt();
            ansR = new ArrayList<>();
            ansK = new ArrayList<>();
            boolean[][] reached = new boolean[501][501];
            findPath(0, 0, 1, n, reached);
            printResult(caseNumber++);
        }
    }

    private static void initializePascalsTriangle(int size) {
        pascals = new long[size][];
        pascals[0] = new long[]{1};
        pascals[1] = new long[]{1, 1};
        for (int i = 2; i < size; i++) {
            pascals[i] = new long[i + 1];
            pascals[i][0] = pascals[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
            }
        }
    }

    private static boolean findPath(int r, int k, long sum, long needed, boolean[][] reached) {
        if (sum > needed) return false;
        if (sum == needed) {
            ansR.add(r + 1);
            ansK.add(k + 1);
            return true;
        }

        reached[r][k] = true;
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int newR = r + offR[i];
            int newK = k + offK[i];
            if (isValidMove(reached, newR, newK, sum, needed)) {
                long t = pascals[newR][newK];
                insertInDescendingOrder(maxIndices, i, t, r, k);
            }
        }

        for (int index : maxIndices) {
            int newR = r + offR[index];
            int newK = k + offK[index];
            if (findPath(newR, newK, sum + pascals[newR][newK], needed, reached)) {
                ansR.add(r + 1);
                ansK.add(k + 1);
                return true;
            }
        }

        reached[r][k] = false;
        return false;
    }

    private static void insertInDescendingOrder(List<Integer> maxIndices, int i, long t, int r, int k) {
        for (int j = 0; j < maxIndices.size(); j++) {
            int index = maxIndices.get(j);
            if (pascals[r + offR[index]][k + offK[index]] < t) {
                maxIndices.add(j, i);
                return;
            }
        }
        maxIndices.add(i);
    }

    private static boolean isValidMove(boolean[][] reached, int r, int k, long sum, long needed) {
        return r >= 0 && k >= 0 && k <= r && !reached[r][k] && sum + pascals[r][k] <= needed;
    }

    private static void printResult(int caseNumber) {
        System.out.println("Case #" + caseNumber + ": ");
        for (int i = ansR.size() - 1; i >= 0; i--) {
            System.out.println(ansR.get(i) + " " + ansK.get(i));
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}