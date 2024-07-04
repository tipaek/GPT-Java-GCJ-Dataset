import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int n = sc.nextInt();
            Activity[] list = new Activity[n];
            for (int i=0; i<n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                list[i] = new Activity(start, end, i);
            }
            Arrays.sort(list);
            int curC = 0;
            int curJ = 0;
            char[] answer = new char[n];
            boolean possible = true;
            for (int i=0; i<n; i++) {
                Activity cur = list[i];
                if (cur.start >= curC) {
                    answer[cur.num] = 'C';
                    curC = cur.end;
                } else if (cur.start >= curJ) {
                    answer[cur.num] = 'J';
                    curJ = cur.end;
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                pw.println("Case #" + t + ": " + new String(answer));
            } else {
                pw.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int num;

        public Activity(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        public int compareTo(Activity o) {
            if (start < o.start) {
                return -1;
            } else if (start > o.start) {
                return 1;
            } else if (end < o.end) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
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
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
