import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            String result = assignTasks(jamie, cameron, intervals, 0, "");
            System.out.println("Case #" + (l + 1) + ": " + result);
        }
    }

    static String assignTasks(int[] jamie, int[] cameron, int[][] intervals, int index, String currentSchedule) {
        if (index == intervals.length) {
            return currentSchedule;
        }
        
        int start = intervals[index][0];
        int end = intervals[index][1];
        
        if (canAssign(jamie, start, end)) {
            markTime(jamie, start, end, 1);
            String result = assignTasks(jamie, cameron, intervals, index + 1, currentSchedule + "J");
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
            markTime(jamie, start, end, 0); // backtrack
        }
        
        if (canAssign(cameron, start, end)) {
            markTime(cameron, start, end, 1);
            String result = assignTasks(jamie, cameron, intervals, index + 1, currentSchedule + "C");
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
            markTime(cameron, start, end, 0); // backtrack
        }
        
        return "IMPOSSIBLE";
    }

    static boolean canAssign(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void markTime(int[] schedule, int start, int end, int value) {
        for (int i = start; i < end; i++) {
            schedule[i] = value;
        }
    }
}