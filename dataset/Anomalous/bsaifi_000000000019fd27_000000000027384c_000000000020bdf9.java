import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("C");
            boolean isPossible = true;
            
            for (int i = 1; i < n; i++) {
                if (endTimes[i - 1] > startTimes[i]) {
                    if (endTimes[i] == startTimes[i - 1]) {
                        schedule.append(schedule.charAt(i - 1));
                    } else if (schedule.charAt(i - 1) == 'C') {
                        schedule.append("J");
                    } else if (schedule.charAt(i - 1) == 'J' && schedule.charAt(i - 2) == 'C') {
                        isPossible = false;
                        break;
                    } else {
                        schedule.append("C");
                    }
                } else if (endTimes[i - 1] == startTimes[i]) {
                    schedule.append(schedule.charAt(i - 1));
                } else if (endTimes[i - 1] < startTimes[i] && startTimes[i - 1] < endTimes[i]) {
                    schedule.append(schedule.charAt(i - 1));
                } else {
                    if (schedule.charAt(i - 1) == 'J') {
                        schedule.append("C");
                    } else {
                        schedule.append("J");
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}