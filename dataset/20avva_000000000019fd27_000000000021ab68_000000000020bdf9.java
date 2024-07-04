import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String order;
            int numActivities = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            for (int activity = 0; activity < numActivities; activity++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            activities.sort((o1, o2) -> {
                if (o1.getStart() != o2.getStart()) {
                    return Integer.compare(o1.getStart(), o2.getStart());
                } else {
                    return Integer.compare(o1.getEnd(), o2.getEnd());
                }
            });

            order = generateAgenda(activities);

            System.out.println("Case #" + caseNum + ": " + order);
        }
    }

    public static String generateAgenda(ArrayList<Activity> activities) {
        StringBuilder order = new StringBuilder();
        Person cameron = new Person();
        Person jaime = new Person();

        for (Activity activity : activities) {
            if (activity.getStart() < cameron.getNextAvailability() && activity.getStart() < jaime.getNextAvailability()) {
                return "IMPOSSIBLE";
            } else if (activity.getStart() > cameron.getNextAvailability()) {
                order.append("C");
                cameron.setNextAvailability(activity.getEnd());
            } else if (activity.getStart() > jaime.getNextAvailability()) {
                order.append("J");
                jaime.setNextAvailability(activity.getEnd());
            }
        }

        return order.toString();
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
        private int nextAvailability;

        private Person() {
            this.nextAvailability = -1;
        }

        public int getNextAvailability() {
            return nextAvailability;
        }

        public void setNextAvailability(int nextAvailability) {
            this.nextAvailability = nextAvailability;
        }
    }
}
