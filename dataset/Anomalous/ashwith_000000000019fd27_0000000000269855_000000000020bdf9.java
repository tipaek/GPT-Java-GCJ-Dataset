import java.io.*;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
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
        }
        out.flush();
    }

    static class MyScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public MyScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tokenizer.nextToken();
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
        assignments[0] = 'C';
        assignments[1] = 'C';

        for (int i = 0; i < n - 1; i++) {
            int conflictCount = 0;
            for (int j = i + 1; j < n; j++) {
                if ((startTimes[j] < endTimes[i] && startTimes[i] < endTimes[j]) || 
                    (startTimes[j] < endTimes[i] && startTimes[j] < startTimes[i])) {
                    conflictCount++;
                    assignments[j] = (assignments[i] == 'C') ? 'J' : 'C';
                } else {
                    assignments[j] = (assignments[i] == 'C') ? 'J' : 'C';
                }
            }
            if (conflictCount == (n - 1)) {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(assignments);
    }
}