import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Stack<Integer> workers = new Stack<>(); // the two parents: Cameron, Jamie
            workers.push(111);  // J
            workers.push(222);  // C
            List<int[]> inProgress = new ArrayList<>(); // [worker, startTime, endTime]
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // check and remove completed jobs
                for (int i = 0; i < inProgress.size(); i++) {
                    int[] j = inProgress.get(i);
                    if (j[2] <= startTime || endTime <= j[1]) {
                        workers.push(j[0]);
                        inProgress.remove(i);
                    }
                }

                // check available workers
                if (workers.size() <= 0) {
                    isImpossible = true;
                    break;
                }

                Integer worker = workers.pop();
                inProgress.add(new int[]{worker, startTime, endTime});

                if (worker.equals(111)) {
                    workerOrder.append('J');
                }
                else {
                    workerOrder.append('C');
                }
            }

            String s = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();

            String line = "Case #" + test_case + ": " + s;
            System.out.println(line);
        }
    }
}
