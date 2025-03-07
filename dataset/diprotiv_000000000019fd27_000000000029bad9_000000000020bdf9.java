import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Solution {
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
            Arrays.sort(ar, Comparator.comparingInt(i -> i.start));
            Interval[] active = new Interval[2];
            int cur = 0;
            StringBuilder ans = new StringBuilder("");
            inner:
            for(Interval activity : ar) {
                if(active[cur] == null || !doesOverlap(active[cur], activity)) {
                    active[cur] = activity;
                    ans.append(PERSON[cur]);
                } else if(active[other(cur)] == null || !doesOverlap(active[other(cur)], activity)) {
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

    private static boolean doesOverlap(Interval active, Interval incoming) {
        return active.end > incoming.start;
    }

    private static int other(int cur) {
        return (cur ^ 1);
    }
}
