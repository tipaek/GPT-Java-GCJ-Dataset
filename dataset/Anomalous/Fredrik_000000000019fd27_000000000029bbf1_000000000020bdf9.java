import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numSchedules = scanner.nextInt();
            scanner.nextLine();
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < numSchedules; j++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
                if (scanner.hasNextLine()) scanner.nextLine();
            }
            
            String result = assignSchedules(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignSchedules(List<int[]> intervals) {
        List<int[]> cameronSchedule = new ArrayList<>();
        List<int[]> jamieSchedule = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            if (isSlotAvailable(cameronSchedule, interval)) {
                cameronSchedule.add(interval);
                schedule.append("C");
            } else if (isSlotAvailable(jamieSchedule, interval)) {
                jamieSchedule.add(interval);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isSlotAvailable(List<int[]> schedule, int[] interval) {
        for (int[] booked : schedule) {
            if (booked[0] < interval[1] && interval[0] < booked[1]) {
                return false;
            }
        }
        return true;
    }
}