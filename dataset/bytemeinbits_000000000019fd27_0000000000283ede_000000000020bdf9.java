import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
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

    static class TimeInterval implements Comparable<TimeInterval>{
        int startTime;
        int endTime;

        public TimeInterval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(TimeInterval o) {
            return this.startTime - o.startTime;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int test = 0;
        while(++test <= t) {
            int n = fr.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];
            for(int i=0; i<n; i++) {
                TimeInterval interval = new TimeInterval(fr.nextInt(), fr.nextInt());
                intervals[i] = interval;
            }

            Arrays.sort(intervals);
            int jTime = 0;
            int cTime = 0;
            String res = "";
            for(int i=0 ; i<n; i++ ) {
                TimeInterval interval = intervals[i];
                if(jTime <= interval.startTime) {
                    jTime = interval.endTime;
                    res += "J";
                } else if(cTime <= interval.startTime) {
                    cTime = interval.endTime;
                    res += "C";
                } else {
                    res = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + test + ": " + res);
        }
    }
}