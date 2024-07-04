import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static Point p[];
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + tst + ": ");
            int n = sc.nextInt();
            p = new Point[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            char a[] = new char[n];
            Arrays.fill(a, '0');
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (intersects(p[i], p[j])) {
                        if (a[i] == '0' && a[j] == '0') {
                            a[i] = 'C';
                            a[j] = 'J';
                        } else if (a[i] == '0') {
                            if (a[j] == 'C') {
                                a[i] = 'J';
                            } else a[i] = 'C';
                        } else if (a[j] == '0') {
                            if (a[i] == 'C') {
                                a[j] = 'J';
                            } else a[j] = 'C';
                        }
                    }

                }
            }
            for (int i = 0; i < n; i++) {
                if (a[i] == '0') a[i] = 'C';
            }
            if (ok(a)) sb.append(String.valueOf(a));
            else sb.append("IMPOSSIBLE");
            sb.append("\n");
            ans.append(sb);
        }
        System.out.print(ans);
    }

    static boolean intersects(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) || ((p1.y > p2.x && p1.y < p2.y));
    }
    static boolean ok(char a[]){
        for (int i=0;i<a.length;i++){
            if (a[i]=='C'){
                for (int j=0;j<a.length;j++){
                    if (i==j)continue;
                    if (a[j]=='C'){
                        if (intersects(p[i],p[j]))return false;
                    }
                }
            }
        }
        for (int i=0;i<a.length;i++){
            if (a[i]=='J'){
                for (int j=0;j<a.length;j++){
                    if (i==j)continue;
                    if (a[j]=='J'){
                        if (intersects(p[i],p[j]))return false;
                    }
                }
            }
        }
        return true;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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