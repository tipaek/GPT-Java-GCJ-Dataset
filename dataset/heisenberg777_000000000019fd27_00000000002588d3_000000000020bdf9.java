import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalCases = Integer.parseInt(in.nextLine());
        String[] printables = new String[totalCases];

        for(int ii = 1; ii <= totalCases; ii++) {
            boolean isPossible = true;
            int numberOfActivities = Integer.parseInt(in.nextLine());
            EventsObj[] allActivities = new EventsObj[numberOfActivities];
            for(int i = 0; i < numberOfActivities; i++) {
                String s = in.nextLine();
                allActivities[i] = new EventsObj(i+1, Integer.parseInt(s.split(" ")[0]),
                        Integer.parseInt(s.split(" ")[1]));
            }

            // Sorts activities w.r.t. start time in Ascending Order
            sortActivityList(allActivities);

            ArrayList<EventsObj> cEvents = new ArrayList<>();
            ArrayList<EventsObj> jEvents = new ArrayList<>();

            int ccet = 0, cjet = 0;

            for(int i = 0; i < numberOfActivities; i++) {

                if(allActivities[i].SM >= ccet) {
                    cEvents.add(allActivities[i]);
                    ccet = allActivities[i].EM;
                } else if(allActivities[i].SM >= cjet) {
                    jEvents.add(allActivities[i]);
                    cjet = allActivities[i].EM;
                } else {
                    isPossible = false;
                    break;
                }

            }

            String[] tOrd = new String[numberOfActivities];

            for (EventsObj c_activity : cEvents) {
                tOrd[c_activity.ActivityId - 1] = "C";
            }
            for (EventsObj j_activity : jEvents) {
                tOrd[j_activity.ActivityId - 1] = "J";
            }
            String particularAnswer;
            if(isPossible) {
                particularAnswer = "";
                for(int i = 0; i < tOrd.length; i++) {
                    particularAnswer += tOrd[i];
                }
            } else {
                particularAnswer = "IMPOSSIBLE";
            }
            printables[ii-1] = particularAnswer;
        }

        for(int ii = 1; ii <= totalCases; ii++) {
            System.out.println("Case #" + ii + ": " + printables[ii-1]);
        }
    }

    public static void sortActivityList(EventsObj[] allActivities) {
        Arrays.sort(allActivities);
    }
}

class EventsObj implements Comparable<EventsObj> {
    int ActivityId;
    int SM, EM;

    EventsObj (int ActivityId, int SM, int EM) {
        this.ActivityId = ActivityId;
        this.SM = SM;
        this.EM = EM;
    }

    public int compareTo(EventsObj e2) {
        int returnValue = 0;
        if(e2.SM > this.SM) {
            returnValue = -1;
        } else if(e2.SM < this.SM) {
            returnValue = 1;
        }
        return returnValue;
    }
}