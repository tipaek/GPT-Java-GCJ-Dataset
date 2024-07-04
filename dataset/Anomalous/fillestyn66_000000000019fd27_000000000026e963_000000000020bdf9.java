import java.util.*;
import java.io.*;

public class Solution {

    private static final Activity[] activityStartArray = new Activity[1441];
    private static final Map<Activity, Object> markedItemsMap = new HashMap<>(100);

    private static class Activity implements Comparable<Activity> {
        public Integer start;
        public Integer stop;

        @Override
        public int compareTo(Activity other) {
            return this.start.compareTo(other.start);
        }

        @Override
        public String toString() {
            return " " + start + " " + stop;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Activity)) return false;
            Activity other = (Activity) obj;
            return Objects.equals(this.start, other.start) &&
                   Objects.equals(this.stop, other.stop);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, stop);
        }
    }

    private static class Person {
        public String initial;
        public Activity activity;

        public boolean canTakeActivity(Activity activity) {
            return this.activity.stop <= activity.start;
        }

        @Override
        public String toString() {
            return initial;
        }
    }

    private static String processResult(List<Activity> activities) {
        StringBuilder result = new StringBuilder(100);
        activities.sort(Activity::compareTo);

        Activity dummyActivity = new Activity();
        dummyActivity.start = 0;
        dummyActivity.stop = 0;

        Person C = new Person();
        C.initial = "C";
        Person J = new Person();
        J.initial = "J";
        J.activity = dummyActivity;

        Object dummy = new Object();
        ListIterator<Activity> iterator = activities.listIterator();

        Activity currentActivity = iterator.next();
        C.activity = currentActivity;
        result.append(C);
        markedItemsMap.put(currentActivity, dummy);

        Person currentPerson = C;
        Person nextPerson = J;

        while (iterator.hasNext()) {
            if (activityStartArray[currentPerson.activity.stop] != null) {
                currentPerson.activity = activityStartArray[currentPerson.activity.stop];
                result.append(currentPerson);
                markedItemsMap.put(currentPerson.activity, dummy);
            } else {
                Activity nextActivity = iterator.next();
                if (!markedItemsMap.containsKey(nextActivity)) {
                    if (currentPerson.canTakeActivity(nextActivity)) {
                        currentPerson.activity = nextActivity;
                        result.append(currentPerson);
                    } else if (nextPerson.canTakeActivity(nextActivity)) {
                        nextPerson.activity = nextActivity;
                        result.append(nextPerson);
                        Person temp = currentPerson;
                        currentPerson = nextPerson;
                        nextPerson = temp;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(100);
            for (int j = 1; j <= numberOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.stop = scanner.nextInt();
                activities.add(activity);
                activityStartArray[activity.start] = activity;
            }
            System.out.println("Case #" + i + ": " + processResult(activities));
        }
    }
}