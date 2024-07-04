import java.io.*;
import java.util.*;

public class Solution {

    static class Job {
        char worker;
        int startTime;
        int endTime;

        Job(char worker, int startTime, int endTime) {
            this.worker = worker;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();

            Stack<Character> availableWorkers = new Stack<>();
            availableWorkers.push('J');
            availableWorkers.push('C');
            List<Job> ongoingJobs = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder jobAssignments = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                // Remove completed jobs
                for (Iterator<Job> iterator = ongoingJobs.iterator(); iterator.hasNext(); ) {
                    Job job = iterator.next();
                    if (job.endTime <= start || end <= job.startTime) {
                        iterator.remove();
                        availableWorkers.push(job.worker);
                    }
                }

                // Assign job if a worker is available
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                char worker = availableWorkers.pop();
                ongoingJobs.add(new Job(worker, start, end));
                jobAssignments.append(worker);
            }

            String result = isImpossible ? "IMPOSSIBLE" : jobAssignments.toString();
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }
}