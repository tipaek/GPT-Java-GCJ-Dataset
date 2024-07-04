import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        return in.next().charAt(0) - '0';
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] ar1 = new boolean[N + 1]; 
        boolean[] ar2 = new boolean[N + 1];
        ArrayList<Integer> same = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();

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

        int sameCmp = !same.isEmpty() ? same.get(0) : -1;
        int diffCmp = !diff.isEmpty() ? diff.get(0) : -1;

        if (sameCmp != -1) {
            ar2[sameCmp] = true;
            same.remove(0);
        }
        if (diffCmp != -1) {
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
        in.next();
    }

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
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
}