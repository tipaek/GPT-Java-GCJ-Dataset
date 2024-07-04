package qualificationRound;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isTimeSlotFree(jamieSchedule, start, end)) {
                    result.append('J');
                    markTimeSlot(jamieSchedule, start, end);
                } else if (isTimeSlotFree(cameronSchedule, start, end)) {
                    result.append('C');
                    markTimeSlot(cameronSchedule, start, end);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    private static boolean isTimeSlotFree(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}