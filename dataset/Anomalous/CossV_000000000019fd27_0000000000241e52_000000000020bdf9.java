import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            int activities = Integer.parseInt(scanner.nextLine());
            
            boolean isImpossible = false;
            
            for (int i = 0; i < activities; i++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                int[] interval = { start, end };
                
                if (isIntervalOverlapping(interval, cameronSchedule)) {
                    if (isIntervalOverlapping(interval, jamieSchedule)) {
                        isImpossible = true;
                        break;
                    } else {
                        jamieSchedule.add(interval);
                        output.append("J");
                    }
                } else {
                    cameronSchedule.add(interval);
                    output.append("C");
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + output.toString());
            }
        }
        
        scanner.close();
    }

    private static boolean isIntervalOverlapping(int[] interval, List<int[]> schedule) {
        for (int[] scheduledInterval : schedule) {
            if (isOverlapping(interval[0], interval[1], scheduledInterval[0], scheduledInterval[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return end1 > start2 && start1 < end2;
    }
}