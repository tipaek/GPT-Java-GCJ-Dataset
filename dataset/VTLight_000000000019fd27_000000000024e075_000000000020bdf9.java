import java.util.*;
import java.io.*;
public class Solution {
    static class Moment {
        int val;
        char ex;
        int idx;
        public Moment(int val, char ex, int idx) {
            this.val = val;
            this.ex = ex;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            char[] chars = new char[n];
            String res = null;
            PriorityQueue<Moment> heap = new PriorityQueue<>((m1, m2) -> {
                if(m1.val != m2.val) {
                    return m1.val - m2.val;
                }
                if(m1.ex == 'E') {
                    return -1;
                }
                if(m2.ex == 'E') {
                    return 1;
                }
                return m1.idx - m2.idx;
            });
            for(int j = 0; j < n; j++) {
                heap.add(new Moment(in.nextInt(), 'S', j));
                heap.add(new Moment(in.nextInt(), 'E', j));
            }

            Moment startJ = null;
            Moment startC = null;
            while(heap.size() > 0) {
                Moment m = heap.poll();
                char ex = m.ex;
                if(ex == 'S') {
                    if(startJ != null && startC != null) {
                        res = "IMPOSSIBLE";
                        break;
                    }
                    if(startJ != null) {
                        startC = m;
                        chars[m.idx] = 'C';
                    } else {
                        startJ = m;
                        chars[m.idx] = 'J';
                    }
                } else {
                    if(startJ != null && startJ.idx == m.idx) {
                        startJ = null;
                    } else {
                        startC = null;
                    }
                }
            }
            if(!"IMPOSSIBLE".equals(res)) {
                res = String.valueOf(chars);
            }
            System.out.println("Case #" + i + ": " + res);
        }
    }
}