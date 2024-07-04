import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Job implements Comparable<Job> {
        int start, end, id;
        char c;

        Job(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Job other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            int n = nextInt();
            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job(nextInt(), nextInt(), i);
            }
            Arrays.sort(jobs);
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            for (Job job : jobs) {
                if (cEnd <= job.start) {
                    job.c = 'C';
                    cEnd = job.end;
                } else if (jEnd <= job.start) {
                    job.c = 'J';
                    jEnd = job.end;
                } else {
                    out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                char[] result = new char[n];
                for (Job job : jobs) {
                    result[job.id] = job.c;
                }
                out.println(new String(result));
            }
        }
    }
}