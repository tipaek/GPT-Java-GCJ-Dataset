import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTest = sc.nextInt();
        String[] solutions = new String[noOfTest];

        for (int t = 0; t < noOfTest; t++) {
            int activitiesCount = sc.nextInt();
            ArrayList<Integer>[] activities = new ArrayList[activitiesCount];
            HashMap<ArrayList<Integer>, Integer> indexMap = new HashMap<>();

            for (int i = 0; i < activitiesCount; i++) {
                activities[i] = new ArrayList<>();
                activities[i].add(sc.nextInt());
                activities[i].add(sc.nextInt());
                indexMap.put(activities[i], i);
            }

            solutions[t] = scheduleActivities(activities, indexMap);
        }

        for (int i = 0; i < solutions.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    public static String scheduleActivities(ArrayList<Integer>[] activities, HashMap<ArrayList<Integer>, Integer> indexMap) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.get(0)));

        char[] schedule = new char[indexMap.size()];
        ArrayList<Integer> cameron = null;
        ArrayList<Integer> jamie = null;

        schedule[indexMap.get(activities[0])] = 'C';
        cameron = activities[0];

        for (int i = 1; i < activities.length; i++) {
            if (cameron == null || cameron.get(1) <= activities[i].get(0)) {
                cameron = activities[i];
                schedule[indexMap.get(activities[i])] = 'C';
            } else if (jamie == null || jamie.get(1) <= activities[i].get(0)) {
                jamie = activities[i];
                schedule[indexMap.get(activities[i])] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}