import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < numberOfActivities; i++) {
                String[] timeInterval = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeInterval[0]);
                int endTime = Integer.parseInt(timeInterval[1]);
                int[] currentInterval = {startTime, endTime};
                
                if (isOverlapping(currentInterval, cameronSchedule)) {
                    if (isOverlapping(currentInterval, jamieSchedule)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        jamieSchedule.add(currentInterval);
                        result.append("J");
                    }
                } else {
                    cameronSchedule.add(currentInterval);
                    result.append("C");
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean isOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (intervalsOverlap(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean intervalsOverlap(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }
}