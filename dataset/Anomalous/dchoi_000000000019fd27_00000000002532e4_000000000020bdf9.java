import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            boolean[] availableWorkers = {true, true}; // Cameron and Jamie
            List<int[]> jobsInProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs
                for (int i = 0; i < jobsInProgress.size(); i++) {
                    int[] job = jobsInProgress.get(i);

                    if (job[2] <= startTime) {
                        availableWorkers[job[0]] = true;
                        jobsInProgress.remove(i);
                        i--; // Adjust index after removal
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