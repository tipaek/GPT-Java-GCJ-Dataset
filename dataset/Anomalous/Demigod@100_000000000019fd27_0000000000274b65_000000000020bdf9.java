import java.util.*;

class Activity {
    int number;
    int start;
    int end;

    Activity(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }
}

class Solution {
    public static String assignActivities(ArrayList<Activity> activities, int n) {
        char[] schedule = new char[n];
        int cEnd = 0;
        int jEnd = 0;

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                schedule[activity.number] = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                schedule[activity.number] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            activities.sort((a1, a2) -> {
                if (a1.start != a2.start) {
                    return Integer.compare(a1.start, a2.start);
                }
                return Integer.compare(a1.end, a2.end);
            });

            String result = assignActivities(activities, n);
            System.out.println("Case #" + (testCase++) + ": " + result);
        }

        scanner.close();
    }
}