import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        List<Schedule> schedules = new ArrayList<>();

        for (int i = 0; i < numOfTestCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numOfActivities; j++) {
                String input = scanner.nextLine();
                String[] numbers = input.split(" ");
                activities.add(new Activity(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));
            }
            Schedule schedule = new Schedule(activities);
            schedules.add(schedule);
        }

        for (int i = 0; i < numOfTestCases; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, schedules.get(i).assignOwners());
        }

    }

    private static class Activity {
        int start;
        int end;
        char assignedTo;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        char getAssignedTo() {
            return assignedTo;
        }

        void setAssignedTo(char assignedTo) {
            this.assignedTo = assignedTo;
        }
    }

    private static class Schedule {
        static char CAMERON = 'C';
        static char JENNY = 'J';

        List<Activity> activities;

        Schedule(List<Activity> activities) {
            this.activities = activities;
        }

        String assignOwners() {
            List<Activity> sortedActivities = this.activities.stream().sorted(Comparator.comparing(Activity::getStart))
                    .collect(Collectors.toList());
            Map<Character, Optional<Integer>> usersLastEndTime = new HashMap<>();
            usersLastEndTime.put(CAMERON, Optional.empty());
            usersLastEndTime.put(JENNY, Optional.empty());

            // assign first activity to Cameron
            Activity activity1 = sortedActivities.get(0);
            activity1.setAssignedTo(CAMERON);
            usersLastEndTime.put(CAMERON, Optional.of(activity1.getEnd()));

            for (int i = 1; i < sortedActivities.size(); i++) {
                Activity currentActivity = sortedActivities.get(i);

                Optional<Character> user = usersLastEndTime.entrySet().stream()
                        .filter(u -> (!u.getValue().isPresent() || u.getValue().get() <= currentActivity.getStart()))
                        .map(u -> u.getKey())
                        .findAny();

                if (user.isPresent()) {
                    currentActivity.setAssignedTo(user.get());
                    usersLastEndTime.put(user.get(), Optional.of(currentActivity.getEnd()));
                } else {
                    return "IMPOSSIBLE";
                }
            }
            StringBuilder builder = new StringBuilder();
            activities.stream().map(Activity::getAssignedTo).forEach(a -> builder.append(a));
            return builder.toString();
        }
    }
}