import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            boolean isPossible = true;
            Map<Integer, int[]> activities = new HashMap<>();

            char[] schedule = new char[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.put(i, new int[]{start, end});
            }

            Comparator<Integer> comparator = (a, b) -> Integer.compare(activities.get(a)[0], activities.get(b)[0]);
            TreeMap<Integer, int[]> sortedActivities = new TreeMap<>(comparator);
            TreeMap<Integer, int[]> secondarySortedActivities = new TreeMap<>(comparator);

            sortedActivities.putAll(activities);

            int round = 0;
            int[] currentC = new int[2];
            int[] currentJ = new int[2];

            for (Integer key : sortedActivities.keySet()) {
                int[] interval = activities.get(key);
                if (round == 0) {
                    currentC = interval;
                    schedule[key] = 'C';
                    round++;
                } else {
                    if (interval[0] < currentC[1]) {
                        secondarySortedActivities.put(key, interval);
                    } else {
                        currentC = interval;
                        schedule[key] = 'C';
                    }
                }
            }

            for (Integer key : secondarySortedActivities.keySet()) {
                int[] interval = activities.get(key);
                if (round == 1) {
                    currentJ = interval;
                    schedule[key] = 'J';
                    round++;
                } else {
                    if (interval[0] < currentJ[1]) {
                        isPossible = false;
                        break;
                    } else {
                        currentJ = interval;
                        schedule[key] = 'J';
                    }
                }
            }

            String result = new String(schedule);
            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}

class ValueComparator implements Comparator<Integer> {
    Map<Integer, int[]> base;

    public ValueComparator(Map<Integer, int[]> base) {
        this.base = base;
    }

    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(base.get(a)[0], base.get(b)[0]);
    }
}