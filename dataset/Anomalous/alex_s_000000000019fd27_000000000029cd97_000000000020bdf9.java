import java.util.*;

public class Solution {

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String[] NAMES = {"*", "C", "J"};
    
    static Boolean[][] memo;
    static int[] owners;
    
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
    
    static List<Activity> readActivities(Scanner scanner) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>(numActivities);
        for (int i = 0; i < numActivities; i++) {
            activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
        }
        return activities;
    }

    static String solve(List<Activity> activities) {
        int numActivities = activities.size();
        memo = new Boolean[numActivities][numActivities];
        owners = new int[numActivities];
        Actor[] actors = {new Actor(1, "C"), new Actor(2, "J")};

        activities.sort(Comparator.comparingInt(a -> -a.duration));
        
        int assignedCount = 0;

        try {
            while (assignedCount < numActivities) {
                Activity freeActivity = findFreeActivity(activities);
                if (freeActivity == null) break;

                int actorIndex = findAssignableActor(actors, freeActivity, activities);
                if (actorIndex < 0) break;

                Actor currentActor = actors[actorIndex];
                currentActor.assign(freeActivity);
                owners[freeActivity.id] = currentActor.id;
                assignedCount++;

                List<Activity> conflictingActivities = findConflictingActivities(freeActivity, activities);
                if (!conflictingActivities.isEmpty()) {
                    Actor otherActor = actors[1 - actorIndex];
                    for (Activity conflictingActivity : conflictingActivities) {
                        otherActor.assign(conflictingActivity);
                        owners[conflictingActivity.id] = otherActor.id;
                        assignedCount++;
                    }
                }
            }
        } catch (Exception e) {
            return IMPOSSIBLE;
        }

        if (assignedCount < numActivities) {
            return IMPOSSIBLE;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numActivities; i++) {
            result.append(NAMES[owners[i]]);
        }
        
        return result.toString();
    }

    static List<Activity> findConflictingActivities(Activity activity, List<Activity> activities) {
        List<Activity> conflictingActivities = new LinkedList<>();
        for (Activity a : activities) {
            if (a.id != activity.id && owners[a.id] == 0 && checkConflict(a, activity)) {
                conflictingActivities.add(a);
            }
        }
        return conflictingActivities;
    }

    static int findAssignableActor(Actor[] actors, Activity activity, List<Activity> activities) {
        for (int i = 0; i < actors.length; i++) {
            Actor actor = actors[i];
            if (!checkConflict(activity, actor.assignedActivities)) {
                List<Activity> conflictingActivities = findConflictingActivities(activity, activities);
                Actor otherActor = actors[1 - i];
                if (!checkConflict(conflictingActivities, otherActor.assignedActivities)) {
                    return i;
                }
            }
        }
        return -1;
    }

    static Activity findFreeActivity(List<Activity> activities) {
        for (Activity activity : activities) {
            if (owners[activity.id] == 0) {
                return activity;
            }
        }
        return null;
    }
    
    static boolean checkConflict(Activity a, Activity b) {
        int id1 = Math.min(a.id, b.id);
        int id2 = Math.max(a.id, b.id);
        
        if (memo[id1][id2] != null) {
            return memo[id1][id2];
        }
        
        boolean conflict = Math.max(a.start, b.start) < Math.min(a.end, b.end);
        memo[id1][id2] = conflict;
        return conflict;
    }

    static boolean checkConflict(Activity activity, List<Activity> activities) {
        for (Activity a : activities) {
            if (checkConflict(activity, a)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkConflict(List<Activity> activities1, List<Activity> activities2) {
        for (Activity a1 : activities1) {
            for (Activity a2 : activities2) {
                if (checkConflict(a1, a2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static class Actor {
        int id;
        String name;
        List<Activity> assignedActivities;

        Actor(int id, String name) {
            this.id = id;
            this.name = name;
            this.assignedActivities = new LinkedList<>();
        }
        
        void assign(Activity activity) {
            if (checkConflict(activity, assignedActivities)) {
                throw new IllegalArgumentException();
            }
            assignedActivities.add(activity);
        }
    }

    static class Activity {
        int id;
        int start;
        int end;
        int duration;

        Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
            this.duration = end - start;
        }

        @Override
        public String toString() {
            return "{ " + id + " | " + start + " : " + end + " }";
        }
    }
}