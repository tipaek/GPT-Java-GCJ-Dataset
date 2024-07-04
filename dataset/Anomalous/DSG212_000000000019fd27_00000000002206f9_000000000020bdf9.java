import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            StringBuilder schedule = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            boolean possible = true;
            for (int k = 0; k < n; k++) {
                if (!hasConflict(startTimes, endTimes, schedule, 'C', startTimes[k], endTimes[k])) {
                    schedule.append('C');
                } else if (!hasConflict(startTimes, endTimes, schedule, 'J', startTimes[k], endTimes[k])) {
                    schedule.append('J');
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
    }

    private static boolean hasConflict(int[] startTimes, int[] endTimes, StringBuilder schedule, char person, int start, int end) {
        for (int i = 0; i < schedule.length(); i++) {
            if (schedule.charAt(i) == person) {
                if ((start >= startTimes[i] && start < endTimes[i]) || (end > startTimes[i] && end <= endTimes[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}