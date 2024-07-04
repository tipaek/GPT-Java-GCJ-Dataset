import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[24 * 60];
            boolean[] jamieSchedule = new boolean[24 * 60];
            StringBuilder result = new StringBuilder();
            
            boolean possible = true;
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                boolean cameronAvailable = isAvailable(cameronSchedule, start, end);
                boolean jamieAvailable = isAvailable(jamieSchedule, start, end);
                
                if (cameronAvailable) {
                    result.append('C');
                    fillSchedule(cameronSchedule, start, end);
                } else if (jamieAvailable) {
                    result.append('J');
                    fillSchedule(jamieSchedule, start, end);
                } else {
                    possible = false;
                }
            }
            
            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}