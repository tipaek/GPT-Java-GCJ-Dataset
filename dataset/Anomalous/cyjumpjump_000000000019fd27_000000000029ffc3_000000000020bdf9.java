import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;
    private StringTokenizer tok;

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int cases = Integer.parseInt(nextToken());

        for (int i = 1; i <= cases; i++) {
            int N = Integer.parseInt(nextToken());
            int[][] intervals = new int[N][2];
            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            wr.println(String.format("Case #%d: %s", i, subSolve(intervals)));
        }

        rd.close();
        wr.close();
    }

    private String subSolve(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        String current = "C";
        int count = 0;

        for (int[] interval : intervals) {
            if (pq.isEmpty() || interval[0] < pq.peek()) {
                count++;
                current = current.equals("C") ? "J" : "C";
            } else {
                pq.poll();
            }
            sb.append(current);
            pq.offer(interval[1]);
        }

        return count > 2 ? "IMPOSSIBLE" : sb.toString();
    }
}