
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {
        int activities = in.nextInt();
        List<Activity> activityList = new ArrayList<>();
        for (int i = 0; i < activities; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            activityList.add(new Activity(i, start, end));
        }
        activityList.sort(Comparator.comparingInt(Activity::getStart));

        Activity activityC = null;
        Activity activityJ = null;
        for (Activity activity : activityList) {
            if (activityC == null || !activity.overlap(activityC)) {
                activity.setPerson("C");
                activityC = activity;
            } else if (activityJ == null || !activity.overlap(activityJ)) {
                activity.setPerson("J");
                activityJ = activity;
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNr));
                return;
            }
        }

        activityList.sort(Comparator.comparingInt(Activity::getNr));

        String result = activityList.stream()
                .map(Activity::getPerson)
                .collect(Collectors.joining());


        System.out.println(String.format("Case #%d: %s", caseNr, result));
    }

    static class Activity {

        int nr;
        int start;
        int end;
        String person;

        public Activity(int nr, int start, int end) {
            this.nr = nr;
            this.start = start;
            this.end = end;
        }

        public boolean overlap(Activity other) {
            return other.start < this.end && other.start >= this.start ||
                    this.start < other.end && this.start >= other.start;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getPerson() {
            return person;
        }

        public int getNr() {
            return nr;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
