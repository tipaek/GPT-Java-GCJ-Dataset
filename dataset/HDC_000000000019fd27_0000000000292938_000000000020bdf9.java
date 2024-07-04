import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
    static class Act {
        int start, end, index;
        public Act(int s, int e, int i) { start = s; end = e; index = i; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            int na = Integer.parseInt(br.readLine());
            Act[] acts = new Act[na];
            for (int i = 0; i < na; ++i) {
                String[] data = br.readLine().split("\\s+");
                int start = Integer.parseInt(data[0]), end = Integer.parseInt(data[1]);
                acts[i] = new Act(start, end, i);
            }
            Arrays.sort(acts, (a, b) -> a.end == b.end ? a.start - b.start : a.end - b.end);
            int[] lis = new int[na], prev = new int[na];
            Arrays.fill(prev, -1);
            int cnt = 0;
            for (int i = 0; i < na; ++i) {
                int lo = 0, hi = cnt;
                while (lo < hi) {
                    int mid = lo + ((hi - lo) >> 1);
                    if (acts[lis[mid]].end <= acts[i].start) lo = mid + 1;
                    else hi = mid;
                }
                if (cnt == lo) lis[lo] = i;
                else if (acts[lis[lo]].end > acts[i].end) lis[lo] = i;
                if (0 != lo) prev[i] = lis[lo - 1];
                if (cnt == lo) cnt++;
            }
            Deque<Integer> dq = new LinkedList();
            for (int i = cnt - 1, j = lis[i]; 0 <= i; --i) {
                dq.add(j);
                j = prev[j];
            }
            char[] cs = new char[na];
            cnt = 0;
            for (int i = 0, j = -1; i < na; ++i) {
                if (!dq.isEmpty() && i == dq.peekLast()) {
                    cs[acts[i].index] = 'C';
                    dq.pollLast();
                } else if (-1 != j && acts[j].end > acts[i].start) break;
                else {
                    j = i;
                    cs[acts[i].index] = 'J';
                }
                cnt++;
            }
            System.out.format("Case #%d: %s\n", t, na != cnt ? "IMPOSSIBLE" : new String(cs));
        }
        br.close();
    }
}