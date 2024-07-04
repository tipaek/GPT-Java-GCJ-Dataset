import java.util.Scanner;

public class Schedule {
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
            
            processIntervals(intervals);
        }
        
        scanner.close();
    }
    
    private static void processIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}