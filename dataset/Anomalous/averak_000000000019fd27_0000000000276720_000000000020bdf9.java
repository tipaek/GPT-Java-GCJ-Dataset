import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt() - 1;
                
                if (!isImpossible) {
                    if (canSchedule(cameronSchedule, start, end)) {
                        result.append("C");
                        scheduleActivity(cameronSchedule, start, end);
                    } else if (canSchedule(jamieSchedule, start, end)) {
                        result.append("J");
                        scheduleActivity(jamieSchedule, start, end);
                    } else {
                        isImpossible = true;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
        scanner.close();
    }

    private static boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void scheduleActivity(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }
}