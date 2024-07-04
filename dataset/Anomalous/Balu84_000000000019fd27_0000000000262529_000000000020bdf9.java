import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String SEPARATOR = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    
    private static final class ActivityPeriod implements Comparable<ActivityPeriod> {
        public final int start;
        public final int end;
        public final int originalIndex;
        private String assignee;
        
        public ActivityPeriod(String startStr, String endStr, int originalIndex) {
            this.start = Integer.parseInt(startStr.trim());
            this.end = Integer.parseInt(endStr.trim());
            this.originalIndex = originalIndex;
        }
        
        @Override
        public int compareTo(ActivityPeriod other) {
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "ActivityPeriod{" + "originalIndex=" + originalIndex + ", start=" + start + ", end=" + end + '}';
        }
        
        public boolean doesOverlap(ActivityPeriod nextActivity) {
            return nextActivity.start < this.end;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int currentTestCase = 1; currentTestCase <= testCases; currentTestCase++) {
            int activitiesCount = scanner.nextInt();
            scanner.nextLine();
            List<ActivityPeriod> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                String[] activity = scanner.nextLine().split(SEPARATOR);
                activities.add(new ActivityPeriod(activity[0], activity[1], i));
            }

            ActivityPeriod[] solution = new ActivityPeriod[activitiesCount];
            try {
                Collections.sort(activities);
                Map<String, Stack<ActivityPeriod>> assignedActivities = new HashMap<>();
                assignedActivities.put(CAMERON, new Stack<>());
                assignedActivities.put(JAMIE, new Stack<>());

                String lastAssignedTo = CAMERON;
                ActivityPeriod firstActivity = activities.get(0);
                firstActivity.setAssignee(lastAssignedTo);
                assignedActivities.get(lastAssignedTo).push(firstActivity);
                solution[firstActivity.originalIndex] = firstActivity;

                for (int i = 1; i < activities.size(); i++) {
                    ActivityPeriod currentActivity = activities.get(i);
                    ActivityPeriod lastActivity = assignedActivities.get(lastAssignedTo).pop();

                    if (!lastActivity.doesOverlap(currentActivity)) {
                        assignedActivities.get(lastAssignedTo).push(currentActivity);
                        currentActivity.setAssignee(lastAssignedTo);
                        solution[currentActivity.originalIndex] = currentActivity;
                    } else {
                        if (!assignedActivities.get(lastAssignedTo).isEmpty()) {
                            throw new RuntimeException(IMPOSSIBLE);
                        }
                        assignedActivities.get(lastAssignedTo).push(lastActivity);
                        String availableParent = getNextAvailableParent(lastAssignedTo, currentActivity, assignedActivities);

                        if (availableParent == null) {
                            throw new RuntimeException(IMPOSSIBLE);
                        }

                        assignedActivities.get(availableParent).push(currentActivity);
                        lastAssignedTo = availableParent;
                        currentActivity.setAssignee(lastAssignedTo);
                        solution[currentActivity.originalIndex] = currentActivity;
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, e.getMessage()));
                continue;
            }

            StringBuilder result = new StringBuilder();
            for (ActivityPeriod activity : solution) {
                result.append(activity.getAssignee());
            }
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, result.toString()));
        }
    }
    
    private static String getNextAvailableParent(String currentParent, ActivityPeriod nextActivity, Map<String, Stack<ActivityPeriod>> assignedActivities) {
        String nextParent = null;

        for (Map.Entry<String, Stack<ActivityPeriod>> entry : assignedActivities.entrySet()) {
            String parent = entry.getKey();
            Stack<ActivityPeriod> activityStack = entry.getValue();

            if (!activityStack.isEmpty()) {
                ActivityPeriod lastActivity = activityStack.pop();
                if (nextActivity.start < lastActivity.end) {
                    activityStack.push(lastActivity);
                }
            }

            if (nextParent == null && !parent.equals(currentParent) && activityStack.isEmpty()) {
                nextParent = parent;
            }
        }

        return nextParent;
    }
}