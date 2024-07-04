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
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                activities.add(new Activity(S, E, j));
            }
            
            activities.sort(Comparator.comparingInt(Activity::getStart).thenComparingInt(Activity::getEnd));
            int C = 0, J = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.getStart() >= C) {
                    schedule[activity.getIndex()] = 'C';
                    C = activity.getEnd();
                } else if (activity.getStart() >= J) {
                    schedule[activity.getIndex()] = 'J';
                    J = activity.getEnd();
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.print("Case #" + i + ": ");
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
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