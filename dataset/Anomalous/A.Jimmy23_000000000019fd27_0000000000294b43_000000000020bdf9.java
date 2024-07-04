import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int T = scanner.nextInt();
            int[] intervals = new int[T * 2];
            
            for (int i = 0; i < intervals.length; i++) {
                intervals[i] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("J");
            char currentTask = 'J';
            boolean impossible = false;
            int conflictCount = 0;
            boolean firstConflictResolved = false;
            
            for (int i = 1; i < intervals.length; i += 2) {
                if (!firstConflictResolved) {
                    if (i + 2 < intervals.length && intervals[i + 1] < intervals[i] && intervals[i + 2] < intervals[i]) {
                        conflictCount++;
                    } else {
                        firstConflictResolved = true;
                    }
                }
                
                if (conflictCount >= 2) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                
                if (i + 1 < intervals.length && intervals[i + 1] < intervals[i]) {
                    currentTask = (currentTask == 'J') ? 'C' : 'J';
                }
                
                schedule.append(currentTask);
            }
            
            System.out.println("Case #" + caseNum + ": " + (impossible ? "IMPOSSIBLE" : schedule.toString()));
        }
        
        scanner.close();
    }
}