import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            char[] assignments = new char[activityCount];
            boolean isPossible = assignActivities(activities, assignments, 0, new ArrayList<>(List.of(new int[]{0, 1440})), new ArrayList<>(List.of(new int[]{0, 1440})));

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(assignments));
            }
        }
        
        scanner.close();
    }

    private static boolean assignActivities(int[][] activities, char[] assignments, int index, List<int[]> freeTimeC, List<int[]> freeTimeJ) {
        if (index == activities.length) return true;

        int start = activities[index][0];
        int end = activities[index][1];

        if (tryAssign(freeTimeC, assignments, index, 'C', start, end, activities, freeTimeJ)) return true;
        if (tryAssign(freeTimeJ, assignments, index, 'J', start, end, activities, freeTimeC)) return true;

        return false;
    }

    private static boolean tryAssign(List<int[]> freeTime, char[] assignments, int index, char assignee, int start, int end, int[][] activities, List<int[]> otherFreeTime) {
        List<int[]> updatedFreeTime = findAndAssignFreeTime(freeTime, start, end);
        if (updatedFreeTime != null) {
            assignments[index] = assignee;
            if (assignActivities(activities, assignments, index + 1, freeTime, otherFreeTime)) return true;
            releaseFreeTime(freeTime, updatedFreeTime);
        }
        return false;
    }

    private static List<int[]> findAndAssignFreeTime(List<int[]> freeTime, int start, int end) {
        List<int[]> updatedFreeTime = new ArrayList<>();
        for (int i = 0; i < freeTime.size(); i++) {
            int[] slot = freeTime.get(i);
            if (start >= slot[0] && end <= slot[1]) {
                updatedFreeTime.add(slot);
                freeTime.remove(i);
                if (end < slot[1]) {
                    int[] newSlot = {end, slot[1]};
                    freeTime.add(i, newSlot);
                    updatedFreeTime.add(newSlot);
                }
                if (start > slot[0]) {
                    int[] newSlot = {slot[0], start};
                    freeTime.add(i, newSlot);
                    updatedFreeTime.add(newSlot);
                }
                return updatedFreeTime;
            }
        }
        return null;
    }

    private static void releaseFreeTime(List<int[]> freeTime, List<int[]> updatedFreeTime) {
        freeTime.add(updatedFreeTime.get(0));
        for (int i = 1; i < updatedFreeTime.size(); i++) {
            freeTime.remove(updatedFreeTime.get(i));
        }
    }
}