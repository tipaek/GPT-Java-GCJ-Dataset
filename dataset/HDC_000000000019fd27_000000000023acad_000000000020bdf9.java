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
            char[] name = new char[]{'C', 'J'};
            int[] time = new int[]{-1, -1};
            int i = 0, cnt = 0;
            char[] cs = new char[na];
            while (i < na) {
                for (int j = 0; j < 2; ++j) {
                    if (time[j] <= acts[i].start) {
                        time[j] = acts[i].end;
                        cs[acts[i].index] = name[j];
                        cnt++;
                        break;
                    }
                }
                i++;
                if (i != cnt) break;
            }
            System.out.format("Case #%d: %s\n", t, na != cnt ? "IMPOSSIBLE" : new String(cs));
        }
        br.close();
    }
}