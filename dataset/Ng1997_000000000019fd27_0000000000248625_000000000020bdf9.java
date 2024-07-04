
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ParentingPartneringReturns.Run();
    }
}

class ParentingPartneringReturns {
    public static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void Run() {
        int t = sc.nextInt();
        for (int i=1; i<=t; i++) {
            int n = sc.nextInt();
            int intervals[][] = new int[n][3];
            for (int j=0; j<n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
                intervals[j][2] = j;
            }
            printOutput(i, solve(intervals, n));
        }
    }

    public static void printOutput(int test, String op) {
        System.out.printf("Case #%d: %s\n", test, op);
    }

    private static String solve(int [][]intervals, int n) {
        String ans = "IMPOSSIBLE";
        boolean assigned[] = new boolean[n];
        for (int i=0; i<n; i++) {
            assigned[i] = false;
        }
        Arrays.sort(intervals, 0, n, (interval1, interval2) -> {
            if (interval1[0] > interval2[0]) {
                return 1;
            }
            if (interval1[0] < interval2[0]) {
                return -1;
            }
            if (interval1[1] > interval2[1]) {
                return 1;
            }
            if (interval1[1] < interval2[1]) {
                return 1;
            }
            return 0;
        });
        int lastX = 100000,lastY = -1;
        for (int i=0; i<n; i++) {
            if ( isOverlapping(lastX, lastY, intervals[i][0], intervals[i][1]) ) {
                continue;
            }
            lastX = Math.min(intervals[i][0], lastX);
            lastY = Math.max(intervals[i][1], lastY);
            assigned[i] = true;
        }
        lastX = 100000;
        lastY = -1;
        for (int i=0; i<n; i++) {
            if ( assigned[i] ) {
                continue;
            }
            if ( isOverlapping(lastX, lastY, intervals[i][0], intervals[i][1]) ) {
                return ans;
            }
            lastX = Math.min(intervals[i][0], lastX);
            lastY = Math.max(intervals[i][1], lastY);
        }
        char chArrAns[] = new char[n];
        for (int i=0; i<n; i++) {
            if ( assigned[i] ) {
                chArrAns[intervals[i][2]] = 'C';
            } else {
                chArrAns[intervals[i][2]] = 'J';
            }
        }
        ans = String.valueOf(chArrAns);
        return ans;
    }

    private static boolean isOverlapping(int x1, int y1, int x2, int y2) {
        if (y1 > x2 && x1 <= x2) {
            return true;
        }
        if (y2 > x1 && x2 <= x1) {
            return true;
        }
        return false;
    }
}
