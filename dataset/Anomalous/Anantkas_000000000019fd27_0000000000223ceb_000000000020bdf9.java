import java.util.*;
import java.io.*;

public class Solution {

    private static Map<String, String> assignJobs(String[] jobStrings) {
        String[] jobs = Arrays.copyOf(jobStrings, jobStrings.length);

        Arrays.sort(jobs, (job1, job2) -> {
            int start1 = Integer.parseInt(job1.split(" ")[0]);
            int start2 = Integer.parseInt(job2.split(" ")[0]);
            return Integer.compare(start1, start2);
        });

        int endTimeC = -1, endTimeJ = -1;
        Map<String, String> jobAssignment = new HashMap<>();

        for (String job : jobs) {
            int start = Integer.parseInt(job.split(" ")[0]);
            int end = Integer.parseInt(job.split(" ")[1]);

            if (endTimeC <= start) {
                jobAssignment.put(job, "C");
                endTimeC = end;
            } else if (endTimeJ <= start) {
                jobAssignment.put(job, "J");
                endTimeJ = end;
            }
        }

        return jobAssignment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            int numJobs = scanner.nextInt();
            scanner.nextLine();

            String[] jobs = new String[numJobs];
            for (int j = 0; j < numJobs; j++) {
                jobs[j] = scanner.nextLine();
            }

            Map<String, String> jobAssignment = assignJobs(jobs);
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (String job : jobs) {
                if (!jobAssignment.containsKey(job)) {
                    isImpossible = true;
                    break;
                }
                result.append(jobAssignment.get(job));
            }

            System.out.println("Case #" + i + ": " + (isImpossible ? "IMPOSSIBLE" : result.toString()));
        }
    }
}