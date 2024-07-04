import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = file.nextInt();
            List<Pair> cameron = new ArrayList<>();
            List<Pair> jamie = new ArrayList<>();
            List<Pair> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                intervals.add(new Pair(file.nextInt(), file.nextInt()));
            }
            
            List<Pair> sortedIntervals = new ArrayList<>(intervals);
            Collections.sort(sortedIntervals);
            
            boolean isPossible = true;
            for (Pair interval : sortedIntervals) {
                if (canAssign(interval, cameron)) {
                    cameron.add(interval);
                } else if (canAssign(interval, jamie)) {
                    jamie.add(interval);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    Pair interval = intervals.get(i);
                    if (cameron.contains(interval)) {
                        result[i] = 'C';
                    } else {
                        result[i] = 'J';
                    }
                }
                System.out.println("Case #" + testCase + ": " + new String(result));
            }
        }
    }

    private boolean canAssign(Pair interval, List<Pair> schedule) {
        if (schedule.isEmpty()) {
            return true;
        }
        Pair lastInterval = schedule.get(schedule.size() - 1);
        return interval.x >= lastInterval.y;
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
    }
}