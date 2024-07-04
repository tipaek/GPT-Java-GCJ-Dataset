import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities.add(new Activity(start, end));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            int cEnd = 0;
            int jEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    cEnd = activity.end;
                    schedule.append("C");
                } else if (activity.start >= jEnd) {
                    jEnd = activity.end;
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }

            caseNumber++;
        }

        sc.close();
    }
}

class Activity {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}