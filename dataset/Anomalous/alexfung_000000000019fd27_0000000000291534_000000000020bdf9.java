import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCount; testCase++) {
            int taskCount = scanner.nextInt();
            TreeMap<Integer, List<int[]>> tasks = new TreeMap<>();

            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[]{i, end});
            }

            int cFreeTime = 0, jFreeTime = 0;
            char[] assignments = new char[taskCount];
            boolean isPossible = true;

            for (Map.Entry<Integer, List<int[]>> entry : tasks.entrySet()) {
                int startTime = entry.getKey();
                List<int[]> taskList = entry.getValue();

                for (int[] task : taskList) {
                    int index = task[0];
                    int endTime = task[1];

                    if (cFreeTime <= startTime) {
                        assignments[index] = 'C';
                        cFreeTime = endTime;
                    } else if (jFreeTime <= startTime) {
                        assignments[index] = 'J';
                        jFreeTime = endTime;
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", testCase, isPossible ? new String(assignments) : "IMPOSSIBLE");
        }
    }
}