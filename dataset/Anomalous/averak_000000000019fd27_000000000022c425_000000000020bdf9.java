import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int intervals = scanner.nextInt();
            int[][] tasks = new int[intervals][2];
            Map<String, Integer> taskMap = new HashMap<>();
            boolean impossible = false;

            for (int i = 0; i < intervals; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                String key = tasks[i][0] + "-" + tasks[i][1];
                if (!taskMap.containsKey(key)) {
                    taskMap.put(key, i);
                } else if (!taskMap.containsKey(key + "*")) {
                    taskMap.put(key + "*", i);
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                assignTasks(tasks, t, taskMap);
            }
        }
    }

    public static void assignTasks(int[][] tasks, int caseNumber, Map<String, Integer> taskMap) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        char[] schedule = new char[tasks.length];
        int cEnd = tasks[0][1];
        int jEnd = 0;
        String key = tasks[0][0] + "-" + tasks[0][1];
        schedule[taskMap.get(key)] = 'C';
        taskMap.remove(key);

        for (int i = 1; i < tasks.length; i++) {
            key = tasks[i][0] + "-" + tasks[i][1];
            if (!taskMap.containsKey(key)) {
                key += "*";
            }
            if (tasks[i][0] >= cEnd) {
                schedule[taskMap.get(key)] = 'C';
                cEnd = tasks[i][1];
            } else if (tasks[i][0] >= jEnd) {
                schedule[taskMap.get(key)] = 'J';
                jEnd = tasks[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            taskMap.remove(key);
        }
        System.out.println("Case #" + caseNumber + ": " + new String(schedule));
    }
}