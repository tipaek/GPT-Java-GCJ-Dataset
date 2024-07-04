import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        StringBuilder ans = new StringBuilder();

        int t = scn.nextInt();
        for (int case_num = 1; case_num <= t; case_num++) {
            ans.append("Case #").append(case_num).append(": ");

            int n = scn.nextInt();
            Pair[] times = new Pair[n];

            Pair[] times_ascending = new Pair[n];

            for (int i = 0; i < n; i++) {
                times[i] = new Pair(scn.nextInt(), scn.nextInt());
            }
            for (int i = 0; i < n; i++) {
                times_ascending[i] = times[i];
            }

            Arrays.sort(times_ascending);

            Pair C_pair = times_ascending[0], J_pair = null;
            C_pair.ans = "C";
            StringBuilder temp_ans = new StringBuilder();
            block:
            {

                for (int i = 1; i < n; i++) {
                    if (doOverlap(times_ascending[i], C_pair)) {
                        if (doOverlap(times_ascending[i], J_pair)) {
                            temp_ans = new StringBuilder("IMPOSSIBLE");
                            break block;
                        } else {
                            J_pair = times_ascending[i];
                            J_pair.ans = "J";
                        }
                    } else {
                        C_pair = times_ascending[i];
                        C_pair.ans = "C";
                    }
                }

                for (int i = 0; i < n; i++) {
                    temp_ans.append(times[i].ans);
                }

            }

            ans.append(temp_ans);

            ans.append("\n");

        }

        System.out.println(ans);

    }

    static boolean doOverlap(Pair a, Pair b) {
        if (a == null || b == null) return false;
        return (a.start > b.start && a.start < b.end)
                || (a.start <= b.start && a.end >= b.end)
                || (a.end > b.start && a.end < b.end);
    }

    static class Pair implements Comparable<Pair> {
        int start, end;
        String ans;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            ans = null;
        }

        @Override
        public int compareTo(Pair o) {
            return this.start - o.start;
        }
    }

}