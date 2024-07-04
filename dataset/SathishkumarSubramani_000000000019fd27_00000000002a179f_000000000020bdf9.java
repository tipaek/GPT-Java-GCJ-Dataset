

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            final int activityCount = scanner.nextInt();

            List<Activity> activities = new ArrayList<>();
            List<Activity> unOrderedActivities = new ArrayList<>();
            IntStream.range(0, activityCount).forEach((index) -> {
                final int start = scanner.nextInt();
                final int end = scanner.nextInt();
                Activity e = new Activity(start, end);
                activities.add(e);
                unOrderedActivities.add(e);
            });
            activities.sort((a, b) -> a.startTime - b.startTime);

            Queue<Character> availableResources = new LinkedList<>();
            availableResources.add('C');
            availableResources.add('J');

            List<Activity> scheduledActivities = new ArrayList<>();

            StringBuffer schedule = new StringBuffer();

            for (Activity activity : activities) {
                for (int index = 0; index < scheduledActivities.size(); index++) {
                    Activity scheduledActivity = scheduledActivities.get(index);
                    if (!activity.overlapsWith(scheduledActivity)) {
                        availableResources.add(scheduledActivity.assignedTo);
                        scheduledActivities.remove(index);
                        index--;
                    }
                }

                if (availableResources.isEmpty()) {
                    schedule = new StringBuffer("IMPOSSIBLE");
                    break;
                }

                Character availableResource = availableResources.remove();

                activity.assign(availableResource);
                scheduledActivities.add(activity);
                schedule.append(availableResource);
            }

            if (!schedule.toString().equals("IMPOSSIBLE")) {
                schedule = new StringBuffer(unOrderedActivities.stream().map(x -> String.valueOf(x.assignedTo)).collect(Collectors.joining()));
            }

            System.out.println(String.format("Case #%d: %s", i, schedule));
        }
        scanner.close();
    }
}

class Activity {
    Integer startTime;
    Integer endTime;
    Character assignedTo;

    private Activity() {
    }

    public Activity(final Integer startTime, final Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("{ startTime: %d, endTime: %d}", startTime, endTime);
    }

    public void assign(Character c) {
        assignedTo = c;
    }

    public boolean overlapsWith(Activity that) {
        return this.startTime <= that.startTime ? (this.endTime - that.startTime) > 0 : ( that.endTime - this.startTime) > 0;
    }
}
