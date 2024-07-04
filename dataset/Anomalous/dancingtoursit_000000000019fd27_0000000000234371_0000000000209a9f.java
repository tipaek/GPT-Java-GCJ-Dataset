import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {

    private static boolean overlaps(int[] A, int[] B) {
        return (A[0] < B[1] && A[1] > B[0]);
    }

    private static String solve(int[][] tasks, int taskCount) {
        Set<Integer> jennie = new HashSet<>();
        Set<Integer> cameron = new HashSet<>();
        
        for (int i = 0; i < taskCount; i++) {
            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    jennie.add(i + 1);
                    cameron.add(j + 1);
                    break;
                }
            }
            if (!jennie.isEmpty()) break;
        }

        StringBuilder result = new StringBuilder();

        if (cameron.isEmpty()) {
            for (int i = 0; i < taskCount; i++) {
                result.append((i % 2 == 0) ? 'C' : 'J');
            }
            return result.toString();
        }

        for (int i = 0; i < taskCount; i++) {
            boolean overlapsA = false;
            boolean overlapsB = false;

            for (int a : jennie) {
                if ((i + 1) != a && overlaps(tasks[a - 1], tasks[i])) {
                    overlapsA = true;
                }
            }

            for (int b : cameron) {
                if ((i + 1) != b && overlaps(tasks[b - 1], tasks[i])) {
                    overlapsB = true;
                }
            }

            if (overlapsA && overlapsB) {
                return "IMPOSSIBLE";
            }

            if (overlapsA) {
                cameron.add(i + 1);
            } else if (overlapsB) {
                jennie.add(i + 1);
            } else {
                jennie.add(i + 1);
            }
        }

        char[] res = new char[taskCount];
        for (int a : jennie) {
            res[a - 1] = 'J';
        }
        for (int b : cameron) {
            res[b - 1] = 'C';
        }
        return new String(res);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = scanner.nextInt();
        for (int test = 1; test <= T; test++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            String result = solve(tasks, taskCount);
            out.write(String.format("Case #%d: %s\n", test, result));
            out.flush();
        }
        scanner.close();
    }
}