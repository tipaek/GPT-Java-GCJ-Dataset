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
                pq.add(new StartOrEnd(Integer.parseInt(tokenizer.nextToken()), true));
                pq.add(new StartOrEnd(Integer.parseInt(tokenizer.nextToken()), false));
            }
            int used = 0;
            boolean possible = true;
            while (!pq.isEmpty()) {
                StartOrEnd startOrEnd = pq.poll();
                if (startOrEnd.isStart) {
                    used++;
                } else {
                    used--;
                }
                if (used > 2) {
                    possible = false;
                    break;
                }
            }

            out.print("Case #");
            out.print(t1);
            out.print(": ");
            if (possible) {
                boolean Jturn = true;
                for (int i = 0; i < n; i++) {
                    if (Jturn) {
                        out.print("J");
                    } else {
                        out.print("C");
                    }
                    Jturn = !Jturn;
                }
                out.println();
            } else {
                out.println("IMPOSSIBLE");
            }
        }

        out.close();
    }

    private static class StartOrEnd implements Comparable<StartOrEnd>{
        int time;
        boolean isStart;

        public StartOrEnd(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
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
