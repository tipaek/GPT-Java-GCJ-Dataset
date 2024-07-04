import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    private static boolean overlaps(int[] A, int[] B) {
        return A[0] < B[1] && B[0] < A[1];
    }

    private static String assignTasks(int[][] tasks, int taskCount, BufferedWriter out) throws IOException {
        Set<Integer> jennieTasks = new HashSet<>();
        Set<Integer> cameronTasks = new HashSet<>();
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < taskCount; i++) {
            boolean foundOverlap = false;
            int jennieTask = -1;
            int cameronTask = -1;
            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    foundOverlap = true;
                    jennieTask = j + 1;
                    cameronTask = i + 1;
                    break;
                }
            }
            if (foundOverlap) {
                jennieTasks.add(jennieTask);
                cameronTasks.add(cameronTask);
                break;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();

        if (cameronTasks.isEmpty()) {
            for (int task = 0; task < taskCount; task++) {
                resultBuilder.append((task % 2) == 0 ? 'C' : 'J');
            }
            return resultBuilder.toString();
        }

        for (int i = 0; i < taskCount; i++) {
            boolean overlapsJennie = false;
            boolean overlapsCameron = false;

            for (int task : jennieTasks) {
                if ((i + 1) != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsJennie = true;
                    break;
                }
            }

            for (int task : cameronTasks) {
                if ((i + 1) != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsCameron = true;
                    break;
                }
            }

            if (overlapsJennie && overlapsCameron) {
                return "IMPOSSIBLE";
            }

            if (overlapsJennie) {
                cameronTasks.add(i + 1);
            }

            if (overlapsCameron) {
                jennieTasks.add(i + 1);
            }

            if (!overlapsJennie && !overlapsCameron) {
                jennieTasks.add(i + 1);
            }
        }

        char[] resultArray = new char[taskCount];
        for (int task : jennieTasks) {
            resultArray[task - 1] = 'J';
        }

        for (int task : cameronTasks) {
            resultArray[task - 1] = 'C';
        }
        return new String(resultArray);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int tasks = scanner.nextInt();
            int[][] taskArray = new int[tasks][2];
            for (int taskNo = 0; taskNo < tasks; taskNo++) {
                taskArray[taskNo][0] = scanner.nextInt();
                taskArray[taskNo][1] = scanner.nextInt();
            }
            String result = assignTasks(taskArray, tasks, out);
            out.write(String.format("Case #%d: %s", test, result) + "\n");
            out.flush();
        }
    }
}