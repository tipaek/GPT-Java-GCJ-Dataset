import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            if (assignTasks(intervals)) {
                System.out.println("Case #" + caseNumber + ": " + getResult(intervals));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }

    private static boolean assignTasks(int[][] intervals) {
        Map<Character, List<int[]>> schedule = new HashMap<>();
        schedule.put('C', new ArrayList<>());
        schedule.put('J', new ArrayList<>());

        for (int[] interval : intervals) {
            if (canAssign(schedule.get('C'), interval)) {
                schedule.get('C').add(interval);
                interval[2] = 'C';
            } else if (canAssign(schedule.get('J'), interval)) {
                schedule.get('J').add(interval);
                interval[2] = 'J';
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canAssign(List<int[]> intervals, int[] newInterval) {
        for (int[] interval : intervals) {
            if (interval[1] > newInterval[0] && interval[0] < newInterval[1]) {
                return false;
            }
        }
        return true;
    }

    private static String getResult(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        for (int[] interval : intervals) {
            result.append((char) interval[2]);
        }
        return result.toString();
    }
}