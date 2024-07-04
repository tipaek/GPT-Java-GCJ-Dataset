import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            activities.sort(Comparator.comparingInt(Activity::getStart)
                                      .thenComparingInt(Activity::getEnd));
            
            String result = scheduleActivities(activities);
            System.out.println("Case #" + caseNum + ": " + (result != null ? result : "IMPOSSIBLE"));
        }
    }

    private static String scheduleActivities(ArrayList<Activity> activities) {
        Person cameron = new Person();
        Person jaime = new Person();
        StringBuilder schedule = new StringBuilder();

        for (Activity activity : activities) {
            if (activity.getStart() >= cameron.getNextAvailable()) cameron.setAvailable(true);
            if (activity.getStart() >= jaime.getNextAvailable()) jaime.setAvailable(true);

            if (cameron.isAvailable()) {
                assignActivity(activity, cameron, "C");
            } else if (jaime.isAvailable()) {
                assignActivity(activity, jaime, "J");
            } else {
                return null;
            }
        }

        activities.sort(Comparator.comparingInt(Activity::getIndex));
        for (Activity activity : activities) {
            schedule.append(activity.getPerson());
        }

        return schedule.toString();
    }

    private static void assignActivity(Activity activity, Person person, String personLabel) {
        activity.setPerson(personLabel);
        person.setNextAvailable(activity.getEnd());
        person.setAvailable(false);
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
        private int nextAvailable;
        private boolean available;

        private Person() {
            this.nextAvailable = 0;
            this.available = true;
        }

        public int getNextAvailable() {
            return nextAvailable;
        }

        public void setNextAvailable(int nextAvailable) {
            this.nextAvailable = nextAvailable;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }
}