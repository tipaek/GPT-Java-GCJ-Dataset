import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];
            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = scanner.nextInt();
                timeSlots[i][1] = scanner.nextInt();
            }

            String result = assignTasks(timeSlots, n);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(int[][] timeSlots, int n) {
        HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
        scheduleMap.put("J", new ArrayList<>());
        scheduleMap.put("C", new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (canAssignTask(scheduleMap.get("J"), timeSlots, i)) {
                scheduleMap.get("J").add(i);
            } else if (canAssignTask(scheduleMap.get("C"), timeSlots, i)) {
                scheduleMap.get("C").add(i);
            } else {
                return "IMPOSSIBLE";
            }
        }

        String[] resultArray = new String[n];
        for (int index : scheduleMap.get("J")) {
            resultArray[index] = "J";
        }
        for (int index : scheduleMap.get("C")) {
            resultArray[index] = "C";
        }

        return String.join("", resultArray);
    }

    private static boolean canAssignTask(ArrayList<Integer> assignedTasks, int[][] timeSlots, int currentIndex) {
        for (int index : assignedTasks) {
            if (timeSlots[currentIndex][0] < timeSlots[index][1] && timeSlots[currentIndex][1] > timeSlots[index][0]) {
                return false;
            }
        }
        return true;
    }
}