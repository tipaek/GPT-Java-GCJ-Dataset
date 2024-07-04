import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            boolean[] availableWorkers = new boolean[]{true, true}; // the two parents: Cameron, Jamie
            List<int[]> jobsInProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // check and remove completed jobs
                for (int i = 0; i < jobsInProgress.size(); i++) {
                    int[] job = jobsInProgress.get(i);

                    if (job[3] != 1) {
                        continue;
                    }

                    if (job[2] <= startTime || endTime <= job[1]) {
                        availableWorkers[job[0]] = true;
                        job[3] = 0;
                        break;
                    }
                }

                // check available workers
                /*
                if (!availableWorkers[0] && !availableWorkers[1]) {
                    isImpossible = true;
                    break;
                } else {
                    int worker = availableWorkers[0] ? 0 : 1;
                    availableWorkers[worker] = false;
                    jobsInProgress.add(new int[]{worker, startTime, endTime, 1});

                    if (worker == 0) {
                        workerOrder.append('J');
                    } else {
                        workerOrder.append('C');
                    }
                }
                */
            }

            String s = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();

            String line = "Case #" + test_case + ": " + s;
            System.out.println(line);
        }
    }
}
