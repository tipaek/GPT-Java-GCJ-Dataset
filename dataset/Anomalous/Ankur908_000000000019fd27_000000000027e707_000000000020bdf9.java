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
            int[] job1Schedule = new int[1441];
            int[] job2Schedule = new int[1441];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                boolean job1Conflict = false;
                boolean job2Conflict = false;
                
                for (int time = startTimes[i]; time < endTimes[i]; time++) {
                    if (job1Schedule[time] == 1) {
                        job1Conflict = true;
                    }
                    if (job2Schedule[time] == 1) {
                        job2Conflict = true;
                    }
                }
                
                if (job1Conflict && job2Conflict) {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else if (!job1Conflict) {
                    for (int time = startTimes[i]; time < endTimes[i]; time++) {
                        job1Schedule[time] = 1;
                    }
                    schedule.append('C');
                } else {
                    for (int time = startTimes[i]; time < endTimes[i]; time++) {
                        job2Schedule[time] = 1;
                    }
                    schedule.append('J');
                }
            }
            
            System.out.println("Case #" + testCase + ": " + schedule);
        }
        
        scanner.close();
    }
}