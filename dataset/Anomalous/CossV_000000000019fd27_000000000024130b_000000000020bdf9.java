import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < activityCount; i++) {
                String[] timeInterval = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeInterval[0]);
                int end = Integer.parseInt(timeInterval[1]);
                int[] interval = {start, end};
                
                if (isOverlapping(interval, cameronSchedule)) {
                    if (isOverlapping(interval, jamieSchedule)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        jamieSchedule.add(interval);
                        result.append("J");
                    }
                } else {
                    cameronSchedule.add(interval);
                    result.append("C");
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + testCase + ": " + result.toString());
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
        
        scanner.close();
    }

    private static boolean isOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (isConflict(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isConflict(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }
}