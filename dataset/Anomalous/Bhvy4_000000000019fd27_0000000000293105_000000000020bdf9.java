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
        int jIndex = 0;
        int cIndex = 1;
        StringBuilder schedule = new StringBuilder("JC");

        for (int i = 2; i < activities.size(); i++) {
            if (activities.get(i).getStart() >= activities.get(jIndex).getFinish()) {
                schedule.append("J");
                jIndex = i;
            } else if (activities.get(i).getStart() >= activities.get(cIndex).getFinish()) {
                schedule.append("C");
                cIndex = i;
            }
        }

        if (schedule.length() < activities.size()) {
            return "IMPOSSIBLE";
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt()));
            }

            activities.sort(Comparator.comparingInt(Activity::getFinish));
            String result = selectActivity(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}