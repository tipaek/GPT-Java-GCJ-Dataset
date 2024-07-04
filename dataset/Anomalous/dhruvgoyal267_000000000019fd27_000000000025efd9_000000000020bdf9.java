import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int originalT = t;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            HashMap<String, ArrayList<Integer>> assignments = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(assignments, "C", startTimes, endTimes, i) && 
                    !assignTask(assignments, "J", startTimes, endTimes, i)) {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isPossible) {
                String[] taskAssignments = new String[n];
                fillTaskAssignments(assignments, "C", taskAssignments);
                fillTaskAssignments(assignments, "J", taskAssignments);

                for (String task : taskAssignments) {
                    if (task == null) {
                        result.append("IMPOSSIBLE");
                        break;
                    }
                    result.append(task);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (originalT - t) + ": " + result.toString());
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> assignments, String person, int[] startTimes, int[] endTimes, int index) {
        ArrayList<Integer> assignedTasks = assignments.getOrDefault(person, new ArrayList<>());
        for (int assignedTask : assignedTasks) {
            if (startTimes[index] < endTimes[assignedTask] && endTimes[index] > startTimes[assignedTask]) {
                return false;
            }
        }
        assignedTasks.add(index);
        assignments.put(person, assignedTasks);
        return true;
    }

    private static void fillTaskAssignments(HashMap<String, ArrayList<Integer>> assignments, String person, String[] taskAssignments) {
        ArrayList<Integer> assignedTasks = assignments.get(person);
        if (assignedTasks != null) {
            for (int task : assignedTasks) {
                taskAssignments[task] = person;
            }
        }
    }
}