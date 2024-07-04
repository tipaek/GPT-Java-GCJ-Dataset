import java.util.ArrayList;
import java.util.Comparator;
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
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), activity));
            }

            activities.sort((o1, o2) -> {
                if (o1.getStart() != o2.getStart()) {
                    return Integer.compare(o1.getStart(), o2.getStart());
                } else {
                    return Integer.compare(o1.getEnd(), o2.getEnd());
                }
            });

            order = generateAgenda(activities);
            if (order == null) order = "IMPOSSIBLE";
            System.out.println("Case #" + caseNum + ": " + order);
        }
    }

    public static String generateAgenda(ArrayList<Activity> activities) {
        Person cameron = new Person();
        Person jaime = new Person();
        StringBuilder order = new StringBuilder();

        for (Activity activity : activities) {
            if (activity.getStart() >= cameron.getNextAvailability()) cameron.setFree(true);
            if (activity.getStart() >= jaime.getNextAvailability()) jaime.setFree(true);

            if (cameron.isFree()) {
                activity.setPerson("C");
                cameron.setNextAvailability(activity.getEnd());
                cameron.setFree(false);
            } else if (jaime.isFree()) {
                activity.setPerson("J");
                jaime.setNextAvailability(activity.getEnd());
                jaime.setFree(false);
            } else if (!cameron.isFree() && !jaime.isFree()) return null;
        }

        activities.sort((Comparator.comparingInt(Activity::getIndex)));
        for (Activity activity : activities) {
            order.append(activity.getPerson());
        }

        return order.toString();
    }

    private static class Activity {
        private final int start;
        private final int end;
        private final int index;
        private String person;

        private Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.person = "";
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }
    }

    private static class Person {
        private int nextAvailability;
        private boolean free;

        private Person() {
            this.nextAvailability = -1;
            this.free = true;
        }

        public int getNextAvailability() {
            return nextAvailability;
        }

        public void setNextAvailability(int nextAvailability) {
            this.nextAvailability = nextAvailability;
        }

        public boolean isFree() {
            return free;
        }

        public void setFree(boolean free) {
            this.free = free;
        }
    }
}
