import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

            if (hasOverlappingActivities(activities)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                char[] assignments = new char[activityCount];
                Arrays.fill(assignments, '0');
                
                List<int[]> freeTimeC = new ArrayList<>();
                List<int[]> freeTimeJ = new ArrayList<>();
                
                freeTimeC.add(new int[]{0, 1440});
                freeTimeJ.add(new int[]{0, 1440});
                
                if (!assignActivities(activities, assignments, 0, freeTimeC, freeTimeJ)) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + new String(assignments));
                }
            }
        }
        scanner.close();
    }

    private static boolean hasOverlappingActivities(int[][] activities) {
        int[] minutes = new int[1441];
        for (int[] activity : activities) {
            for (int minute = activity[0]; minute < activity[1]; minute++) {
                if (++minutes[minute] > 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean assignActivities(int[][] activities, char[] assignments, int index, List<int[]> freeTimeC, List<int[]> freeTimeJ) {
        if (index == assignments.length) return true;

        int start = activities[index][0];
        int end = activities[index][1];

        if (assignToPerson(activities, assignments, index, freeTimeC, 'C', start, end)) {
            return true;
        }
        return assignToPerson(activities, assignments, index, freeTimeJ, 'J', start, end);
    }

    private static boolean assignToPerson(int[][] activities, char[] assignments, int index, List<int[]> freeTime, char person, int start, int end) {
        List<int[]> freeSlots = findAndAssignFreeTime(freeTime, start, end);
        if (freeSlots != null) {
            assignments[index] = person;
            if (assignActivities(activities, assignments, index + 1, freeTime, freeTime)) {
                return true;
            }
            releaseFreeTime(freeTime, freeSlots);
        }
        return false;
    }

    private static List<int[]> findAndAssignFreeTime(List<int[]> freeTime, int start, int end) {
        for (int i = 0; i < freeTime.size(); i++) {
            int[] slot = freeTime.get(i);
            if (slot[0] <= start && slot[1] >= end) {
                List<int[]> assignedSlots = new ArrayList<>();
                assignedSlots.add(slot);
                freeTime.remove(i);
                
                if (slot[0] < start) {
                    int[] newSlot = {slot[0], start};
                    freeTime.add(i, newSlot);
                    assignedSlots.add(newSlot);
                }
                if (slot[1] > end) {
                    int[] newSlot = {end, slot[1]};
                    freeTime.add(i, newSlot);
                    assignedSlots.add(newSlot);
                }
                return assignedSlots;
            }
        }
        return null;
    }

    private static void releaseFreeTime(List<int[]> freeTime, List<int[]> assignedSlots) {
        freeTime.add(assignedSlots.get(0));
        if (assignedSlots.size() > 1) {
            freeTime.remove(assignedSlots.get(1));
        }
        if (assignedSlots.size() > 2) {
            freeTime.remove(assignedSlots.get(2));
        }
    }
}