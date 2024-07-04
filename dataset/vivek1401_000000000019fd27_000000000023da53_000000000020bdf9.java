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

            for (int i = 0; i < n; i++) {
                times[i] = new Pair(scn.nextInt(), scn.nextInt());
            }

            Pair C_pair = times[0], J_pair = null;
            StringBuilder temp_ans = new StringBuilder("C");
            block:
            {

                for (int i = 1; i < n; i++) {
                    if (doOverlap(times[i], C_pair)) {
                        if (doOverlap(times[i], J_pair)) {
                            temp_ans = new StringBuilder("IMPOSSIBLE");
                            break block;
                        } else {
                            temp_ans.append("J");
                            J_pair = times[i];
                        }
                    } else {
                        temp_ans.append("C");
                        C_pair = times[i];
                    }
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

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}