import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int t1 = 1; t1 <= t; t1++) {
            int n = Integer.parseInt(f.readLine());
            PriorityQueue<StartOrEnd> pq = new PriorityQueue<StartOrEnd>();
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(f.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                pq.add(new StartOrEnd(start, true, start));
                pq.add(new StartOrEnd(end, false, start));
            }

            int JStart = -1;
            int CStart = -1;
            boolean possible = true;
            StringBuilder path = new StringBuilder();
            while (!pq.isEmpty()) {
                StartOrEnd startOrEnd = pq.poll();
                if (startOrEnd.isStart) {
                    if (JStart == -1) {
                        JStart = startOrEnd.time;
                        path.append("J");
                    } else if (CStart == -1) {
                        CStart = startOrEnd.time;
                        path.append("C");
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    if (startOrEnd.startOfTask == JStart) {
                        JStart = -1;
                    } else {
                        CStart = -1;
                    }
                }
            }

            out.print("Case #");
            out.print(t1);
            out.print(": ");
            if (possible) {
                out.println(path.toString());
            } else {
                out.println("IMPOSSIBLE");
            }
        }

        out.close();
    }

    private static class StartOrEnd implements Comparable<StartOrEnd>{
        int time;
        boolean isStart;
        int startOfTask;

        public StartOrEnd(int time, boolean isStart, int startOfTask) {
            this.time = time;
            this.isStart = isStart;
            this.startOfTask = startOfTask;
        }

        @Override
        public int compareTo(StartOrEnd startOrEnd) {
            if (this.time < startOrEnd.time) {
                return -1;
            }
            if (this.time > startOrEnd.time) {
                return 1;
            }
            if (!this.isStart) {
                return -1;
            }
            return 1;
        }
    }
}
