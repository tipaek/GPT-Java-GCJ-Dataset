import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int k = 1; k <= testCases; k++) {
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            int numIntervals = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < numIntervals; i++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                int[] interval = {start, end};
                
                if (isOverlapping(interval, cameronSchedule)) {
                    if (isOverlapping(interval, jamieSchedule)) {
                        output = new StringBuilder("IMPOSSIBLE");
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

            System.out.println("Case #" + k + ": " + output.toString());
        }
        
        scanner.close();
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
        return end1 > start2 && start1 < end2;
    }
}