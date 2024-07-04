import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer> pm[];
    static boolean dm[];
    static boolean qm[];

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;


        public FastReader() {
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

    public static void main(String[] args) {

        FastReader sc = new FastReader();

        int tt = sc.nextInt();
        for (int k = 1; k <= tt; k++) {
            StringBuilder string = new StringBuilder();
            int n = sc.nextInt();
            string.append("Case #" + k + ": ");
            Point pre[] =
                    new Point[n];
            pm = new ArrayList[n];
            qm = new boolean[n];
            dm = new boolean[n];
            for (int i = 0; i < n; i++) pm[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pre[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ( isintersecting(pre[i], pre[j]) ) {
                        pm[i].add(j);
                        pm[j].add(i);
                    }
                }
            }
            boolean opp = true;
            for (int i = 0; i < n; i++) {
                if (qm [i] ) continue;
                if ( !BFS(i) ) {
                    opp = false;
                }
            }
            if ( !opp ) string.append("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; i++) {
                    if ( dm[i] ) string.append('J');
                    else string.append('C');
                }
            }
            string.append("\n");
            System.out.print(string);
        }
    }

    static boolean BFS(int v) {
        qm[v]
                = true;
        for (int u : pm[v]) {
            if ( qm[u] ) {
                if ( dm[u] !=
                        !dm[v] ) return false;
            } else {
                dm[u] = !dm[v];
                if ( !BFS(u) ) return false;
            }
        }
        return true;
    }

    static boolean isintersecting(Point q1, Point q2) {
        return (q1.x > q2.x && q1.x < q2.y)
                || (q1.y > q2.x && q1.y < q2.y)
                || (q2.x > q1.x && q2.x < q1.y)
                || q2.y > q1.x && q2.y < q1.y ||
                (q1.x == q2.x && q2.y == q1.y);
    }
}