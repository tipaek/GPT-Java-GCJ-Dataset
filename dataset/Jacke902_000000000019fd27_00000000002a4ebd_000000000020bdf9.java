import java.util.*;

public class Solution {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();
        //start each case
        int counter = 1;
        while ( counter <= numberOfCases) {

            int activitiesAmount = scan.nextInt();
            scan.nextLine();

            TreeMap<Integer, Integer> camerons = new TreeMap<>();
            TreeMap<Integer, Integer> jamies = new TreeMap<>();
            String names = "";
            int cameronsAmount=0;
            int jamiesAmount=0;
            for (int i=0; i < activitiesAmount; i++) {
                String numbers[] = scan.nextLine().split(" ");
                int startTime = Integer.parseInt(numbers[0]);
                int endTime = Integer.parseInt(numbers[1]);
                boolean cameronAvailable = false;
                boolean jamieAvailable = false;
                if ( cameronsAmount < jamiesAmount) {
                    cameronAvailable = canActivityBeAssigned(camerons, startTime, endTime);
                    if (cameronAvailable) {
                        camerons.put(startTime, endTime);
                        cameronsAmount++;
                        names+="C";
                    } else {
                        jamieAvailable = canActivityBeAssigned(jamies, startTime, endTime);
                        if (jamieAvailable) {
                            jamies.put(startTime, endTime);
                            jamiesAmount++;
                            names+="J";
                        }
                        if(!cameronAvailable && !jamieAvailable) {
                            names = "IMPOSSIBLE";
                            break;
                        }
                    }
                } else {
                    jamieAvailable = canActivityBeAssigned(jamies, startTime, endTime);
                    if (jamieAvailable) {
                        jamies.put(startTime, endTime);
                        jamiesAmount++;
                        names+="J";
                    }
                    else {
                        cameronAvailable = canActivityBeAssigned(camerons, startTime, endTime);
                        if (cameronAvailable) {
                            camerons.put(startTime, endTime);
                            cameronsAmount++;
                            names+="C";
                        }

                    }
                }
                if(!cameronAvailable && !jamieAvailable) {
                    names = "IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #"+counter+": "+names);
            counter++;
        }
    }

    public static boolean canActivityBeAssigned (TreeMap<Integer, Integer> treeMap, int startTime, int endTime) {
        if (treeMap.isEmpty())
            return true;
        Map.Entry<Integer, Integer> startFloorEntry  = treeMap.floorEntry(startTime);
        if ( startFloorEntry != null) {
            if (startTime >= startFloorEntry.getKey() && startTime < startFloorEntry.getValue())
                return false;
            if (endTime > startFloorEntry.getKey() && endTime <= startFloorEntry.getValue())
                return false;
        }
        Map.Entry<Integer, Integer> startCeilingEntry  = treeMap.ceilingEntry(startTime);
        if (startCeilingEntry != null) {
            if (startTime >= startCeilingEntry.getKey() && startTime < startCeilingEntry.getValue())
                return false;
            if (endTime > startCeilingEntry.getKey() && endTime <= startCeilingEntry.getValue())
                return false;
        }
        return true;
    }
}