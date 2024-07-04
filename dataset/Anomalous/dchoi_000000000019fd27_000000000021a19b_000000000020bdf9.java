import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Queue<Integer> availableWorkers = new LinkedList<>(Arrays.asList(111, 222)); // Cameron (C) and Jamie (J)
            List<int[]> inProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int index = 0; index < N; index++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Check and remove completed jobs
                Iterator<int[]> iterator = inProgress.iterator();
                while (iterator.hasNext()) {
                    int[] job = iterator.next();
                    if (job[2] <= startTime) {
                        availableWorkers.add(job[0]);
                        iterator.remove();
                    }
                }

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
            System.out.printf("Case #%d: %s%n", test_case, result);
        }
    }
}