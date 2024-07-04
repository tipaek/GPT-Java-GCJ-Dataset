import java.util.*;
import java.io.*;

/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440 */
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
        String s = "C";
        int cEnd = 0;
        int jEnd = 0;

        ar.sort(Comparator.comparingInt(a -> a[1]));
        int end = ar.get(0)[1];
        cEnd = end;
        for (int i = 1; i < ar.size(); i++) {
            int curStart = ar.get(i)[0];
            int curEnd = ar.get(i)[1];
            if (curStart < end) {
                if (cEnd <= curStart) {
                    cEnd = curEnd;
                    s += "C";
                } else if (jEnd <= curStart) {
                    jEnd = curEnd;
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