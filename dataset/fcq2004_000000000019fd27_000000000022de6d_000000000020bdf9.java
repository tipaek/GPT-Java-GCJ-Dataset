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
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            N = in.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int[] temp = new int[3];
                temp[0] = in.nextInt();
                temp[1] = in.nextInt();
                temp[2] = j;
                list.add(temp);
            }
            list.sort(Comparator.comparingInt(a -> a[0]));
            System.out.println("Case #" + (i + 1) + ": " + solve(list));
        }
    }

    static String solve(ArrayList<int[]> ar) {
        char[] s = new char[N];
        String st = "";
        int cEnd = 0;
        int jEnd = 0;
        int end = 100000;
        for (int i = 0; i < ar.size(); i++) {
            int curStart = ar.get(i)[0];
            int curEnd = ar.get(i)[1];
            if (curStart < end) {
                if (cEnd <= curStart) {
                    cEnd = curEnd;
                    s[ar.get(i)[2]] = 'C';
                } else if (jEnd <= curStart) {
                    jEnd = curEnd;
                    s[ar.get(i)[2]] = 'J';
                } else {
                    st = "IMPOSSIBLE";
                }
            } else {
                cEnd = curEnd;
                s[ar.get(i)[2]] = 'C';
            }
            end = Math.max(curEnd, end);
        }
        if (!st.equals("IMPOSSIBLE")) {
            for (char c : s) {
                st += c;
            }
        }
        return st;
    }
}