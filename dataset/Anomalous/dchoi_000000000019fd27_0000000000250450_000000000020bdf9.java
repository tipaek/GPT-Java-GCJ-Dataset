import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();

            boolean[] workersAvailable = {true, true}; // Cameron and Jamie
            List<int[]> ongoingJobs = new ArrayList<>(); // [worker, start, end]
            StringBuilder schedule = new StringBuilder();
            boolean conflict = false;

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                // Remove completed jobs
                for (int j = 0; j < ongoingJobs.size(); j++) {
                    int[] job = ongoingJobs.get(j);
                    if (job[2] <= start || end <= job[1]) {
                        workersAvailable[job[0]] = true;
                        ongoingJobs.remove(j);
                        j--; // Adjust index after removal
                    }
                }

                // Assign available worker
                if (!workersAvailable[0] && !workersAvailable[1]) {
                    conflict = true;
                    break;
                } else {
                    int worker = workersAvailable[0] ? 0 : 1;
                    workersAvailable[worker] = false;
                    ongoingJobs.add(new int[]{worker, start, end});
                    schedule.append(worker == 0 ? 'J' : 'C');
                }
            }

            String result = conflict ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + t + ": " + result);
        }
    }
}