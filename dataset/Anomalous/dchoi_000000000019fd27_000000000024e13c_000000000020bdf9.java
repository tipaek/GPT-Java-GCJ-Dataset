import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Queue<Integer> availableWorkers = new LinkedList<>(Arrays.asList(111, 222)); // 111 for J, 222 for C
            List<int[]> inProgress = new ArrayList<>();
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs
                inProgress.removeIf(job -> {
                    if (job[2] <= startTime) {
                        availableWorkers.offer(job[0]);
                        return true;
                    }
                    return false;
                });

                // Check available workers
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                int worker = availableWorkers.poll();
                inProgress.add(new int[]{worker, startTime, endTime});

                workerOrder.append(worker == 111 ? 'J' : 'C');
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}