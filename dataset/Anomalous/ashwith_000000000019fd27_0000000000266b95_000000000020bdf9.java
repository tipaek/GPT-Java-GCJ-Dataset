import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = scanner.nextInt();
            long[] startTimes = new long[n];
            long[] endTimes = new long[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextLong();
                endTimes[i] = scanner.nextLong();
            }

            String result = assignTasks(startTimes, endTimes);
            out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
            t--;
        }
        out.flush();
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static String assignTasks(long[] startTimes, long[] endTimes) {
        int n = startTimes.length;
        char[] assignments = new char[n];
        Arrays.fill(assignments, 'C');
        
        for (int i = 0; i < n; i++) {
            boolean canAssignJ = true;
            for (int j = 0; j < n; j++) {
                if (i != j && startTimes[j] < endTimes[i] && startTimes[i] < endTimes[j]) {
                    canAssignJ = false;
                    break;
                }
            }
            if (canAssignJ) {
                assignments[i] = 'J';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (startTimes[j] < endTimes[i] && startTimes[i] < endTimes[j]) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return new String(assignments);
    }
}