import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCaseNumber = 0;

        while (t-- > 0) {
            testCaseNumber++;
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt((Interval p) -> p.start).thenComparingInt(p -> p.end));

            char[] schedule = new char[n];
            boolean isPossible = true;
            schedule[0] = 'C';
            schedule[1] = 'J';
            int maxC = intervals[0].end;
            int maxJ = intervals[1].end;

            for (int i = 2; i < n; i++) {
                int start = intervals[i].start;
                int end = intervals[i].end;

                if (start < maxC && start < maxJ) {
                    isPossible = false;
                    break;
                } else if (start >= maxC) {
                    schedule[i] = 'C';
                    maxC = end;
                } else if (start >= maxJ) {
                    schedule[i] = 'J';
                    maxJ = end;
                }
            }

            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

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