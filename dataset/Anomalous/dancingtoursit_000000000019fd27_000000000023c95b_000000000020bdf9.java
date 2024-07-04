import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    private static boolean overlaps(int[] A, int[] B) {
        return (A[0] < B[1] && B[0] < A[1]);
    }

    private static String assignTasks(int[][] tasks, int taskCount) {
        Set<Integer> jennieTasks = new HashSet<>();
        Set<Integer> cameronTasks = new HashSet<>();
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < taskCount; i++) {
            boolean overlapFound = false;
            int jennieOverlap = -1;
            int cameronOverlap = -1;

            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    overlapFound = true;
                    jennieOverlap = j + 1;
                    cameronOverlap = i + 1;
                    break;
                }
            }

            if (overlapFound) {
                jennieTasks.add(jennieOverlap);
                cameronTasks.add(cameronOverlap);
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
            boolean jennieOverlap = false;
            boolean cameronOverlap = false;

            for (int a : jennieTasks) {
                if ((i + 1) != a && overlaps(tasks[a - 1], tasks[i])) {
                    jennieOverlap = true;
                    break;
                }
            }

            for (int a : cameronTasks) {
                if ((i + 1) != a && overlaps(tasks[a - 1], tasks[i])) {
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

        char[] result = new char[taskCount];
        for (int a : jennieTasks) {
            result[a - 1] = 'J';
        }
        for (int b : cameronTasks) {
            result[b - 1] = 'C';
        }
        return new String(result);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int taskNo = 0; taskNo < taskCount; taskNo++) {
                tasks[taskNo][0] = scanner.nextInt();
                tasks[taskNo][1] = scanner.nextInt();
            }

            String result = assignTasks(tasks, taskCount);
            out.write(String.format("Case #%d: %s\n", test, result));
            out.flush();
        }
        scanner.close();
        out.close();
    }
}