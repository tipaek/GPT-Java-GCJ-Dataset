import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int[][] intervals = new int[2][n];
            int[][] originalIntervals = new int[2][n];
            
            for (int i = 0; i < n; i++) {
                intervals[0][i] = sc.nextInt();
                intervals[1][i] = sc.nextInt();
                originalIntervals[0][i] = intervals[0][i];
                originalIntervals[1][i] = intervals[1][i];
            }
            
            sortIntervals(intervals, n);
            
            char[] assignedTasks = new char[n];
            char[] result = new char[n];
            boolean[] used = new boolean[n];
            
            int cEndTime = intervals[1][0];
            int jEndTime = 0;
            assignedTasks[0] = 'C';
            
            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if (intervals[0][i] >= cEndTime) {
                    cEndTime = intervals[1][i];
                    assignedTasks[i] = 'C';
                } else if (intervals[0][i] >= jEndTime) {
                    jEndTime = intervals[1][i];
                    assignedTasks[i] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        if (originalIntervals[0][a] == intervals[0][b] &&
                            originalIntervals[1][a] == intervals[1][b] &&
                            !used[b]) {
                            used[b] = true;
                            result[a] = assignedTasks[b];
                            break;
                        }
                    }
                }
                System.out.print("Case #" + q + ": ");
                for (char ch : result) {
                    System.out.print(ch);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + q + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortIntervals(int[][] intervals, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (intervals[0][i] > intervals[0][j]) {
                    swap(intervals, i, j);
                }
            }
        }
    }

    private static void swap(int[][] intervals, int i, int j) {
        int tempStart = intervals[0][i];
        int tempEnd = intervals[1][i];
        intervals[0][i] = intervals[0][j];
        intervals[1][i] = intervals[1][j];
        intervals[0][j] = tempStart;
        intervals[1][j] = tempEnd;
    }
}