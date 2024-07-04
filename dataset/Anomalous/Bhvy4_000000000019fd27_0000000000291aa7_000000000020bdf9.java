import java.util.*;

class Activity {
    private int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int getFinish() {
        return finish;
    }

    public int getStart() {
        return start;
    }
}

public class Solution {

    // Activity-Selection problem
    public static String selectActivity(List<Activity> activities) {
        int jEnd = 0, cEnd = 0;
        char[] schedule = new char[activities.size()];

        for (int i = 0; i < activities.size(); i++) {
            Activity current = activities.get(i);
            if (current.getStart() >= jEnd) {
                schedule[i] = 'J';
                jEnd = current.getFinish();
            } else if (current.getStart() >= cEnd) {
                schedule[i] = 'C';
                cEnd = current.getFinish();
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int finish = sc.nextInt();
                activities.add(new Activity(start, finish));
            }

            activities.sort(Comparator.comparingInt(Activity::getFinish));
            String result = selectActivity(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }

        sc.close();
    }
}