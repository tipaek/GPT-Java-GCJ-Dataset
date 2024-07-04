import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int tc = in.nextInt();
        int temp = tc;
        while (tc-- != 0) {
            String output = "";
            int n = in.nextInt();
            ArrayList<Activity> arr = new ArrayList<Activity>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                arr.add(new Activity(i, start, end));
            }
            arr.sort((Activity a1, Activity a2) -> a1.start - a2.start);
            int cFreeTime = -1;
            int jFreeTime = -1;
            boolean impossible = false;
            for (int i = 0; i < arr.size(); i++) {
                Activity cur = arr.get(i);
                if (cFreeTime <= cur.start) {
                    cFreeTime = cur.end;
                    cur.assigned = 'C';
                } else if (jFreeTime <= cur.start) {
                    jFreeTime = cur.end;
                    cur.assigned = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            if (!impossible) {
                arr.sort((Activity a1, Activity a2) -> a1.index - a2.index);
                for (int i = 0; i < arr.size(); i++) {
                    output += arr.get(i).assigned;
                }
            } else {
                output = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (temp - tc) + ": " + output);
        }
        in.close();
    }

    static class Activity {
        public int start;
        public int end;
        public int index;
        public char assigned;

        public Activity(int index, int start, int end) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

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

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
