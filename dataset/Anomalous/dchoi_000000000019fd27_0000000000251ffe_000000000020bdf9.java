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

                // Check and remove completed jobs
                for (Iterator<int[]> iterator = jobsInProgress.iterator(); iterator.hasNext(); ) {
                    int[] job = iterator.next();
                    if (job[2] <= startTime) {
                        availableWorkers[job[0]] = true;
                        iterator.remove();
                    }
                }

                // Assign job to available worker
                if (availableWorkers[0]) {
                    availableWorkers[0] = false;
                    jobsInProgress.add(new int[]{0, startTime, endTime});
                    workerOrder.append('C');
                } else if (availableWorkers[1]) {
                    availableWorkers[1] = false;
                    jobsInProgress.add(new int[]{1, startTime, endTime});
                    workerOrder.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}