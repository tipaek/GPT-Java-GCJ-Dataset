import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s"; //Use with String.format - 1.: number of the test case, 2.:the string concatenation of the solution
    private static final String SEPARATOR = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    
    private static final class ActivityPeriod implements Comparable<ActivityPeriod> {
        public final int START;
        public final int END;
        public ActivityPeriod(String startStr, String endStr) {
            START = Integer.parseInt(startStr.trim());
            END = Integer.parseInt(endStr.trim());
        }
        @Override
        public int compareTo(ActivityPeriod t) {
            return this.START - t.START;
        }
        @Override
        public String toString() {
            return "ActivityPeriod{" + "START=" + START + ", END=" + END + '}';
        }
        /**
         * Helper method to figure out if 2 activities overlap.
         * 
         * @param nextActivity
         * @return 
         */
        public boolean doesOverlap(ActivityPeriod nextActivity) {
            return nextActivity.START < this.END;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt(); //number of test cases
        in.nextLine();
        for (int currentTestCase = 1; currentTestCase <= T; currentTestCase++) {
            final int N = in.nextInt(); //number of activities
            in.nextLine();
            List<ActivityPeriod> allActivities = new ArrayList();
            for(int activityIndex=0; activityIndex<N; activityIndex++) {
                String activityStr = in.nextLine();
                String[] activity = activityStr.split(SEPARATOR);
                allActivities.add(new ActivityPeriod(activity[0], activity[1]));
            }
            //start solution
            //System.out.println(Arrays.toString(allActivities.toArray()));
            Collections.sort(allActivities); //sort using start time in case it would not be sorted
            //System.out.println(Arrays.toString(allActivities.toArray()));
            StringBuilder solution = new StringBuilder();
            Map<String, Stack<ActivityPeriod>> activitiesAssigned = new HashMap();
            //init the hashmap with the available parents and an empty activities stack
            activitiesAssigned.put(CAMERON, new Stack());
            activitiesAssigned.put(JAMIE, new Stack());
            //ActivityPeriod lastAssignedActivity = allActivities.get(0);
            String lastAssignedTo = CAMERON;
            activitiesAssigned.get(lastAssignedTo).push(allActivities.get(0));
            solution.append(lastAssignedTo);
            for(int i=1; i<allActivities.size(); i++) {
                ActivityPeriod activity = allActivities.get(i);
                ActivityPeriod lastAssignedActivity = activitiesAssigned.get(lastAssignedTo).pop();
                if(!lastAssignedActivity.doesOverlap(activity)) {
                    //if it does not overlap, then this last assigned activity was finished, the last assignee can get the current task
                    activitiesAssigned.get(lastAssignedTo).push(activity);
                    solution.append(lastAssignedTo);
                }
                else {
                    //we need to push back the last assigned activity, because it overlaps, it was not done yet
                    if(!activitiesAssigned.get(lastAssignedTo).isEmpty()) {
                        //but if this parent already is in the middle of an activity, it is impossible
                        solution = new StringBuilder(IMPOSSIBLE);
                        break;
                    }
                    activitiesAssigned.get(lastAssignedTo).push(lastAssignedActivity);
                    String availableParent = getNextAvailableParentAndRemoveFinishedTasks(lastAssignedTo, activity, activitiesAssigned);
                    if(availableParent == null) {
                        //no available parent left
                        solution = new StringBuilder(IMPOSSIBLE);
                        break;
                    }
                    activitiesAssigned.get(availableParent).push(activity);
                    lastAssignedTo = availableParent;
                    solution.append(lastAssignedTo);
                }
            }
            //end of solution
            System.out.println(String.format(OUTPUT_FORMAT, currentTestCase, solution.toString()));
        } //end of test cases
    }
    
    /**
     * Helper method to remove all finished tasks and to get back the next available parent from all of the activities assigned to a parent or null if there is none left. 
     * 
     * @param currentlyActiveParent the string key of the currently active parent, which we cant return
     * @parem activityToDoNext the next activity for which we are looking for a parent
     * @param activitiesAssigned all of the assigned tasks to all of the parents
     * @return the next available parent or null if there in none left
     */
    private static String getNextAvailableParentAndRemoveFinishedTasks(String currentlyActiveParent, ActivityPeriod activityToDoNext, Map<String, Stack<ActivityPeriod>> activitiesAssigned) {
        //return currentlyActiveParent.equals(CAMERON) ? JAMIE : CAMERON;
        String nextAvailableParent = null;
        for(Map.Entry<String, Stack<ActivityPeriod>> parentActivity : activitiesAssigned.entrySet()) {
            String parentStr = parentActivity.getKey();
            Stack<ActivityPeriod> activityStack = parentActivity.getValue();
            //we remove every activity which has been done until this current task
            if(!activityStack.isEmpty()) {
                ActivityPeriod parentsLastActivity = activityStack.pop();
                if(activityToDoNext.START < parentsLastActivity.END) {
                    //this task for this parent is not done yet, we need to push it back into the stack
                    activityStack.push(parentsLastActivity);
                }
            }
            if(nextAvailableParent == null && !parentStr.equals(currentlyActiveParent) && activityStack.isEmpty()) {
                nextAvailableParent = parentStr;
            }
        }
        return nextAvailableParent;
    }
}