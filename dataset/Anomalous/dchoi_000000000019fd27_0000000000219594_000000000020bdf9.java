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
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfJobs = scanner.nextInt();

            Stack<Character> availableWorkers = new Stack<>();
            availableWorkers.push('J');
            availableWorkers.push('C');
            List<Job> activeJobs = new ArrayList<>();
            boolean impossible = false;
            StringBuilder assignmentOrder = new StringBuilder();

            for (int jobIndex = 0; jobIndex < numberOfJobs; jobIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                // Remove completed jobs
                for (int i = 0; i < activeJobs.size(); i++) {
                    Job job = activeJobs.get(i);
                    if (job.endTime <= start || end <= job.startTime) {
                        activeJobs.remove(job);
                        availableWorkers.push(job.worker);
                    }
                }
            }

            String result = impossible ? "IMPOSSIBLE" : assignmentOrder.toString();
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }
}