import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String[] NAMES = {"*", "C", "J"};
    
    private static Boolean[][] memoization;
    private static int[] owners;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int t = 1; t <= numCases; t++) {
            System.out.print("Case #" + t + ": ");
            List<Activity> activities = readActivities(scanner);
            System.out.println(solve(activities));
        }
        
        scanner.close();
    }
    
    private static List<Activity> readActivities(Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>(numberOfActivities);
        for (int i = 0; i < numberOfActivities; i++) {
            activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
        }
        return activities;
    }

    private static String solve(List<Activity> activities) {
        int numberOfActivities = activities.size();
        memoization = new Boolean[numberOfActivities][numberOfActivities];
        owners = new int[numberOfActivities];
        Actor[] actors = {new Actor(1, "C"), new Actor(2, "J")};
        
        int actorIndex = 0;
        int assignedCount = 0;
        boolean previouslySkipped = true;

        try {
            while (assignedCount < numberOfActivities) {
                Actor currentActor = actors[actorIndex];
                Activity freeActivity = findFreeActivity(currentActor, activities);
                if (freeActivity == null) {
                    if (previouslySkipped) {
                        break;
                    }
                    previouslySkipped = true;
                    actorIndex = 1 - actorIndex;
                    continue;
                }
                previouslySkipped = false;
                currentActor.assign(freeActivity);
                owners[freeActivity.id] = currentActor.id;
                assignedCount++;

                List<Activity> conflictingActivities = findConflictingActivities(currentActor, activities);
                if (!conflictingActivities.isEmpty()) {
                    Actor otherActor = actors[1 - actorIndex];
                    for (Activity conflictingActivity : conflictingActivities) {
                        otherActor.assign(conflictingActivity);
                        owners[conflictingActivity.id] = otherActor.id;
                        assignedCount++;
                    }
                    actorIndex = 1 - actorIndex;
                }
            }
        } catch (Exception e) {
            return IMPOSSIBLE;
        }

        if (assignedCount < numberOfActivities) {
            return IMPOSSIBLE;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfActivities; i++) {
            result.append(NAMES[owners[i]]);
        }
        
        return result.toString();
    }

    private static List<Activity> findConflictingActivities(Actor actor, List<Activity> activities) {
        List<Activity> conflictingActivities = new LinkedList<>();
        for (Activity activity : activities) {
            if (owners[activity.id] > 0) {
                continue;
            }
            if (isConflicting(activity, actor.assignedActivities)) {
                conflictingActivities.add(activity);
            }
        }
        return conflictingActivities;
    }

    private static Activity findFreeActivity(Actor actor, List<Activity> activities) {
        for (Activity activity : activities) {
            if (owners[activity.id] > 0) {
                continue;
            }
            if (isConflicting(activity, actor.assignedActivities)) {
                continue;
            }
            return activity;
        }
        return null;
    }
    
    private static boolean isConflicting(Activity activity1, Activity activity2) {
        int id1 = activity1.id;
        int id2 = activity2.id;
        if (id1 > id2) {
            id1 = activity2.id;
            id2 = activity1.id;
        }
        
        Boolean result = memoization[id1][id2];
        if (result != null) {
            return result;
        }
        int overlapStart = Math.max(activity1.start, activity2.start);
        int overlapEnd = Math.min(activity1.end, activity2.end);
        result = overlapEnd > overlapStart;
        memoization[id1][id2] = result;
        return result;
    }

    private static boolean isConflicting(Activity activity, List<Activity> otherActivities) {
        for (Activity otherActivity : otherActivities) {
            if (isConflicting(activity, otherActivity)) {
                return true;
            }
        }
        return false;
    }
    
    private static class Actor {
        int id;
        String name;
        List<Activity> assignedActivities = new LinkedList<>();

        public Actor(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        void assign(Activity activity) {
            if (isConflicting(activity, assignedActivities)) {
                throw new IllegalArgumentException();
            }
            assignedActivities.add(activity);
        }
    }

    private static class Activity {
        int id;
        int start;
        int end;
        int duration;
        
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.duration = end - start;
        }

        public Activity(int start, int end, int id) {
            this(start, end);
            this.id = id;
        }

        @Override
        public String toString() {
            return "{ " + id + " | " + start + " : " + end + " }";
        }
    }
}