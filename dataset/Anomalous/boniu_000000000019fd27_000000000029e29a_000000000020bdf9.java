import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            char[] result = new char[N];
            boolean isImpossible = false;
            
            List<Activity> activities = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, n));
            }
            
            activities.sort(Comparator.comparingInt(a -> a.start));
            
            int endC = 0, endJ = 0;
            for (Activity activity : activities) {
                if (endC <= activity.start) {
                    result[activity.index] = 'C';
                    endC = activity.end;
                } else if (endJ <= activity.start) {
                    result[activity.index] = 'J';
                    endJ = activity.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            String output = isImpossible ? "IMPOSSIBLE" : new String(result);
            System.out.println(String.format("Case #%d: %s", t, output));
        }
    }
    
    static class Activity {
        int start, end, index;
        
        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}