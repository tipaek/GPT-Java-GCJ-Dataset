
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer> abcdef[];
    static boolean colllll[];
    static boolean vistiteddddd[];

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
        /*
         360 480
         420 540
         600 660

         j-1>i-1 &&j-1==i -> c

         */
        int t = sc.nextInt();
        for (int testcase = 1; testcase <= t; testcase++) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = sc.nextInt();
            stringBuilder.append("Case #" + testcase + ": ");
            Point points[] =
                    new Point[n];
            abcdef = new ArrayList[n];
            vistiteddddd = new boolean[n];
            colllll = new boolean[n];
            for (int i = 0; i < n; i++) abcdef[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ( isintersecting(points[i], points[j]) ) {
                        abcdef[i].add(j);
                        abcdef[j].add(i);
//                        System.out.println(i+" "+j);
                    }
                }
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if ( vistiteddddd[i] ) continue;
                if ( !dffdfs(i) ) {
                    ok = false;
                }
            }
            if ( !ok ) stringBuilder.append("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; i++) {
                    if ( colllll[i] ) stringBuilder.append('C');
                    else stringBuilder.append('J');
                }
            }
            stringBuilder.append("\n");
            System.out.print(stringBuilder);
        }
    }

    static boolean dffdfs(int v) {
        vistiteddddd[v]
                = true;
        for (int u : abcdef[v]) {
            if ( vistiteddddd[u] ) {
                if ( colllll[u] !=
                        !colllll[v] ) return false;
            } else {
                colllll[u] = !colllll[v];
                if ( !dffdfs(u) ) return false;
            }
        }
        return true;
    }

    static boolean isintersecting(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y)
                || (p1.y > p2.x && p1.y < p2.y)
                || (p2.x > p1.x && p2.x < p1.y)
                || p2.y > p1.x && p2.y < p1.y ||
                (p1.x == p2.x && p2.y == p1.y);
    }
}