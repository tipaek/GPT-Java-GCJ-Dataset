import java.util.*;

public class Solution {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();
        //start each case
        int counter = 1;
        while ( counter <= numberOfCases) {

            int matrixLength = scan.nextInt();
            scan.nextLine();

            TreeMap<Integer, Integer> camerons = new TreeMap<>();
            TreeMap<Integer, Integer> jamies = new TreeMap<>();

            String names = "";
            for (int i=0; i<matrixLength; i++) {
                String line = scan.nextLine();
                Activity currentActivity = new Solution().getActivity(line);
                boolean cameronAvailable = canActivityBeAssigned(camerons, currentActivity);
                if (cameronAvailable) {
                    camerons.put(currentActivity.startTime, currentActivity.endTime);
                    names+="C";
                } else {
                    boolean jamieAvailable = canActivityBeAssigned(jamies, currentActivity);
                    if (jamieAvailable) {
                        jamies.put(currentActivity.startTime, currentActivity.endTime);
                        names+="J";
                    }
                    if(!cameronAvailable && !jamieAvailable) {
                        names = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.println("Case #"+counter+": "+names);
            counter++;
        }
    }

    public Activity getActivity(String line) {
        String numbers[] = line.split(" ");
        int startTime = Integer.parseInt(numbers[0]);
        int endTime = Integer.parseInt(numbers[1]);
        return new Activity(startTime, endTime);
    }

    public static boolean canActivityBeAssigned (TreeMap<Integer, Integer> treeMap, Activity toSearch) {

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (toSearch.startTime >= entry.getKey() && toSearch.startTime < entry.getValue())
                return false;
            if (toSearch.endTime > entry.getKey() && toSearch.endTime <= entry.getValue())
                return false;
        }
        return true;
    }

    class Activity {
        int startTime;
        int endTime;
        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}

