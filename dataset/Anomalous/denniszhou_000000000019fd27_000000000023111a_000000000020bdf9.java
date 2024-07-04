import java.util.*;
import java.io.*;
import javafx.util.Pair;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            if (isPossibleSchedule(intervals)) {
                String schedule = assignTasks(intervals);
                System.out.println("Case #" + caseNum + ": " + schedule);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossibleSchedule(int[][] intervals) {
        int[] timeSlots = new int[1441];

        for (int[] interval : intervals) {
            for (int time = interval[0] + 1; time <= interval[1]; time++) {
                timeSlots[time]++;
                if (timeSlots[time] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        List<Pair<Integer, Integer>> assignedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            boolean isAssignedToJ = false;

            for (Pair<Integer, Integer> assigned : assignedIntervals) {
                if (interval[0] <= assigned.getKey() && interval[1] > assigned.getKey() ||
                    interval[0] < assigned.getValue() && interval[1] >= assigned.getValue()) {
                    schedule.append("J");
                    isAssignedToJ = true;
                    break;
                }
            }

            if (!isAssignedToJ) {
                assignedIntervals.add(new Pair<>(interval[0], interval[1]));
                schedule.append("C");
            }
        }

        return schedule.toString();
    }
}