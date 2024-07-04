import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            List<Activity> activities = new ArrayList<>();
            int numberOfAct = sc.nextInt();
            for (int j = 0; j < numberOfAct; j++) {
                int startTime = sc.nextInt();
                LocalDateTime tonight = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
                LocalDateTime startLocalTime = tonight.plusMinutes(startTime);
                int endTime = sc.nextInt();
                LocalDateTime endLocalTime = tonight.plusMinutes(endTime);
                Activity activity = new Activity(startLocalTime, endLocalTime, j);
                activities.add(activity);
            }
            ActivityTimeTable activityTimeTableForThisCase = new ActivityTimeTable(activities);
            System.out.println("Case #" + (i + 1) + ": " + activityTimeTableForThisCase.assignActivity());
        }
    }
}

class ActivityTimeTable {

    final List<Activity> activityList;
    final Person c = new Person('C');
    final Person j = new Person('J');

    public ActivityTimeTable(final List<Activity> activityList) {
        activityList.sort(Comparator.comparing(Activity::getStartTime).thenComparing(Activity::getEndTime));
        this.activityList = activityList;
    }

    String assignActivity() {
        char[] dutyList = new char[activityList.size()];
        Person nextOnDuty;

        for (Activity activity : activityList) {
            nextOnDuty = !c.occupiedUntil.isAfter(j.occupiedUntil) ? c : j;
            if (!nextOnDuty.isAvailable(activity.startTime)) {
                return "IMPOSSIBLE";
            }
            dutyList[activity.order] = nextOnDuty.name;
            nextOnDuty.occupiedUntil = activity.endTime;
        }

        String timetable = new String(dutyList);

        return timetable;
    }
}

class Activity {
    LocalDateTime startTime;
    LocalDateTime endTime;
    final int order;

    public Activity(final LocalDateTime startTime, final LocalDateTime endTime, final int order) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.order = order;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}

class Person {
    char name;
    LocalDateTime occupiedUntil;

    public Person(final char name) {
        this.name = name;
        this.occupiedUntil = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
    }

    boolean isAvailable(LocalDateTime activityStart) {
        return this.occupiedUntil == null || !this.occupiedUntil.isAfter(activityStart);
    }
}
