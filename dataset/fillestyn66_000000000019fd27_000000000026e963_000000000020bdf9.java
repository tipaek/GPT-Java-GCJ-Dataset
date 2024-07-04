import java.util.*;
import java.io.*;

public class Solution {

    private static Activity[] activityStartArray = new Activity[1441];
    private static Map<Activity, Object> markedItemsMap = new HashMap<>(100);

    private static class Activity implements Comparable<Activity> {
        public Integer start;
        public Integer stop;

        @Override
        public int compareTo(Activity o) {
            return start.compareTo(o.start);
        }

        @Override
        public String toString() {
            return " " + start + " " + stop;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Activity)) return false;
            Activity activity = (Activity) o;
            return start.equals(activity.start) &&
                    stop.equals(activity.stop);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, stop);
        }
    }

    private static class Person {
        public String initial;
        public Activity activity;

        public boolean canTakeActivity(Activity a) {
            return activity.stop <= a.start;
        }

        @Override
        public String toString() {
            return initial;
        }
    }



    private static String processResult(List<Activity> activityList) {
        final StringBuilder resultString = new StringBuilder(100);
        activityList.sort(Activity::compareTo);

        Activity dummyActivity = new Activity();
        dummyActivity.start = 0;
        dummyActivity.stop = 0;


        final Person C = new Person();
        C.initial = "C";
        final Person J = new Person();
        J.initial = "J";
        J.activity = dummyActivity;


        Object dummy = new Object();
        ListIterator<Activity> activityListIterator = activityList.listIterator();

        Activity currentActivity = activityListIterator.next();
        C.activity = currentActivity;
        resultString.append(C.toString());
        markedItemsMap.put(currentActivity, dummy);

        Person currentPerson = C;
        Person nextPerson = J;

        while(activityListIterator.hasNext()){
            if (activityStartArray[currentPerson.activity.stop] != null) {
                currentPerson.activity = activityStartArray[currentPerson.activity.stop];
                resultString.append(currentPerson.toString());
                markedItemsMap.put(currentPerson.activity, dummy);
            } else {
                Activity a = activityListIterator.next();
                if(markedItemsMap.get(a) == null){
                    if (currentPerson.canTakeActivity(a)) {
                        currentPerson.activity = a;
                        resultString.append(currentPerson.toString());
                    } else if (nextPerson.canTakeActivity(a)) {
                        nextPerson.activity = a;
                        resultString.append(nextPerson.toString());
                        Person temp = currentPerson;
                        currentPerson = nextPerson;
                        nextPerson = temp;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }


        return resultString.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int activities = in.nextInt();
            List<Activity> activityList = new ArrayList<>(100);
            for (int y = 1; y <= activities; y++) {
                Activity activity = new Activity();
                activity.start = in.nextInt();
                activity.stop = in.nextInt();
                activityList.add(activity);
                activityStartArray[activity.start] = activity;
            }
            System.out.println("Case #" + i + ": " + processResult(activityList));
        }
    }
}