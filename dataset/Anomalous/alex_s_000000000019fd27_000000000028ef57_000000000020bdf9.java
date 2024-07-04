import java.util.*;

public class Solution {

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String[] NAMES = {"*", "C", "J"};
    
    static Boolean[][] mem;
    static int[] owners;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for (int t = 1; t <= numCases; t++) {
            System.out.print("Case #" + t + ": ");
            List<Activity> activities = readActivities(input);
            System.out.println(assignActivities(activities));
        }
        
        input.close();
    }
    
    static List<Activity> readActivities(Scanner input) {
        int n = input.nextInt();
        List<Activity> activities = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(input.nextInt(), input.nextInt(), i));
        }
        return activities;
    }

    static String assignActivities(List<Activity> activities) {
        int n = activities.size();
        mem = new Boolean[n][n];
        owners = new int[n];
        Actor[] actors = {new Actor(1, "C"), new Actor(2, "J")};
        
        activities.sort(Comparator.comparingInt(o -> -o.duration));
        
        int actorIndex = 0;
        int count = 0;
        boolean previousSkipped = true;
        
        try {
            while (count < n) {
                Actor currentActor = actors[actorIndex];
                Activity freeActivity = findFreeActivity(currentActor, activities);
                
                if (freeActivity == null) {
                    if (previousSkipped) {
                        break;
                    }
                    previousSkipped = true;
                    actorIndex = 1 - actorIndex;
                    continue;
                }
                
                previousSkipped = false;
                currentActor.assign(freeActivity);
                owners[freeActivity.id] = currentActor.id;
                count++;

                List<Activity> conflictingActivities = findConflictingActivities(currentActor, activities);
                if (!conflictingActivities.isEmpty()) {
                    Actor otherActor = actors[1 - actorIndex];
                    for (Activity activity : conflictingActivities) {
                        otherActor.assign(activity);
                        owners[activity.id] = otherActor.id;
                        count++;
                    }
                }

                actorIndex = 1 - actorIndex;
            }
        } catch (Exception e) {
            return IMPOSSIBLE;
        }
        
        if (count < n) {
            return IMPOSSIBLE;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(NAMES[owners[i]]);
        }
        return result.toString();
    }

    static List<Activity> findConflictingActivities(Actor actor, List<Activity> activities) {
        List<Activity> conflictingActivities = new LinkedList<>();
        for (Activity activity : activities) {
            if (owners[activity.id] > 0) continue;
            if (isConflicting(activity, actor.assignedActivities)) {
                conflictingActivities.add(activity);
            }
        }
        return conflictingActivities;
    }

    static Activity findFreeActivity(Actor actor, List<Activity> activities) {
        for (Activity activity : activities) {
            if (owners[activity.id] > 0) continue;
            if (!isConflicting(activity, actor.assignedActivities)) {
                return activity;
            }
        }
        return null;
    }
    
    static boolean isConflicting(Activity activity, List<Activity> assignedActivities) {
        for (Activity assignedActivity : assignedActivities) {
            if (isConflicting(activity, assignedActivity)) {
                return true;
            }
        }
        return false;
    }

    static boolean isConflicting(Activity a, Activity b) {
        int id1 = Math.min(a.id, b.id);
        int id2 = Math.max(a.id, b.id);
        
        if (mem[id1][id2] != null) {
            return mem[id1][id2];
        }
        
        boolean conflict = Math.min(a.end, b.end) > Math.max(a.start, b.start);
        mem[id1][id2] = conflict;
        return conflict;
    }
    
    static class Actor {
        int id;
        String name;
        List<Activity> assignedActivities = new LinkedList<>();
        
        Actor(int id, String name) {
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