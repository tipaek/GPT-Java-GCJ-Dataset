import javafx.util.Pair;
import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            int numOfActivities = Integer.parseInt(scanner.nextLine());
            List<Pair<Integer, Integer>> activities = readActivities(scanner, numOfActivities);
            List<Pair<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);
            List<Pair<Integer, Integer>> person1Activities = assignActivities(activitiesCopy);
            List<Pair<Integer, Integer>> remainingActivities = filterActivities(activities, person1Activities);
            
            if (hasOverlap(remainingActivities)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                printSchedule(i + 1, activities, person1Activities, remainingActivities);
            }
        }
    }

    private static void printSchedule(int caseNumber, List<Pair<Integer, Integer>> activities, 
                                      List<Pair<Integer, Integer>> person1Activities, 
                                      List<Pair<Integer, Integer>> person2Activities) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        
        for (Pair<Integer, Integer> activity : activities) {
            if (person1Activities.contains(activity)) {
                result.append("J");
            } else {
                result.append("C");
            }
        }
        
        System.out.println(result.toString());
    }

    private static boolean hasOverlap(List<Pair<Integer, Integer>> activities) {
        for (int i = 0; i < activities.size(); i++) {
            Pair<Integer, Integer> current = activities.get(i);
            for (int j = i + 1; j < activities.size(); j++) {
                Pair<Integer, Integer> next = activities.get(j);
                if (current.getKey() < next.getValue() && current.getValue() > next.getKey()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Pair<Integer, Integer>> filterActivities(List<Pair<Integer, Integer>> activities, 
                                                                 List<Pair<Integer, Integer>> person1Activities) {
        List<Pair<Integer, Integer>> remaining = new ArrayList<>();
        
        for (Pair<Integer, Integer> activity : activities) {
            if (!person1Activities.contains(activity)) {
                remaining.add(activity);
            }
        }
        
        return remaining;
    }

    private static List<Pair<Integer, Integer>> assignActivities(List<Pair<Integer, Integer>> activities) {
        List<Pair<Integer, Integer>> assigned = new ArrayList<>();
        
        while (!activities.isEmpty()) {
            Pair<Integer, Integer> earliest = getEarliestActivity(activities);
            activities.remove(earliest);
            assigned.add(earliest);
            removeConflictingActivities(activities, earliest);
        }
        
        return assigned;
    }

    private static void removeConflictingActivities(List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> chosen) {
        activities.removeIf(activity -> activity.getKey() < chosen.getValue() && activity.getValue() > chosen.getKey());
    }

    private static Pair<Integer, Integer> getEarliestActivity(List<Pair<Integer, Integer>> activities) {
        Pair<Integer, Integer> earliest = activities.get(0);
        int earliestEndTime = earliest.getValue();
        
        for (Pair<Integer, Integer> activity : activities) {
            if (activity.getValue() < earliestEndTime) {
                earliest = activity;
                earliestEndTime = activity.getValue();
            }
        }
        
        return earliest;
    }

    private static List<Pair<Integer, Integer>> readActivities(Scanner scanner, int numOfActivities) {
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        
        for (int i = 0; i < numOfActivities; i++) {
            String[] times = scanner.nextLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            activities.add(new Pair<>(start, end));
        }
        
        return activities;
    }
}