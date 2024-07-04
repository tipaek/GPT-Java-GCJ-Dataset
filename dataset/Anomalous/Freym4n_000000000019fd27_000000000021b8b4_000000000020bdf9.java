import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        private BufferedReader bf;
        private StringTokenizer st;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
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

        String nextLine() throws IOException {
            return bf.readLine();
        }

        boolean ready() throws IOException {
            return bf.ready() || (st != null && st.hasMoreElements());
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, end, index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "Activity [start=" + start + ", end=" + end + "]";
        }
    }

    static Activity[] activities;
    static boolean[] visited;
    static int n;
    static final int INF = 2000;

    static StringBuilder solve() {
        int currentTime = 0;
        int minEndTime;
        int minIdx = 0;

        for (int i = 0; i < n; i++) {
            minEndTime = INF;
            for (int j = 0; j < n; j++) {
                if (visited[j] || activities[j].start < currentTime) continue;
                if (activities[j].end < minEndTime) {
                    minIdx = j;
                    minEndTime = activities[j].end;
                }
            }
            if (minEndTime == INF) break;
            visited[minIdx] = true;
            currentTime = minEndTime;
        }

        boolean possible = true;
        currentTime = 0;

        for (int i = 0; i < n && possible; i++) {
            if (visited[i]) continue;
            if (activities[i].start < currentTime) possible = false;
            currentTime = activities[i].end;
        }

        StringBuilder result = new StringBuilder();
        if (possible) {
            String[] assignments = new String[n];
            for (int i = 0; i < n; i++) {
                assignments[activities[i].index] = visited[i] ? "C" : "J";
            }
            for (String assignment : assignments) {
                result.append(assignment);
            }
        } else {
            result.append("IMPOSSIBLE");
        }
        return result;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            n = fr.nextInt();
            activities = new Activity[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                int start = fr.nextInt();
                int end = fr.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.parallelSort(activities);
            String result = solve().toString();
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}