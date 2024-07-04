import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class timeslot {
        int idx;
        int start;
        int end;

        public timeslot(int i, int s, int e) {
            idx = i;
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            char[] res = new char[n];
            Queue<timeslot> pq = new PriorityQueue<>(n, (obj1, obj2) -> {
                return obj1.start - obj2.start;
            });
            for (int j = 0; j < n; j++) {
                timeslot ts = new timeslot(j, in.nextInt(), in.nextInt());
                pq.offer(ts);
            }
            int c = -1;
            int j = -1;
            boolean impossible = false;
            while (!pq.isEmpty()) {
                timeslot temp = pq.poll();
                if (c <= temp.start) {
                    res[temp.idx] = 'C';
                    c = temp.end;
                } else if (j <= temp.start) {
                    res[temp.idx] = 'J';
                    j = temp.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + new String(res));
            }
        }
    }
}
