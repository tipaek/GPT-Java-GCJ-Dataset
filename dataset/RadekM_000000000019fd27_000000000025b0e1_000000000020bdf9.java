import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.String.format;

public class Solution {

    private static final char FIRST_INITIAL = 'C';
    private static final char SECOND_INITIAL = 'J';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = newScanner();
        PrintStream out = System.out;

        int testCases = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= testCases; t++) {
            Input input = readTestCase(in, t);
            Output output = solve(input);
            printOutput(out, output);
        }
    }

    private static Output solve(Input input) {
        int testCase = input.getTestCase();
        int activitiesCount = input.getActivitiesCount();
        Activity[] activities = input.getActivities();

        Arrays.sort(activities, Comparator.comparing(Activity::getStart));

        Optional<Activity> firstPersonActivity = Optional.empty();
        Optional<Activity> secondPersonActivity = Optional.empty();

        char[] order = new char[activitiesCount];

        for (int i = 0; i < activitiesCount; i++) {
            Activity activity = activities[i];
            firstPersonActivity = updateIfFinished(firstPersonActivity, activity.getStart());
            secondPersonActivity = updateIfFinished(secondPersonActivity, activity.getStart());

            if (!firstPersonActivity.isEmpty() && !secondPersonActivity.isEmpty()) {
                return new Output(testCase, IMPOSSIBLE);
            } else if (firstPersonActivity.isEmpty()) {
                order[activity.getActivityNo()] = FIRST_INITIAL;
                firstPersonActivity = Optional.of(activity);
            } else {
                order[activity.getActivityNo()] = SECOND_INITIAL;
                secondPersonActivity = Optional.of(activity);
            }
        }

        return new Output(testCase, String.valueOf(order));
    }

    private static Optional<Activity> updateIfFinished(Optional<Activity> assignedActivity, int start) {
        if (assignedActivity.isEmpty()) {
            return Optional.empty();
        } else if (assignedActivity.get().getEnd() <= start) {
            return Optional.empty();
        } else {
            return assignedActivity;
        }
    }

    private static Scanner newScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static Input readTestCase(Scanner in, int testCase) {
        int activitiesCount = in.nextInt();
        in.nextLine();

        Activity[] activities = new Activity[activitiesCount];
        for (int i = 0; i < activitiesCount; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            in.nextLine();
            Activity activity = new Activity(i, start, end);
            activities[i] = activity;
        }
        return new Input(testCase, activitiesCount, activities);
    }

    private static void printOutput(PrintStream out, Output output) {
        String outputString = format("Case #%s: %s",
                output.getTestCase(),
                output.getOrder());

        out.println(outputString);
    }

    private static class Input {

        private final int testCase;
        private final int activitiesCount;
        private final Activity[] activities;

        private Input(int testCase, int activitiesCount, Activity[] activities) {
            this.testCase = testCase;
            this.activitiesCount = activitiesCount;
            this.activities = activities;
        }

        public int getTestCase() {
            return testCase;
        }

        public int getActivitiesCount() {
            return activitiesCount;
        }

        public Activity[] getActivities() {
            return activities;
        }
    }

    private static class Output {

        private final int testCase;
        private final String order;

        private Output(int testCase, String order) {
            this.testCase = testCase;
            this.order = order;
        }

        public int getTestCase() {
            return testCase;
        }

        public String getOrder() {
            return order;
        }
    }

    private static class Activity {

        private final int activityNo;
        private final int start;
        private final int end;

        private Activity(int activityNo, int start, int end) {
            this.activityNo = activityNo;
            this.start = start;
            this.end = end;
        }

        public int getActivityNo() {
            return activityNo;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
