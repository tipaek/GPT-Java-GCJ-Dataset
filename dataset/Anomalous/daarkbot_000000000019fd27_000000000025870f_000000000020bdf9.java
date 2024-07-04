import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int totalCases = T;

        for (int caseNum = 1; caseNum <= totalCases; caseNum++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][3];
            char[] result = new char[N];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            char[] persons = {'C', 'J'};
            int[] endTimes = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            int p1 = 0, p2 = 1;
            boolean isPossible = true;

            for (int i = N - 1; i >= 0; i--) {
                if (endTimes[p1] > endTimes[p2]) {
                    int temp = p1;
                    p1 = p2;
                    p2 = temp;
                }

                if (intervals[i][1] <= endTimes[p1]) {
                    result[intervals[i][2]] = persons[p1];
                    endTimes[p1] = intervals[i][0];
                } else if (intervals[i][1] <= endTimes[p2]) {
                    result[intervals[i][2]] = persons[p2];
                    endTimes[p2] = intervals[i][0];
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder sb = new StringBuilder();
                for (char c : result) {
                    sb.append(c);
                }
                System.out.println("Case #" + caseNum + ": " + sb.toString());
            }
        }
    }
}