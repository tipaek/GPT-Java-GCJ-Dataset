import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[1441];
            int[] originalStartTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[startTimes[j]] = scanner.nextInt();
            }
            
            originalStartTimes = Arrays.copyOf(startTimes, n);
            Arrays.sort(startTimes);
            
            int cEnd = 0;
            int jEnd = 0;
            boolean impossible = false;
            char[] schedule = new char[1441];
            
            for (int j = 0; j < n; j++) {
                if (startTimes[j] >= cEnd) {
                    schedule[startTimes[j]] = 'C';
                    cEnd = endTimes[startTimes[j]];
                } else if (startTimes[j] >= jEnd) {
                    schedule[startTimes[j]] = 'J';
                    jEnd = endTimes[startTimes[j]];
                } else {
                    impossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                result.append(schedule[originalStartTimes[j]]);
            }
            
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
        
        scanner.close();
    }
}