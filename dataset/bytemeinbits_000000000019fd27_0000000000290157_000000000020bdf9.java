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
        int index;

        public TimeInterval(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        @Override
        public int compareTo(TimeInterval o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }

//        @Override
//        public String toString() {
//            return "TimeInterval{" +
//                    "startTime=" + startTime +
//                    ", endTime=" + endTime +
//                    '}';
//        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int test = 0;
        while(++test <= t) {
            int n = fr.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];
            for(int i=0; i<n; i++) {
                TimeInterval interval = new TimeInterval(fr.nextInt(), fr.nextInt(), i);
                intervals[i] = interval;
            }

            Arrays.sort(intervals);
            String[] res = new String[n];
//            System.out.println(Arrays.toString(intervals));
            int jTime = -1;
            int cTime = -1;
            boolean flag = false;
            for(int i=0 ; i<n; i++ ) {
                TimeInterval interval = intervals[i];
                if(jTime <= interval.startTime) {
                    jTime = interval.endTime;
                    res[interval.index] = "J";
                } else if(cTime <= interval.startTime) {
                    cTime = interval.endTime;
                    res[interval.index] = "C";
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                String result = "";
                for(int i=0; i<n; i++) {
                    result += res[i];
                }
                System.out.println("Case #" + test + ": " + result);
            }

        }
    }
}