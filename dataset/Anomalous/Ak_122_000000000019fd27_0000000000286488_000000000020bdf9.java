import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            char[] result = new char[n];
            
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }
            
            activities.sort(Comparator.comparingInt(a -> a.end));
            
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    result[activity.pos] = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    result[activity.pos] = 'J';
                    jEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + i + ": ");
            if (possible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}

class Activity {
    int start;
    int end;
    int pos;
    
    public Activity(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}