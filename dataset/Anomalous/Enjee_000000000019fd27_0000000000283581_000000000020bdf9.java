import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            if (isImpossible(activities)) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                char[] assignments = new char[activityCount];
                Arrays.fill(assignments, '0');
                
                List<int[]> freeTimeC = new ArrayList<>(Collections.singletonList(new int[]{0, 1440}));
                List<int[]> freeTimeJ = new ArrayList<>(Collections.singletonList(new int[]{0, 1440}));
                
                if (!assignActivities(activities, assignments, 0, freeTimeC, freeTimeJ)) {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + testCase + ": " + new String(assignments));
                }
            }
        }
        scanner.close();
    }

    private static boolean isImpossible(int[][] activities) {
        int[] minutes = new int[1441];
        for (int[] activity : activities) {
            for (int minute = activity[0]; minute < activity[1]; minute++) {
                minutes[minute]++;
                if (minutes[minute] > 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean assignActivities(int[][] activities, char[] assignments, int index, List<int[]> freeTimeC, List<int[]> freeTimeJ) {
        if (index == assignments.length) {
            return true;
        }

        int start = activities[index][0];
        int end = activities[index][1];

        List<int[]> freeSlots = findAndAssignFreeTime(freeTimeC, start, end);
        if (freeSlots != null) {
            assignments[index] = 'C';
            if (assignActivities(activities, assignments, index + 1, freeTimeC, freeTimeJ)) {
                return true;
            }
            releaseFreeTime(freeTimeC, freeSlots);
        }

        freeSlots = findAndAssignFreeTime(freeTimeJ, start, end);
        if (freeSlots != null) {
            assignments[index] = 'J';
            if (assignActivities(activities, assignments, index + 1, freeTimeC, freeTimeJ)) {
                return true;
            }
            releaseFreeTime(freeTimeJ, freeSlots);
        }

        return false;
    }

    private static void releaseFreeTime(List<int[]> freeTime, List<int[]> freeSlots) {
        freeTime.add(freeSlots.get(0));
        if (freeSlots.size() > 1) {
            freeTime.remove(freeSlots.get(1));
        }
        if (freeSlots.size() > 2) {
            freeTime.remove(freeSlots.get(2));
        }
    }

    private static List<int[]> findAndAssignFreeTime(List<int[]> freeTime, int start, int end) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < freeTime.size(); i++) {
            int[] slot = freeTime.get(i);
            if (start >= slot[0] && end <= slot[1]) {
                result.add(slot);
                freeTime.remove(i);
                if (end < slot[1]) {
                    int[] newSlot = new int[]{end, slot[1]};
                    freeTime.add(i, newSlot);
                    result.add(newSlot);
                }
                if (start > slot[0]) {
                    int[] newSlot = new int[]{slot[0], start};
                    freeTime.add(i, newSlot);
                    result.add(newSlot);
                }
                return result;
            }
        }
        return null;
    }
}