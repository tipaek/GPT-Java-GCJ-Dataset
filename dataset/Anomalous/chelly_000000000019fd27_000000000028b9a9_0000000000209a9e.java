import java.util.*;
import java.io.*;

public class Solution {
    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return readInt();
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] ar1 = new boolean[N + 1];
        boolean[] ar2 = new boolean[N + 1];

        int initialQuery = query(1);
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

        int sameCmp = -1, diffCmp = -1;
        if (!same.isEmpty()) {
            sameCmp = same.remove(0);
            ar2[sameCmp] = true;
        }
        if (!diff.isEmpty()) {
            diffCmp = diff.remove(0);
            ar2[diffCmp] = true;
        }

        int count = 1;
        int sameCmpVal = query(sameCmp);
        count++;
        while (!same.isEmpty()) {
            if (count % 10 == 1) {
                sameCmpVal = query(sameCmp);
                count++;
                continue;
            }
            ar2[same.remove(0)] = (sameCmpVal == query(same.get(0)));
            count++;
        }

        int diffCmpVal = query(sameCmp);
        count++;
        while (!diff.isEmpty()) {
            if (count % 10 == 1) {
                diffCmpVal = query(diffCmp);
                count++;
                continue;
            }
            ar2[diff.remove(0)] = (diffCmpVal == query(diff.get(0)));
            count++;
        }

        if (count % 10 == 0) query(0);

        int[] ans = new int[N + 1];
        sameCmpVal = query(sameCmp);
        diffCmpVal = query(diffCmp);

        for (int i = 1; i <= N; i++) {
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
    }

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void print(Object o) {
        pr.print(o);
    }
}