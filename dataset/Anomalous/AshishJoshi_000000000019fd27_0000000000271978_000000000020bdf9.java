import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                if (startTimes[j] >= cEnd) {
                    schedule.append("C");
                    cEnd = endTimes[j];
                } else if (startTimes[j] >= jEnd) {
                    schedule.append("J");
                    jEnd = endTimes[j];
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}