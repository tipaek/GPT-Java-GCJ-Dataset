import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    static int qry(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return readInt();
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] ar1 = new boolean[N + 1];
        boolean[] ar2 = new boolean[N + 1];
        List<Integer> same = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = qry(i);
            int b = qry(N + 1 - i);
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
        int sameCmpVal = qry(sameCmp);
        cnt++;
        while (!same.isEmpty()) {
            if (cnt % 10 == 1) {
                sameCmpVal = qry(sameCmp);
                cnt++;
                continue;
            }
            ar2[same.get(0)] = (sameCmpVal == qry(same.get(0)));
            cnt++;
            same.remove(0);
        }

        int diffCmpVal = qry(diffCmp);
        cnt++;
        while (!diff.isEmpty()) {
            if (cnt % 10 == 1) {
                diffCmpVal = qry(diffCmp);
                cnt++;
                continue;
            }
            ar2[diff.get(0)] = (diffCmpVal == qry(diff.get(0)));
            cnt++;
            diff.remove(0);
        }

        if (cnt % 10 == 0) qry(0);

        int[] ans = new int[N + 1];
        sameCmpVal = qry(sameCmp);
        diffCmpVal = qry(diffCmp);

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
        System.out.flush();

        char C = readChar();
        if (C == 'N') System.exit(-1);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }
}