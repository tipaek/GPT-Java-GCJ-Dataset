import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int[] temp = new int[2];
                temp[0] = in.nextInt();
                temp[1] = in.nextInt();
                list.add(temp);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(list));
        }
    }

    static String solve(ArrayList<int[]> ar) {
        String s = "J";
        int cEnd = 0;
        int cStart = 0;
        int jEnd = 0;
        int jStart = 0;

        int end = ar.get(0)[1];
        int start = ar.get(0)[0];
        jEnd = end;
        jStart = start;

        for (int i = 1; i < ar.size(); i++) {
            int curStart = ar.get(i)[0];
            int curEnd = ar.get(i)[1];
            if (curEnd < cStart) {
                s += "C";
                cStart = Math.min(cStart, curStart);
            } else if (curEnd < jStart) {
                s += "J";
                jStart = Math.min(jStart, curStart);
            } else if (curStart < end) {
                if (cEnd <= curStart) {
                    cEnd = curEnd;
                    cStart = Math.min(cStart, curStart);
                    s += "C";
                } else if (jEnd <= curStart) {
                    jEnd = curEnd;
                    jStart = Math.min(jStart, curStart);
                    s += "J";
                } else {
                    s = "IMPOSSIBLE";
                    break;
                }
                end = Math.max(curEnd, end);
            } else {
                s += "C";
                cEnd = curEnd;
                end = curEnd;
            }
        }
        return s;
    }
}