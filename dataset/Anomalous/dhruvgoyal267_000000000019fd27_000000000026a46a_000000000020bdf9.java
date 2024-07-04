import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int currentTestCase = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];

            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = scanner.nextInt();
                timeSlots[i][1] = scanner.nextInt();
            }

            Arrays.sort(timeSlots, Comparator.comparingInt(slot -> slot[0]));

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTimeSlot(scheduleMap, "J", timeSlots, i) && !assignTimeSlot(scheduleMap, "C", timeSlots, i)) {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isPossible) {
                String[] assignment = new String[n];
                fillAssignment(scheduleMap, "C", assignment, "C");
                fillAssignment(scheduleMap, "J", assignment, "J");

                for (String slot : assignment) {
                    if (slot == null) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    result.append(slot);
                }
            } else {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (currentTestCase - testCases) + ": " + result);
        }
    }

    private static boolean assignTimeSlot(HashMap<String, ArrayList<Integer>> scheduleMap, String person, int[][] timeSlots, int index) {
        ArrayList<Integer> assignedSlots = scheduleMap.getOrDefault(person, new ArrayList<>());

        for (int assignedIndex : assignedSlots) {
            if (timeSlotsOverlap(timeSlots[assignedIndex], timeSlots[index])) {
                return false;
            }
        }

        assignedSlots.add(index);
        scheduleMap.put(person, assignedSlots);
        return true;
    }

    private static boolean timeSlotsOverlap(int[] slot1, int[] slot2) {
        return slot1[0] < slot2[1] && slot1[1] > slot2[0];
    }

    private static void fillAssignment(HashMap<String, ArrayList<Integer>> scheduleMap, String person, String[] assignment, String label) {
        if (scheduleMap.containsKey(person)) {
            for (int index : scheduleMap.get(person)) {
                assignment[index] = label;
            }
        }
    }
}