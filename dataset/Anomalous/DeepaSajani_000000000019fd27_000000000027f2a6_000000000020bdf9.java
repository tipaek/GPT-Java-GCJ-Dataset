import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final StringBuilder IMPOSSIBLE = new StringBuilder("IMPOSSIBLE");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (end < start) {
                    isImpossible = true;
                }
                activities.add(new int[]{start, end});
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + IMPOSSIBLE);
                continue;
            }

            StringBuilder result = findSchedule(0, activities, new ArrayList<>(), new ArrayList<>());
            System.out.println("Case #" + caseNumber + ": " + (result == IMPOSSIBLE ? IMPOSSIBLE : result.reverse()));
        }
    }

    private static StringBuilder findSchedule(int index, List<int[]> activities, List<int[]> jobC, List<int[]> jobJ) {
        if (index >= activities.size()) return new StringBuilder();

        int[] activity = activities.get(index);
        boolean cFree = isFree(activity, jobC);
        boolean jFree = isFree(activity, jobJ);

        if (!cFree && !jFree) return IMPOSSIBLE;

        if (cFree) {
            List<int[]> jobCClone = new ArrayList<>(jobC);
            jobCClone.add(activity);
            StringBuilder cSchedule = findSchedule(index + 1, activities, jobCClone, jobJ);
            if (cSchedule != IMPOSSIBLE) {
                return cSchedule.append("C");
            }
        }

        if (jFree) {
            List<int[]> jobJClone = new ArrayList<>(jobJ);
            jobJClone.add(activity);
            StringBuilder jSchedule = findSchedule(index + 1, activities, jobC, jobJClone);
            if (jSchedule != IMPOSSIBLE) {
                return jSchedule.append("J");
            }
        }

        return IMPOSSIBLE;
    }

    private static boolean isFree(int[] current, List<int[]> assigned) {
        for (int[] entry : assigned) {
            if (!(current[0] >= entry[1] || current[1] <= entry[0])) {
                return false;
            }
        }
        return true;
    }
}