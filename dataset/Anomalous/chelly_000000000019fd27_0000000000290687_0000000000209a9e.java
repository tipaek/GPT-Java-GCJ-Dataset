import java.util.*;
import java.io.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    private static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] ar1 = new boolean[N + 1];
        boolean[] ar2 = new boolean[N + 1];
        
        int nor1 = query(1);
        List<Integer> same = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();
        
        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                ar1[i] = true;
                same.add(i);
            } else {
                ar1[i] = false;
                diff.add(i);
            }
        }

        int sameCmp = -1;
        int diffCmp = -1;

        if (!same.isEmpty()) {
            sameCmp = same.get(0);
            ar2[sameCmp] = true;
            same.remove(0);
        }

        if (!diff.isEmpty()) {
            diffCmp = diff.get(0);
            ar2[diffCmp] = true;
            diff.remove(0);
        }

        int cnt = 1;
        int sameCmpVal = query(sameCmp);
        cnt++;

        while (!same.isEmpty()) {
            if (cnt % 10 == 1) {
                sameCmpVal = query(sameCmp);
                cnt++;
                continue;
            }
            ar2[same.get(0)] = (sameCmpVal == query(same.get(0)));
            cnt++;
            same.remove(0);
        }

        int diffCmpVal = query(diffCmp);
        cnt++;

        while (!diff.isEmpty()) {
            if (cnt % 10 == 1) {
                diffCmpVal = query(diffCmp);
                cnt++;
                continue;
            }
            ar2[diff.get(0)] = (diffCmpVal == query(diff.get(0)));
            cnt++;
            diff.remove(0);
        }

        if (cnt % 10 == 0) query(1);

        int[] ans = new int[N + 1];
        sameCmpVal = query(sameCmp);
        diffCmpVal = query(diffCmp);

        for (int i = 1; i <= N / 2; i++) {
            if (ar1[i]) {
                ans[i] = ar2[i] ? sameCmpVal : 1 - sameCmpVal;
                ans[N + 1 - i] = ans[i];
            } else {
                ans[i] = ar2[i] ? diffCmpVal : 1 - diffCmpVal;
                ans[N + 1 - i] = 1 - ans[i];
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(ans[i]);
        System.out.println();

        char C = readChar();
        if (C == 'N') {
            throw new ArithmeticException("Error encountered");
        }
    }

    private static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return readInt();
    }

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static char readChar() throws IOException {
        return next().charAt(0);
    }
}