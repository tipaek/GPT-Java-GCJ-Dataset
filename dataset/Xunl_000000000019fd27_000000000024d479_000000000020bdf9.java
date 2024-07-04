import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            arrangeParenting(i, N, in);
        }
    }

    public static void arrangeParenting(int x, int N, Scanner in) {
        int[][] intervals = new int[N][3];
        char[] c = {'J', 'C'};
        for (int i = 0; i < N; ++i) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
            intervals[i][2] = i;
        }
        Arrays.sort(intervals, (a,b)-> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int C = 0, J = 0; // C and J tracks end time of currently assigned event to C and J.
        char[] arrangement = new char[N];
        for (int i = 0; i < N; ++i) {
            if (intervals[i][0] < C && intervals[i][0] < J) {
                System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                return;
            } else if(intervals[i][0] >= C) {
                C = intervals[i][1];
                arrangement[intervals[i][2]] = 'C';
            } else {
                J = intervals[i][1];
                arrangement[intervals[i][2]] = 'J';
            }
        }
        System.out.println("Case #" + x + ": " + String.valueOf(arrangement));
    }
}