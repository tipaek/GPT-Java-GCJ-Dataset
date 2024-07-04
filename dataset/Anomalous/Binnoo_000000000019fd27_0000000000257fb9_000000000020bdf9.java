import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int id;
    String assignee;

    public Activity(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    private int testCaseNumber;
    private Scanner scanner;
    private ArrayList<Activity> activities;

    public Solution(int testCaseNumber, Scanner scanner) {
        this.testCaseNumber = testCaseNumber;
        this.scanner = scanner;
        this.activities = new ArrayList<>();
    }

    public void solve() {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
        }
        Collections.sort(activities);

        int[] freeTime = new int[2];
        String[] parents = { "J", "C" };
        boolean impossible = false;

        for (Activity activity : activities) {
            boolean assigned = false;
            for (int p = 0; p < 2; p++) {
                if (freeTime[p] <= activity.start) {
                    activity.assignee = parents[p];
                    freeTime[p] = activity.end;
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                impossible = true;
                break;
            }
        }

        activities.sort(Comparator.comparingInt(a -> a.id));

        StringBuilder result = new StringBuilder();
        if (impossible) {
            result.append("IMPOSSIBLE");
        } else {
            for (Activity activity : activities) {
                result.append(activity.assignee);
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }
        scanner.close();
    }
}