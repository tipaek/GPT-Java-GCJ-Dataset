import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            char[] schedule = new char[N];
            for (int j = 0; j < N; j++) {
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                activities[j] = new Activity(S, E, j);
            }
            Arrays.sort(activities, Comparator.comparingInt(Activity::getEnd).thenComparingInt(Activity::getStart));

            int C_end = 0, J_end = 0;
            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.getStart() >= C_end) {
                    schedule[activity.getIndex()] = 'C';
                    C_end = activity.getEnd();
                } else if (activity.getStart() >= J_end) {
                    schedule[activity.getIndex()] = 'J';
                    J_end = activity.getEnd();
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.print("Case #" + i + ": ");
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