import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt(); // Number of test cases
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // Number of activities

            Queue<Integer> availableWorkers = new LinkedList<>(Arrays.asList(222, 111)); // 222 for Cameron (C), 111 for Jamie (J)
            List<int[]> inProgress = new ArrayList<>(); // List to track ongoing activities [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int index = 0; index < N; index++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs from inProgress and add workers back to available pool
                inProgress.removeIf(job -> {
                    if (job[2] <= startTime || endTime <= job[1]) {
                        availableWorkers.add(job[0]);
                        return true;
                    }
                    return false;
                });

                // Check if any worker is available
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                // Assign the job to an available worker
                int worker = availableWorkers.poll();
                inProgress.add(new int[]{worker, startTime, endTime});

                // Append the worker's identifier to the result
                workerOrder.append(worker == 111 ? 'J' : 'C');
            }

            // Prepare the result for the current test case
            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.printf("Case #%d: %s%n", test_case, result);
        }
    }
}