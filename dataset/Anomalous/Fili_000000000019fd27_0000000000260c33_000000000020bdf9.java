import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            char[] schedule = new char[activityCount];
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            activities.sort(Comparator.comparing(Activity::getEnd).thenComparing(Activity::getStart));
            
            int cEndTime = 0, jEndTime = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.getStart() >= cEndTime) {
                    schedule[activity.getIndex()] = 'C';
                    cEndTime = activity.getEnd();
                } else if (activity.getStart() >= jEndTime) {
                    schedule[activity.getIndex()] = 'J';
                    jEndTime = activity.getEnd();
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.print("Case #" + caseNumber + ": ");
                System.out.println(new String(schedule));
            }
        }
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