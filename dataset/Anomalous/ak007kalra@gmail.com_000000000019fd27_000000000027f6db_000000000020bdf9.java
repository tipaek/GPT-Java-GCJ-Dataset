import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = input.nextInt();
                    originalIntervals[j][k] = intervals[j][k];
                }
            }
            
            boolean impossible = false;
            for (int[] interval : intervals) {
                if (interval[1] <= interval[0]) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            if (impossible) continue;
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            
            int[] rem = new int[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (originalIntervals[j][0] == intervals[k][0]) {
                        rem[j] = k;
                        break;
                    }
                }
            }
            
            StringBuilder schedule = new StringBuilder();
            schedule.append('C');
            int[] c = {intervals[0][0], intervals[0][1]};
            int[] j = {0, 0};
            
            for (int m = 1; m < n; m++) {
                if (intervals[m][0] < c[1]) {
                    if (intervals[m][0] >= j[1]) {
                        schedule.append('J');
                        j[0] = intervals[m][0];
                        j[1] = intervals[m][1];
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                } else {
                    schedule.append('C');
                    c[0] = intervals[m][0];
                    c[1] = intervals[m][1];
                }
            }
            if (impossible) continue;
            
            StringBuilder output = new StringBuilder();
            for (int m = 0; m < n; m++) {
                output.append(schedule.charAt(rem[m]));
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}