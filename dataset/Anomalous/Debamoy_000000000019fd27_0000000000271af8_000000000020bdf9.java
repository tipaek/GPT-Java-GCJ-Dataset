import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int taskCount = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[taskCount][2];

            for (int i = 0; i < taskCount; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            String result = assignTasks(tasks);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(int[][] tasks) {
        int taskCount = tasks.length;
        char[] schedule = new char[taskCount];
        Arrays.fill(schedule, 'C');

        List<int[]> overlaps = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            for (int j = 0; j < taskCount; j++) {
                if (i != j && tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                    overlaps.add(new int[]{i, j});
                }
            }
        }

        for (int[] overlap : overlaps) {
            int first = overlap[0];
            int second = overlap[1];

            if (schedule[Math.min(first, second)] == 'J') {
                schedule[Math.max(first, second)] = 'C';
            } else if (schedule[Math.min(first, second)] == 'C') {
                schedule[Math.max(first, second)] = 'J';
            }
        }

        for (int[] overlap : overlaps) {
            int first = overlap[0];
            int second = overlap[1];

            if (schedule[first] == schedule[second]) {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}