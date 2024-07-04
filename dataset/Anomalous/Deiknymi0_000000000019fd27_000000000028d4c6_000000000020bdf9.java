import java.io.*;
import java.util.*;

public class Solution {
    private static final int MINUTES_IN_DAY = 24 * 60;
    private static short[] minutes = new short[MINUTES_IN_DAY];

    public static class Activity {
        private int start, end;
        private char assignedTo;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = ' ';
            for (int i = start; i < end; i++) {
                minutes[i]++;
            }
        }

        public boolean isOverlapping() {
            for (int i = start; i < end; i++) {
                if (minutes[i] > 1) {
                    return true;
                }
            }
            return false;
        }

        public void assignTo(char c) {
            this.assignedTo = c;
            for (int i = start; i < end; i++) {
                minutes[i]--;
            }
        }

        public char getAssignedTo() {
            return assignedTo;
        }
    }

    public static class ActivityWrapper {
        private Activity activity;

        public ActivityWrapper(Activity activity) {
            this.activity = activity;
        }

        public boolean isOverlapping() {
            return activity.isOverlapping();
        }

        public void assignTo(char c) {
            activity.assignTo(c);
        }

        public Activity getActivity() {
            return activity;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests = scanner.nextInt();

        for (int testCase = 1; testCase <= tests; testCase++) {
            Arrays.fill(minutes, (short) 0);
            List<Activity> activities = new ArrayList<>();
            List<ActivityWrapper> wrappers = new ArrayList<>();

            int numActivities = scanner.nextInt();
            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activities.add(activity);
                wrappers.add(new ActivityWrapper(activity));
            }

            wrappers.sort(Comparator.comparingInt(o -> o.getActivity().start));

            boolean impossible = false;
            for (int i = 0; i < MINUTES_IN_DAY; i++) {
                if (minutes[i] >= 3) {
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                for (Activity activity : activities) {
                    if (!activity.isOverlapping()) {
                        activity.assignTo('C');
                    }
                }

                char lastAssigned = ' ';
                for (int minute = 0; minute < MINUTES_IN_DAY; ) {
                    boolean overlapFound = false;
                    for (; minute < MINUTES_IN_DAY; minute++) {
                        if (minutes[minute] == 2) {
                            overlapFound = true;
                            break;
                        }
                    }
                    if (overlapFound) {
                        Activity a1 = null, a2 = null;
                        for (ActivityWrapper wrapper : wrappers) {
                            Activity currentActivity = wrapper.getActivity();
                            if (currentActivity.getAssignedTo() == ' ' && minute >= currentActivity.start && minute < currentActivity.end) {
                                if (a1 == null) {
                                    a1 = currentActivity;
                                } else {
                                    a2 = currentActivity;
                                }
                            }
                        }
                        a1.assignTo(lastAssigned == 'C' ? 'J' : 'C');
                        a2.assignTo(a1.getAssignedTo() == 'J' ? 'C' : 'J');
                        lastAssigned = (a1.end >= a2.end) ? a1.getAssignedTo() : a2.getAssignedTo();
                    }
                }

                for (Activity activity : activities) {
                    if (activity.getAssignedTo() == ' ') {
                        activity.assignTo('J');
                    }
                }

                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.getAssignedTo());
                }
                out.println("Case #" + testCase + ": " + result.toString());
            } else {
                out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        out.close();
    }
}