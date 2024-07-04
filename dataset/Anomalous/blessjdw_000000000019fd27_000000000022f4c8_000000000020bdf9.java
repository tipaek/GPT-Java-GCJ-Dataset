import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int[] taskC = new int[10000];
            int[] taskJ = new int[10000];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int n = 1; n <= activities; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (isAvailable(taskC, start, end)) {
                    assignTask(taskC, start, end, n);
                } else if (isAvailable(taskJ, start, end)) {
                    assignTask(taskJ, start, end, n);
                } else {
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Set<Integer> cTasks = new HashSet<>();
                for (int task : taskC) cTasks.add(task);
                for (int i = 1; i <= activities; i++) {
                    if (cTasks.contains(i)) result.append("C");
                    else result.append("J");
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] task, int from, int to) {
        for (int i = from; i < to; i++) {
            if (task[i] > 0) return false;
        }
        return true;
    }

    private static void assignTask(int[] task, int from, int to, int num) {
        for (int i = from; i < to; i++) {
            task[i] = num;
        }
    }
}