import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static boolean overlaps(int[] A, int[] B) {
        return (A[0] < B[1] && A[1] > B[0]) || (B[0] < A[1] && B[1] > A[0]);
    }

    private static String solve(int[][] tasks, int taskCount, BufferedWriter out) throws IOException {
        Set<Integer> jennieTasks = new HashSet<>();
        Set<Integer> cameronTasks = new HashSet<>();

        for (int i = 0; i < taskCount; i++) {
            boolean overlapFound = false;
            int firstTask = -1;
            int secondTask = -1;

            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    firstTask = i + 1;
                    secondTask = j + 1;
                    overlapFound = true;
                    break;
                }
            }

            if (overlapFound) {
                jennieTasks.add(firstTask);
                cameronTasks.add(secondTask);
                break;
            }
        }

        StringBuilder result = new StringBuilder();

        if (cameronTasks.isEmpty()) {
            for (int task = 0; task < taskCount; task++) {
                result.append((task % 2 == 0) ? 'C' : 'J');
            }
            return result.toString();
        }

        for (int i = 0; i < taskCount; i++) {
            boolean jennieOverlap = false;
            boolean cameronOverlap = false;

            for (int task : jennieTasks) {
                if (task != i + 1 && overlaps(tasks[task - 1], tasks[i])) {
                    jennieOverlap = true;
                    break;
                }
            }

            for (int task : cameronTasks) {
                if (task != i + 1 && overlaps(tasks[task - 1], tasks[i])) {
                    cameronOverlap = true;
                    break;
                }
            }

            if (jennieOverlap && cameronOverlap) {
                return "IMPOSSIBLE";
            }

            if (jennieOverlap) {
                cameronTasks.add(i + 1);
            } else if (cameronOverlap) {
                jennieTasks.add(i + 1);
            } else {
                jennieTasks.add(i + 1);
            }
        }

        char[] taskAssignment = new char[taskCount];

        for (int task : jennieTasks) {
            taskAssignment[task - 1] = 'J';
        }

        for (int task : cameronTasks) {
            taskAssignment[task - 1] = 'C';
        }

        return new String(taskAssignment);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            String result = solve(tasks, taskCount, out);
            out.write(String.format("Case #%d: %s\n", test, result));
            out.flush();
        }
    }
}