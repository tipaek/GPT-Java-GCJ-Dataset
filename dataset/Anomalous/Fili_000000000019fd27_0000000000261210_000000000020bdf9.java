import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            char[] schedule = new char[N];
            
            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }
            
            activities.sort(Comparator.comparingInt(Activity::getEnd));
            
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.getStart() >= cEnd) {
                    schedule[activity.getIndex()] = 'C';
                    cEnd = activity.getEnd();
                } else if (activity.getStart() >= jEnd) {
                    schedule[activity.getIndex()] = 'J';
                    jEnd = activity.getEnd();
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + i + ": ");
            if (possible) {
                System.out.println(new String(schedule));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}

class Activity {
    private final int start;
    private final int end;
    private final int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }
}