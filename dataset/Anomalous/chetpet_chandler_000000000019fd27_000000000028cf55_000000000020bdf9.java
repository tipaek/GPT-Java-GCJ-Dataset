import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));
            
            StringBuilder result = new StringBuilder();
            int endC = 0;
            int endJ = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= endC) {
                    result.append('C');
                    endC = activity.end;
                } else if (activity.start >= endJ) {
                    result.append('J');
                    endJ = activity.end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
    
    static class Activity {
        int start;
        int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}