import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numberOfCases];

        for(int caseId = 1; caseId <= numberOfCases; caseId++) {
            boolean isPossible = true;
            int numberOfActivities = Integer.parseInt(in.nextLine());
            ActivityObject[] allActivities = new ActivityObject[numberOfActivities];
            for(int i = 0; i < numberOfActivities; i++) {
                String s = in.nextLine();
                allActivities[i] = new ActivityObject(i+1, Integer.parseInt(s.split(" ")[0]),
                        Integer.parseInt(s.split(" ")[1]));
            }

            // Sorts activities w.r.t. start time in Ascending Order
            sortActivityList(allActivities);
            
            ArrayList<ActivityObject> C_Activities = new ArrayList<>();
            ArrayList<ActivityObject> J_Activities = new ArrayList<>();
            
            int current_C_EndTime = 0, current_J_EndTime = 0;
            
            for(int i = 0; i < numberOfActivities; i++) {
                
                if(allActivities[i].startMinutes >= current_C_EndTime) {
                    C_Activities.add(allActivities[i]);
                    current_C_EndTime = allActivities[i].endMinutes;
                } else if(allActivities[i].startMinutes >= current_J_EndTime) {
                    J_Activities.add(allActivities[i]);
                    current_J_EndTime = allActivities[i].endMinutes;
                } else {
                    isPossible = false;
                    break;
                }
                
            }

            String[] executionOrder = new String[numberOfActivities];

            for (ActivityObject c_activity : C_Activities) {
                executionOrder[c_activity.ActivityId - 1] = "C";
            }
            for (ActivityObject j_activity : J_Activities) {
                executionOrder[j_activity.ActivityId - 1] = "J";
            }
            String result;
            if(isPossible) {
                result = "";
                for(int i = 0; i < executionOrder.length; i++) {
                    result += executionOrder[i];
                }
            } else {
                result = "IMPOSSIBLE";
            }
            results[caseId-1] = result;
        }

        for(int caseId = 1; caseId <= numberOfCases; caseId++) {
            System.out.println("Case #" + caseId + ": " + results[caseId-1]);
        }
    }

    public static void sortActivityList(ActivityObject[] allActivities) {
        Arrays.sort(allActivities);
    }
}

class ActivityObject implements Comparable<ActivityObject> {
    int ActivityId;
    int startMinutes, endMinutes;

    ActivityObject (int ActivityId, int startMinutes, int endMinutes) {
        this.ActivityId = ActivityId;
        this.startMinutes = startMinutes;
        this.endMinutes = endMinutes;
    }

    public int compareTo(ActivityObject e2) {
        int returnValue = 0;
        if(e2.startMinutes > this.startMinutes) {
            returnValue = -1;
        } else if(e2.startMinutes < this.startMinutes) {
            returnValue = 1;
        }
        return returnValue;
    }
}