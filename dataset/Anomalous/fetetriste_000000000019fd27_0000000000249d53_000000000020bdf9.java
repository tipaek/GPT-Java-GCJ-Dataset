import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(in, out);
        out.close();
    }
}

class ParentingPartneringReturns {
    public void solve(FastScanner in, PrintWriter out) {
        int numTests = in.nextInt();
        for (int test = 1; test <= numTests; test++) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }
            int freeC = 0;
            int freeJ = 0;
            boolean[] used = new boolean[n];
            char[] schedule = new char[n];
            for (int step = 0; step < n; step++) {
                int earliest = -1;
                for (int j = 0; j < n; j++) {
                    if (used[j]) continue;
                    if (earliest < 0 || startTimes[earliest] > startTimes[j]) {
                        earliest = j;
                    }
                }
                if (freeC <= startTimes[earliest]) {
                    schedule[earliest] = 'C';
                    freeC = endTimes[earliest];
                } else if (freeJ <= startTimes[earliest]) {
                    schedule[earliest] = 'J';
                    freeJ = endTimes[earliest];
                } else {
                    schedule = null;
                    break;
                }
                used[earliest] = true;
            }
            out.printf("Case #%d: %s\n", test, schedule == null ? "IMPOSSIBLE" : new String(schedule));
        }
    }
}

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}