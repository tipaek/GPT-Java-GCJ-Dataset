import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Queue<Integer> availableWorkers = new LinkedList<>(Arrays.asList(222, 111)); // C, J
            List<int[]> inProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs
                Iterator<int[]> iterator = inProgress.iterator();
                while (iterator.hasNext()) {
                    int[] job = iterator.next();
                    if (job[2] <= startTime) {
                        availableWorkers.offer(job[0]);
                        iterator.remove();
                    }
                }

                // Check available workers
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                } else {
                    int worker = availableWorkers.poll();
                    inProgress.add(new int[]{worker, startTime, endTime});

                    if (worker == 111) {
                        workerOrder.append('J');
                    } else {
                        workerOrder.append('C');
                    }
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}