import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                originalStartTimes[i] = startTimes[i];
            }
            
            // Sort intervals by start time
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (startTimes[j] > startTimes[j + 1]) {
                        int tempStart = startTimes[j];
                        startTimes[j] = startTimes[j + 1];
                        startTimes[j + 1] = tempStart;
                        
                        int tempEnd = endTimes[j];
                        endTimes[j] = endTimes[j + 1];
                        endTimes[j + 1] = tempEnd;
                    }
                }
            }
            
            StringBuilder schedule = new StringBuilder("C");
            int cameronEnd = endTimes[0];
            int jamieEnd = -1;
            boolean possible = true;
            
            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = endTimes[i];
                } else if (startTimes[i] >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = endTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                // Reconstruct the final answer based on original start times
                char[] finalSchedule = new char[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalStartTimes[i] == startTimes[j]) {
                            finalSchedule[i] = schedule.charAt(j);
                            startTimes[j] = -1; // Mark as used
                            break;
                        }
                    }
                }
                System.out.println("Case #" + testCase + ": " + new String(finalSchedule));
            }
        }
    }
}