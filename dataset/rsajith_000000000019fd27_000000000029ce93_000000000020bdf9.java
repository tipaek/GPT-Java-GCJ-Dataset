
import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String [] args)
    {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt(); Segment [] s = new Segment[n];
            for (int i = 0; i < n; i++) {
                s[i] = new Segment(sc.nextInt(), sc.nextInt(), i);
            }
            Arrays.sort(s);
            String res = ""; int j = -1; int c = -1; String [] ret = new String[n];
            for (int i = 0; i < n - 2; i++) {
                if (s[i].end > s[i+1].start && s[i].end > s[i+2].start && s[i+1].end > s[i+2].start) {
                    res = "IMPOSSIBLE"; break;
                } else {
                    if (s[i].start >= j) {
                        ret[s[i].index] = "J";
                        j = s[i].end;
                    } else if (s[i].start >= c){
                        ret[s[i].index] = "C";
                        c = s[i].end;
                    }
;                }
            }
            if (!res.equals("IMPOSSIBLE")) {
                if (s[n-2].start >= j) {
                    ret[s[n-2].index] = "J";
                    j = s[n-2].end;
                } else if (s[n-2].start >= c) {
                    ret[s[n-2].index] = "C";
                    c = s[n-2].end;
                }
                if (s[n-1].start >= j) {
                    ret[s[n-1].index] = "J";
                    j = s[n-2].end;
                } else if (s[n-1].start >= c) {
                    ret[s[n-1].index] = "J";
                    c = s[n-2].end;
                }
            }
            if (!res.equals("IMPOSSIBLE")) {
                for (int i = 0; i < n; i++) res += ret[i];
            }
            out.println("Case #" + p + ": " + res);
        }
        out.close();
    }

    static class Segment implements Comparable<Segment> {
        int start; int end; int index;
        Segment(int start, int end, int index) {
            this.start = start; this.end = end; this.index = index;
        }

        @Override
        public int compareTo(Segment o) {
            return start - o.start;
        }
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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

        String nextLine(){
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