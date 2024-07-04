import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            boolean isPossible = true;
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }

            char[] result = new char[n];
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int endJ = 0, endC = 0;
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= endJ) {
                    endJ = intervals[i][1];
                    result[intervals[i][2]] = 'J';
                } else if (intervals[i][0] >= endC) {
                    endC = intervals[i][1];
                    result[intervals[i][2]] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            String output = isPossible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + c + ": " + output);
        }
        sc.close();
    }
}