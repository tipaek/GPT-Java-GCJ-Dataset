import java.util.*;
import java.io.*;

import static java.util.Comparator.comparingInt;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int _t = 1; _t <= t; ++_t) {
            System.out.println("Case #" + _t + ": " + solve(in));
        }
    }

    static String solve(Scanner in) {
        int n = in.nextInt();
        int C = 0, J = 1, START = 0, END = 1, POS = 2, ASSIGN = 3;
        Integer[][] sch = new Integer[n][4];

        for (int i = 0; i < n; i++) {
            sch[i][START] = in.nextInt();
            sch[i][END] = in.nextInt();
            sch[i][POS] = i;
        }

        Arrays.sort(sch, comparingInt(a -> a[0]));

        int lastC = 0, lastJ = -1;
        sch[lastC][ASSIGN] = C;
        for (int i = 1; i < n; i++) {
            if (sch[i][START] < sch[lastC][END]) {
                if (lastJ == -1 || sch[i][START] >= sch[lastJ][END]) {
                    lastJ = i;
                    sch[i][ASSIGN] = J;
                } else return "IMPOSSIBLE";
            } else {
                lastC = i;
                sch[i][ASSIGN] = C;
            }
        }

        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[sch[i][POS]] = sch[i][ASSIGN] == J ? 'J' : 'C';
        }
        return new String(answer);
    }
}
