import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;
            
            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;
                
                if (isPossible) {
                    for (int j = 0; j < i; j++) {
                        if (schedule.charAt(j) == 'C') {
                            if (cameronAvailable && conflicts(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                                cameronAvailable = false;
                            }
                        } else {
                            if (jamieAvailable && conflicts(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                                jamieAvailable = false;
                            }
                        }
                    }
                    
                    if (cameronAvailable) {
                        schedule.append('C');
                    } else if (jamieAvailable) {
                        schedule.append('J');
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
    }
    
    private static boolean conflicts(int start1, int end1, int start2, int end2) {
        return (start1 < start2 && end1 > start2) || (start1 > start2 && end2 > start1);
    }
}