import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numJobs = scanner.nextInt();

            List<Integer> availableWorkers = new ArrayList<>(Arrays.asList(111, 222)); // 111 for J, 222 for C
            List<int[]> jobsInProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int job = 1; job <= numJobs; job++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                // Check and remove completed jobs
                Iterator<int[]> iterator = jobsInProgress.iterator();
                while (iterator.hasNext()) {
                    int[] jobInProgress = iterator.next();
                    if (jobInProgress[2] <= startTime || endTime <= jobInProgress[1]) {
                        availableWorkers.add(jobInProgress[0]);
                        iterator.remove();
                    }
                }

                // Check available workers
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                } else {
                    int worker = availableWorkers.remove(0);
                    jobsInProgress.add(new int[]{worker, startTime, endTime});

                    workerOrder.append(worker == 111 ? 'J' : 'C');
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}