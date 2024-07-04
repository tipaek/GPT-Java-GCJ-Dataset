import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("C");
            boolean possible = true;
            
            for (int i = 1; i < n; i++) {
                if (endTimes[i - 1] > startTimes[i]) {
                    if (schedule.charAt(i - 1) == 'C') {
                        schedule.append('J');
                    } else if (schedule.charAt(i - 1) == 'J' && i > 1 && schedule.charAt(i - 2) == 'C') {
                        possible = false;
                        break;
                    } else {
                        schedule.append('C');
                    }
                } else if (endTimes[i - 1] == startTimes[i]) {
                    schedule.append(schedule.charAt(i - 1));
                } else {
                    schedule.append('C');
                }
            }
            
            if (possible) {
                System.out.println("Case #" + t + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}