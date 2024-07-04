import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            boolean[] availableWorkers = new boolean[]{true, true}; // Cameron and Jamie
            List<int[]> jobsInProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs
                jobsInProgress.removeIf(job -> job[2] <= startTime);

                // Check available workers
                if (availableWorkers[0] || availableWorkers[1]) {
                    int worker = availableWorkers[0] ? 0 : 1;
                    availableWorkers[worker] = false;
                    jobsInProgress.add(new int[]{worker, startTime, endTime});
                    workerOrder.append(worker == 0 ? 'C' : 'J');
                } else {
                    isImpossible = true;
                    break;
                }

                // Mark workers as available for jobs that have ended by the current start time
                for (int[] job : jobsInProgress) {
                    if (job[2] <= startTime) {
                        availableWorkers[job[0]] = true;
                    }
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}