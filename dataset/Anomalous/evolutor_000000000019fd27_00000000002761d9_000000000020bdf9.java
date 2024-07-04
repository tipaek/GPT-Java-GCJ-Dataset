import java.util.Scanner;

class Activity {
    int start;
    int end;
    int index;
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].start = scanner.nextInt();
                activities[i].end = scanner.nextInt();
                activities[i].index = i;
            }
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));
            
            int endC = 0, endJ = 0;
            char[] result = new char[n];
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= endC) {
                    result[activity.index] = 'C';
                    endC = activity.end;
                } else if (activity.start >= endJ) {
                    result[activity.index] = 'J';
                    endJ = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNum + ": " + output);
        }
        
        scanner.close();
    }
}