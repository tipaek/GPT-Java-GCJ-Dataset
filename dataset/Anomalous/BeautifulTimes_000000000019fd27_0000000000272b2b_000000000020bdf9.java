import java.io.*;
import java.util.*;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] intervals;
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> integerList = new ArrayList<>();
    private List<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();
            for (int testCase = 0; testCase < testCases; testCase++) {
                String result = "";
                int intervalCount = nextInt();
                intervals = new int[intervalCount][3];
                for (int i = 0; i < intervalCount; i++) {
                    intervals[i][0] = nextInt();
                    intervals[i][1] = nextInt();
                    intervals[i][2] = i;
                }
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
                int cEndTime = 0;
                int jEndTime = 0;
                boolean impossible = false;
                String[] assignments = new String[intervalCount];
                for (int i = 0; i < intervalCount; i++) {
                    if (cEndTime <= intervals[i][0]) {
                        assignments[intervals[i][2]] = "C";
                        cEndTime = intervals[i][1];
                    } else if (jEndTime <= intervals[i][0]) {
                        assignments[intervals[i][2]] = "J";
                        jEndTime = intervals[i][1];
                    } else {
                        result = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    }
                }
                if (!impossible) {
                    result = String.join("", assignments);
                }
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine().trim());
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String nextLine() throws IOException {
        return in.readLine().trim();
    }
}