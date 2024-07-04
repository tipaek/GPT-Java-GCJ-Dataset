import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];

            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = scanner.nextInt();
                timeSlots[i][1] = scanner.nextInt();
            }

            Arrays.sort(timeSlots, Comparator.comparingInt(a -> a[0]));

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(scheduleMap, "J", timeSlots, i)) {
                    if (!assignTask(scheduleMap, "C", timeSlots, i)) {
                        isPossible = false;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (isPossible) {
                String[] assignments = new String[n];
                for (Map.Entry<String, ArrayList<Integer>> entry : scheduleMap.entrySet()) {
                    for (int index : entry.getValue()) {
                        assignments[index] = entry.getKey();
                    }
                }
                for (String assignment : assignments) {
                    if (assignment == null) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    result.append(assignment);
                }
            } else {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result.toString());
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> scheduleMap, String person, int[][] timeSlots, int currentIndex) {
        ArrayList<Integer> personTasks = scheduleMap.getOrDefault(person, new ArrayList<>());
        for (int taskIndex : personTasks) {
            if (timeSlots[currentIndex][0] < timeSlots[taskIndex][1] && timeSlots[currentIndex][1] > timeSlots[taskIndex][0]) {
                return false;
            }
        }
        personTasks.add(currentIndex);
        scheduleMap.put(person, personTasks);
        return true;
    }
}