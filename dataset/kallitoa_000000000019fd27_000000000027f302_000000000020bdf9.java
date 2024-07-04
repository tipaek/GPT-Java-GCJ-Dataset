import java.util.*;

public class Solution {

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int t = Integer.valueOf(input.nextLine());
        int caseNumber = 1;
        List<String> results = new ArrayList<>();

        while (t > 0) {
            int n = Integer.valueOf(input.nextLine());
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] s = input.nextLine().split(" ");
                int a = Integer.valueOf(s[0]);
                int b = Integer.valueOf(s[1]);

                activities.add(new Activity(a, b));
            }
            results.add(String.format("Case #%d: %s", caseNumber, getResult(activities)));
            caseNumber++;
            t--;
        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String getResult(List<Activity> activities) {
        Collections.sort(activities);
        Map<String, Activity> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (Activity activity : activities) {
            boolean taken = false;
            if (map.containsKey("C")) {
                Activity Cold = map.get("C");
                if (Cold.end <= activity.start) {
                    result.append("C");
                    map.put("C", activity);
                    taken = true;
                }
            }
            if (!taken && map.containsKey("J")) {
                Activity Jold = map.get("J");
                if (Jold.end <= activity.start) {
                    result.append("J");
                    map.put("J", activity);
                    taken = true;
                }
            }
            if (!taken && !map.containsKey("C")) {
                map.put("C", activity);
                result.append("C");
                taken = true;
            }
            if (!taken && !map.containsKey("J")) {
                map.put("J", activity);
                result.append("J");
                taken = true;
            }
            if (!taken) {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(this.start, o.start);
        }
    }
}
