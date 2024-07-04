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
    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;
    String nextToken() throws IOException {
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
            Map<int[], Integer> map = new HashMap<>();
            int idx = 0;
            for (int j = 0; j < N; j++) {
                intervals[j][0] = Integer.parseInt(nextToken());
                intervals[j][1] = Integer.parseInt(nextToken());
                int[] mapKey = intervals[j];
                map.put(mapKey, idx);
                idx++;
            }
            Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
            wr.println(String.format("Case #%d: %s", i, subSolve(intervals))); 
        }
        rd.close();
        wr.close();
    }
    
    private String subSolve(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String cur = "C";
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                count++;
                sb.append("C");
                cur = "C";
                pq.offer(interval[1]);
            } else {
                if (interval[0] >= pq.peek()) {
                    pq.poll();
                    sb.append(cur);
                } else {
                    count++;
                    if (cur.equals("J")) {
                        sb.append("C");
                        cur = "C";
                    } else {
                        sb.append("J");
                        cur = "J";
                    }
                }
                pq.offer(interval[1]);
            }
        }
        if (count > 2) {
            return "IMPOSSIBLE";
        }
        return sb.toString();
    }
    
}