import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {

    static int mod = 1000000007;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static class Wrapper {
        long start;
        long end;

        Wrapper(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(in.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(in.readLine());
            long[][] intervals = new long[n][2];
            List<Wrapper> cList = new ArrayList<>();
            List<Wrapper> jList = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] times = in.readLine().split(" ");
                intervals[i][0] = Long.parseLong(times[0]);
                intervals[i][1] = Long.parseLong(times[1]);
            }

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                long start = intervals[i][0];
                long end = intervals[i][1];
                if (isAllowed(cList, start, end)) {
                    cList.add(new Wrapper(start, end));
                    result.append("C");
                } else if (isAllowed(jList, start, end)) {
                    jList.add(new Wrapper(start, end));
                    result.append("J");
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
        in.close();
    }

    private static boolean isAllowed(List<Wrapper> list, long start, long end) {
        for (Wrapper wrapper : list) {
            if (wrapper.end > start && wrapper.start < end) {
                return false;
            }
        }
        return true;
    }
}