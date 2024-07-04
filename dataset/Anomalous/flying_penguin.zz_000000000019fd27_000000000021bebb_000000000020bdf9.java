import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];
            
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameronSchedule, start, end)) {
                    markSchedule(cameronSchedule, start, end);
                    result.append("C");
                } else if (isAvailable(jamieSchedule, start, end)) {
                    markSchedule(jamieSchedule, start, end);
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
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

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}