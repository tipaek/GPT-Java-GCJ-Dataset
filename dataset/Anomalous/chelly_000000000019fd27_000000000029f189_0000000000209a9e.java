import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    static int qry(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
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

        int sameCmp = !same.isEmpty() ? same.remove(0) : -1;
        int diffCmp = !diff.isEmpty() ? diff.remove(0) : -1;

        if (sameCmp != -1) ar2[sameCmp] = true;
        if (diffCmp != -1) ar2[diffCmp] = true;

        int cnt = 1;
        int sameCmpVal = sameCmp != -1 ? qry(sameCmp) : -1;
        cnt++;
        processList(same, sameCmpVal, ar2, cnt);

        int diffCmpVal = diffCmp != -1 ? qry(diffCmp) : -1;
        cnt++;
        processList(diff, diffCmpVal, ar2, cnt);

        if (cnt % 10 == 0) qry(1);

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

        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i]);
        }
        System.out.println();

        char C = readChar();
        if (C == 'N') System.exit(-1);
    }

    static void processList(List<Integer> list, int cmpVal, boolean[] ar2, int cnt) throws IOException {
        while (!list.isEmpty()) {
            if (cnt % 10 == 1) {
                cmpVal = qry(list.get(0));
                cnt++;
                continue;
            }
            ar2[list.get(0)] = (cmpVal == qry(list.get(0)));
            cnt++;
            list.remove(0);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }
}