import java.util.Scanner;

public class ScheduleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int i = 0; i < numCases; i++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            
            for (int j = 0; j < numIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            // Process intervals for each case as needed
            processIntervals(intervals);
        }
        
        scanner.close();
    }
    
    private static void processIntervals(int[][] intervals) {
        // Placeholder for processing logic
        for (int[] interval : intervals) {
            System.out.println("Start: " + interval[0] + ", End: " + interval[1]);
        }
    }
}