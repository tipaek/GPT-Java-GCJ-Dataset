import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            StringBuilder result = new StringBuilder(" ".repeat(n));

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(i, start, end);
            }

            Arrays.sort(activities, Comparator.comparingInt(Activity::getStart));

            int endC = -1;
            int endJ = -1;
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.getStart() >= endC) {
                    endC = activity.getEnd();
                    result.setCharAt(activity.getIndex(), 'C');
                } else if (activity.getStart() >= endJ) {
                    endJ = activity.getEnd();
                    result.setCharAt(activity.getIndex(), 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + result.toString().trim());
            }
        }
    }
}

class Activity {
    private final int index;
    private final int start;
    private final int end;

    public Activity(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}