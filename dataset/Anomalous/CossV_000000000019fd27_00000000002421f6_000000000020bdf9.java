import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder scheduleOutput = new StringBuilder();
            int activityCount = Integer.parseInt(scanner.nextLine());
            
            boolean isImpossible = false;
            for (int activity = 0; activity < activityCount; activity++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                int[] interval = { start, end };
                
                if (isOverlapping(interval, cameronSchedule)) {
                    if (isOverlapping(interval, jamieSchedule)) {
                        isImpossible = true;
                    } else {
                        jamieSchedule.add(interval);
                        scheduleOutput.append("J");
                    }
                } else {
                    cameronSchedule.add(interval);
                    scheduleOutput.append("C");
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + scheduleOutput.toString());
            }
        }
        
        scanner.close();
    }

    private static boolean isOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (scheduledInterval != null && scheduledInterval.length == 2) {
                if (isOverlap(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOverlap(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }
}