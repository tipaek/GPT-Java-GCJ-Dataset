import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];

            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = scanner.nextInt();
                timeSlots[i][1] = scanner.nextInt();
            }

            Arrays.sort(timeSlots, Comparator.comparingInt(a -> a[0]));

            HashMap<String, ArrayList<Integer>> schedule = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(schedule, "J", timeSlots, i) && !assignTask(schedule, "C", timeSlots, i)) {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? buildResult(schedule, n) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> schedule, String person, int[][] timeSlots, int index) {
        ArrayList<Integer> tasks = schedule.getOrDefault(person, new ArrayList<>());

        for (int taskIndex : tasks) {
            if (timeSlots[index][0] < timeSlots[taskIndex][1] && timeSlots[index][1] > timeSlots[taskIndex][0]) {
                return false;
            }
        }

        tasks.add(index);
        schedule.put(person, tasks);
        return true;
    }

    private static String buildResult(HashMap<String, ArrayList<Integer>> schedule, int n) {
        String[] result = new String[n];

        for (Map.Entry<String, ArrayList<Integer>> entry : schedule.entrySet()) {
            String person = entry.getKey();
            for (int index : entry.getValue()) {
                result[index] = person;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String res : result) {
            if (res == null) {
                return "IMPOSSIBLE";
            }
            resultBuilder.append(res);
        }

        return resultBuilder.toString();
    }
}