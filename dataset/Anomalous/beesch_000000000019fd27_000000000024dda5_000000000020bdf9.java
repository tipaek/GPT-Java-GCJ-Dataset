import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            
            for (int i = 1; i <= testCases; i++) {
                boolean[] cameronSchedule = new boolean[1440];
                boolean[] jamieSchedule = new boolean[1440];
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();
                
                int activities = scanner.nextInt();
                
                for (int j = 0; j < activities; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    
                    if (isImpossible) {
                        continue;
                    }
                    
                    if (!hasConflict(cameronSchedule, start, end)) {
                        markSchedule(cameronSchedule, start, end);
                        result.append("C");
                    } else if (!hasConflict(jamieSchedule, start, end)) {
                        markSchedule(jamieSchedule, start, end);
                        result.append("J");
                    } else {
                        isImpossible = true;
                    }
                }
                
                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + result.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasConflict(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return true;
            }
        }
        return false;
    }

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}