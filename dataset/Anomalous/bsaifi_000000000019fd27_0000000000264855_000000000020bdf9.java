import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = sc.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("C");
            boolean possible = true;
            
            for (int i = 1; i < numActivities; i++) {
                if (endTimes[i - 1] > startTimes[i]) {
                    if (schedule.charAt(i - 1) == 'C') {
                        schedule.append("J");
                    } else if (schedule.charAt(i - 1) == 'J' && (i < 2 || schedule.charAt(i - 2) == 'C')) {
                        possible = false;
                        break;
                    } else {
                        schedule.append("C");
                    }
                } else {
                    schedule.append("C");
                }
            }
            
            if (possible) {
                System.out.println("Case #" + testCase + ": " + schedule);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}