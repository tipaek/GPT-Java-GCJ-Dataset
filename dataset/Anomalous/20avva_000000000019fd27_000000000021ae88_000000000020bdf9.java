import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            activities.sort((a1, a2) -> {
                if (a1.getStart() != a2.getStart()) {
                    return Integer.compare(a1.getStart(), a2.getStart());
                } else {
                    return Integer.compare(a1.getEnd(), a2.getEnd());
                }
            });

            String result = scheduleActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String scheduleActivities(ArrayList<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        Person cameron = new Person();
        Person jaime = new Person();

        for (Activity activity : activities) {
            if (activity.getStart() < cameron.getNextAvailable() && activity.getStart() < jaime.getNextAvailable()) {
                return "IMPOSSIBLE";
            } else if (activity.getStart() >= cameron.getNextAvailable()) {
                schedule.append("C");
                cameron.setNextAvailable(activity.getEnd());
            } else if (activity.getStart() >= jaime.getNextAvailable()) {
                schedule.append("J");
                jaime.setNextAvailable(activity.getEnd());
            }
        }

        return schedule.toString();
    }

    private static class Activity {
        private final int start;
        private final int end;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static class Person {
        private int nextAvailable;

        private Person() {
            this.nextAvailable = 0;
        }

        public int getNextAvailable() {
            return nextAvailable;
        }

        public void setNextAvailable(int nextAvailable) {
            this.nextAvailable = nextAvailable;
        }
    }
}