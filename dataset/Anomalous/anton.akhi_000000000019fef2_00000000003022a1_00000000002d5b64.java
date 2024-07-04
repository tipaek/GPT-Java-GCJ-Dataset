import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCases = nextInt();
        for (int test = 1; test <= testCases; test++) {
            out.print("Case #" + test + ": ");
            solve();
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                return null;
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private void solve() {
        int r = nextInt();
        int s = nextInt();
        int[] x = new int[r * s];
        for (int i = 0; i < x.length; i++) {
            x[i] = i % r;
        }
        List<String> operations = new ArrayList<>();
        while (!isSorted(x, r, s)) {
            int first = x[0];
            int opA = 0;
            while (x[opA] == first) {
                opA++;
            }
            int second = x[opA];
            while (x[opA] == second) {
                opA++;
            }
            int next = opA;
            while (next + 1 < x.length && !(x[next] == first && x[next + 1] == second)) {
                next++;
            }
            int opB;
            if (next + 1 >= x.length) {
                opA = opA / 2;
                opB = x.length - opA - 1;
            } else {
                opB = next + 1 - opA;
            }
            operations.add(opA + " " + opB);
            int[] y = new int[x.length];
            System.arraycopy(x, opA, y, 0, opB);
            System.arraycopy(x, 0, y, opB, opA);
            x = y;
        }
        out.println(operations.size());
        for (String operation : operations) {
            out.println(operation);
        }
    }

    private boolean isSorted(int[] x, int r, int s) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] != i / s) {
                return false;
            }
        }
        return true;
    }
}