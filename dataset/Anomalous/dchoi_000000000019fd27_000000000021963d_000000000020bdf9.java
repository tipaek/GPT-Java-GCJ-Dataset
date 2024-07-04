import java.io.*;
import java.util.*;

public class Solution {

    public static class Job {
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
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Stack<Character> availableWorkers = new Stack<>();
            availableWorkers.push('J');
            availableWorkers.push('C');
            List<Job> activeJobs = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // Remove completed jobs
                for (Iterator<Job> iterator = activeJobs.iterator(); iterator.hasNext(); ) {
                    Job job = iterator.next();
                    if (job.endTime <= startTime || endTime <= job.startTime) {
                        iterator.remove();
                        availableWorkers.push(job.worker);
                    }
                }

                // Assign a worker if available
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                } else {
                    char worker = availableWorkers.pop();
                    activeJobs.add(new Job(worker, startTime, endTime));
                    schedule.append(worker);
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}