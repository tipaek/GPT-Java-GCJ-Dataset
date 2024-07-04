import java.util.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedStartTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                originalStartTimes[i] = startTimes[i];
                sortedStartTimes[i] = startTimes[i];
                endTimes[i] = scanner.nextInt();
                originalEndTimes[i] = endTimes[i];
                sortedEndTimes[i] = endTimes[i];
            }
            
            Arrays.sort(sortedStartTimes);
            
            char[] schedule = new char[n];
            int cameronEnd = 0, jamieEnd = 0;
            
            for (int i = 0; i < n; i++) {
                int minDuration = Integer.MAX_VALUE;
                int minIndex = -1;
                
                for (int j = 0; j < n; j++) {
                    if (originalStartTimes[j] == sortedStartTimes[i]) {
                        int duration = originalEndTimes[j] - originalStartTimes[j];
                        if (duration < minDuration) {
                            minDuration = duration;
                            minIndex = j;
                        }
                    }
                }
                
                sortedEndTimes[i] = originalEndTimes[minIndex];
                originalStartTimes[minIndex] = -1;  // Mark as used
            }
            
            boolean possible = true;
            schedule[0] = 'C';
            cameronEnd = sortedEndTimes[0];
            
            for (int i = 1; i < n; i++) {
                if (sortedStartTimes[i] >= cameronEnd) {
                    schedule[i] = 'C';
                    cameronEnd = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jamieEnd) {
                    schedule[i] = 'J';
                    jamieEnd = sortedEndTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[j] == startTimes[i] && sortedEndTimes[j] == endTimes[i]) {
                            System.out.print(schedule[j]);
                            break;
                        }
                    }
                }
                System.out.println();
            }
            
            caseNumber++;
        }
    }
}