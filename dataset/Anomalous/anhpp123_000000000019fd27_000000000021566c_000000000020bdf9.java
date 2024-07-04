import java.io.*;
import java.util.*;

public class Solution {
    private static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int[] s = new int[n], e = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
            }
            String res = sol.solve(n, s, e);
            out.println("Case #" + tt + ": " + res);
        }
        out.close();
    }

    private String solve(int n, int[] s, int[] e) {
        Activity[] activities = new Activity[n];
        int[] assign = new int[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(s[i], e[i], i);
        }

        Arrays.sort(activities, (a1, a2) -> a1.end != a2.end ? a1.end - a2.end : a1.start - a2.start);

        int t1 = 0, t2 = 0, sign = 1;
        for (Activity act : activities) {
            if (act.start >= t2) {
                assign[act.index] = sign;
                t2 = act.end;
            } else if (act.start >= t1) {
                assign[act.index] = 3 - sign;
                t1 = act.end;
                if (t1 > t2) {
                    int tmp = t1;
                    t1 = t2;
                    t2 = tmp;
                    sign = 3 - sign;
                }
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = assign[i] == 1 ? 'C' : 'J';
        }

        return new String(result);
    }

    // MyScanner class for faster input
    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}