import java.io.*;
import java.util.*;

public class Solution {
    private static boolean overlaps(int[] A, int[] B) {
        return (A[0] < B[1] && B[0] < A[1]);
    }

    private static String solution(int[][] tasks, int taskCount) {
        Set<Integer> jennie = new HashSet<>();
        Set<Integer> cameron = new HashSet<>();
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

        for (int i = 0; i < taskCount; i++) {
            boolean found = false;
            int a = -1, b = -1;
            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    found = true;
                    a = j + 1;
                    b = i + 1;
                    break;
                }
            }
            if (found) {
                jennie.add(a);
                cameron.add(b);
                break;
            }
        }

        StringBuilder result = new StringBuilder();

        if (cameron.isEmpty()) {
            for (int task = 0; task < taskCount; task++) {
                result.append((task % 2) == 0 ? 'C' : 'J');
            }
            return result.toString();
        }

        for (int i = 0; i < taskCount; i++) {
            boolean overlapsA = false, overlapsB = false;

            for (int a : jennie) {
                if ((i + 1) != a && overlaps(tasks[a - 1], tasks[i])) {
                    overlapsA = true;
                    break;
                }
            }

            for (int b : cameron) {
                if ((i + 1) != b && overlaps(tasks[b - 1], tasks[i])) {
                    overlapsB = true;
                    break;
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
        try (Scanner scanner = new Scanner(new FileReader("schedule.in"));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = scanner.nextInt();
            for (int test = 1; test <= T; test++) {
                int taskCount = scanner.nextInt();
                int[][] tasks = new int[taskCount][2];
                for (int taskNo = 0; taskNo < taskCount; taskNo++) {
                    tasks[taskNo][0] = scanner.nextInt();
                    tasks[taskNo][1] = scanner.nextInt();
                }
                String res = solution(tasks, taskCount);
                out.write(String.format("Case #%d: %s\n", test, res));
                if (!res.equals("IMPOSSIBLE")) {
                    assert res.length() == taskCount;
                }
                out.flush();
            }
        }
    }
}