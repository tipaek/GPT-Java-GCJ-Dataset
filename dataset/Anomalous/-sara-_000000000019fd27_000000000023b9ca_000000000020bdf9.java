package qualificationRound;

import java.util.Scanner;

public class SolutionProblem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            int activities = scanner.nextInt();
            StringBuilder solution = new StringBuilder();
            boolean possible = true;
            
            for (int j = 0; j < activities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (possible) {
                    if (isTimeSlotAvailable(jamieSchedule, startTime, endTime)) {
                        solution.append("J");
                        markTimeSlot(jamieSchedule, startTime, endTime);
                    } else if (isTimeSlotAvailable(cameronSchedule, startTime, endTime)) {
                        solution.append("C");
                        markTimeSlot(cameronSchedule, startTime, endTime);
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + solution.toString());
        }
        
        scanner.close();
    }
    
    private static boolean isTimeSlotAvailable(boolean[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }
    
    private static void markTimeSlot(boolean[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = true;
        }
    }
}