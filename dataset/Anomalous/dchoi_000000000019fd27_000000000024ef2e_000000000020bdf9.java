import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Stack<Integer> availableWorkers = new Stack<>();
            availableWorkers.push(111);  // J
            availableWorkers.push(222);  // C
            List<int[]> activeTasks = new ArrayList<>();
            StringBuilder assignmentSequence = new StringBuilder();
            boolean impossible = false;

            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed tasks
                Iterator<int[]> iterator = activeTasks.iterator();
                while (iterator.hasNext()) {
                    int[] task = iterator.next();
                    if (task[2] <= startTime) {
                        availableWorkers.push(task[0]);
                        iterator.remove();
                    }
                }

                // Assign a worker to the new task
                if (availableWorkers.isEmpty()) {
                    impossible = true;
                    break;
                } else {
                    int worker = availableWorkers.pop();
                    activeTasks.add(new int[]{worker, startTime, endTime});
                    assignmentSequence.append(worker == 111 ? 'J' : 'C');
                }
            }

            String result = impossible ? "IMPOSSIBLE" : assignmentSequence.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}