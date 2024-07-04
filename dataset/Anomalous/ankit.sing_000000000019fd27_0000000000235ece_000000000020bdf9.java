import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int schedules = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;
            
            for (int schedule = 0; schedule < schedules; schedule++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (startTime >= cameronEnd) {
                    cameronEnd = endTime;
                    result.append('C');
                } else if (startTime >= jamieEnd) {
                    jamieEnd = endTime;
                    result.append('J');
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }
}