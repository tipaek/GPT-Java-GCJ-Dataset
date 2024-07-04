import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Solution{
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static final char[] PERSON = {'C', 'J'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());
            Interval[] ar = new Interval[n];
            for(int i = 0; i < n; i++) {
                String[] _input = ((br.readLine()).trim()).split("\\s+");
                ar[i] = new Interval(Integer.parseInt(_input[0]), Integer.parseInt(_input[1]));
            }
            System.out.print(String.format("Case #%d: ", t));
            Arrays.sort(ar, (i1, i2) -> {
                if(i1.end == i2.end) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            });
            Interval[] active = new Interval[2];
            int cur = 0;
            StringBuilder ans = new StringBuilder("");
            inner:
            for(Interval activity : ar) {
                if(active[cur] == null || noOverlap(active[cur], activity)) {
                    active[cur] = activity;
                    ans.append(PERSON[cur]);
                } else if(active[other(cur)] == null || noOverlap(active[other(cur)], activity)) {
                    cur = other(cur);
                    active[cur] = activity;
                    ans.append(PERSON[cur]);
                } else {
                    System.out.println("IMPOSSIBLE");
                    cur = -1;
                    break inner;
                }
            }
            if(cur != -1) {
                System.out.println(ans.toString());
            }
        }

    }

    private static boolean noOverlap(Interval active, Interval i) {
        return active.end <= i.start;
    }

    private static int other(int cur) {
        return (cur ^ 1);
    }
}
