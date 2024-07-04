import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(in.nextLine());
        String[] valuesToPrint = new String[numberOfCases];

        for(int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            boolean isPossible = true;
            int numberOfActivities = Integer.parseInt(in.nextLine());
            EventsObj[] allActivities = new EventsObj[numberOfActivities];
            for(int i = 0; i < numberOfActivities; i++) {
                String s = in.nextLine();
                allActivities[i] = new EventsObj(i+1, Integer.parseInt(s.split(" ")[0]),
                        Integer.parseInt(s.split(" ")[1]));
            }

            sortActivityList(allActivities);
            
            ArrayList<EventsObj> C_Activities = new ArrayList<>();
            ArrayList<EventsObj> J_Activities = new ArrayList<>();
            
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

            String[] timingOrder = new String[numberOfActivities];

            for (EventsObj c_activity : C_Activities) {
                timingOrder[c_activity.ActivityId - 1] = "C";
            }
            for (EventsObj j_activity : J_Activities) {
                timingOrder[j_activity.ActivityId - 1] = "J";
            }
            String particularAnswer;
            if(isPossible) {
                particularAnswer = "";
                for(int i = 0; i < timingOrder.length; i++) {
                    particularAnswer += timingOrder[i];
                }
            } else {
                particularAnswer = "IMPOSSIBLE";
            }
            valuesToPrint[caseNumber-1] = particularAnswer;
        }

        for(int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            System.out.println("Case #" + caseNumber + ": " + valuesToPrint[caseNumber-1]);
        }
    }

    public static void sortActivityList(EventsObj[] allActivities) {
        Arrays.sort(allActivities);
    }
}

class EventsObj implements Comparable<EventsObj> {
    int ActivityId;
    int startMinutes, endMinutes;

    EventsObj (int ActivityId, int startMinutes, int endMinutes) {
        this.ActivityId = ActivityId;
        this.startMinutes = startMinutes;
        this.endMinutes = endMinutes;
    }

    @Override
    public int compareTo(@NotNull EventsObj e2) {
        int returnValue = 0;
        if(e2.startMinutes > this.startMinutes) {
            returnValue = -1;
        } else if(e2.startMinutes < this.startMinutes) {
            returnValue = 1;
        }
        return returnValue;
    }
}