import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            if (numActivities > 10 && !isPossibleToSchedule(activities)) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }

            char[] assignments = new char[numActivities];
            Arrays.fill(assignments, '0');
            List<int[]> freeTimeCameron = new ArrayList<>();
            List<int[]> freeTimeJamie = new ArrayList<>();
            freeTimeCameron.add(new int[]{0, 1440});
            freeTimeJamie.add(new int[]{0, 1440});

            if (!assignActivities(activities, assignments, 0, freeTimeCameron, freeTimeJamie)) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + new String(assignments));
            }
        }
        scanner.close();
    }

    private static boolean isPossibleToSchedule(int[][] activities) {
        int[] minutes = new int[1441];
        Arrays.fill(minutes, 0);
        for (int[] activity : activities) {
            for (int minute = activity[0]; minute < activity[1]; minute++) {
                minutes[minute]++;
                if (minutes[minute] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean assignActivities(int[][] activities, char[] assignments, int index,
                                            List<int[]> freeTimeCameron, List<int[]> freeTimeJamie) {
        if (index == assignments.length) return true;

        int start = activities[index][0];
        int end = activities[index][1];

        List<int[]> freeSlots = findAndAssignFreeTime(freeTimeCameron, start, end);
        if (freeSlots != null) {
            assignments[index] = 'C';
            if (assignActivities(activities, assignments, index + 1, freeTimeCameron, freeTimeJamie)) {
                return true;
            }
            releaseFreeTime(freeTimeCameron, freeSlots);
        }

        freeSlots = findAndAssignFreeTime(freeTimeJamie, start, end);
        if (freeSlots != null) {
            assignments[index] = 'J';
            if (assignActivities(activities, assignments, index + 1, freeTimeCameron, freeTimeJamie)) {
                return true;
            }
            releaseFreeTime(freeTimeJamie, freeSlots);
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
        List<int[]> allocatedSlots = new ArrayList<>();
        for (int i = 0; i < freeTime.size(); i++) {
            int[] slot = freeTime.get(i);
            if (start >= slot[0] && end <= slot[1]) {
                allocatedSlots.add(slot);
                freeTime.remove(i);
                if (slot[1] > end) {
                    int[] newSlot = new int[]{end, slot[1]};
                    freeTime.add(i, newSlot);
                    allocatedSlots.add(newSlot);
                }
                if (slot[0] < start) {
                    int[] newSlot = new int[]{slot[0], start};
                    freeTime.add(i, newSlot);
                    allocatedSlots.add(newSlot);
                }
                return allocatedSlots;
            }
        }
        return null;
    }
}