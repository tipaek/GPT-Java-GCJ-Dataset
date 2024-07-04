import java.util.*;
import java.io.*;

public class Solution {

    private static Map<String, String> assignJobs(String[] jobStrings) {
        String[] jobs = Arrays.copyOf(jobStrings, jobStrings.length);

        Arrays.sort(jobs, (o1, o2) -> {
            int start1 = Integer.parseInt(o1.split(" ")[0]);
            int start2 = Integer.parseInt(o2.split(" ")[0]);
            return Integer.compare(start1, start2);
        });

        int endTimeC = -1, endTimeJ = -1;
        Map<String, String> jobAssignment = new HashMap<>();
        String previousJob = "";
        int duplicateCount = 0;

        for (String job : jobs) {
            if (job.equals(previousJob)) {
                duplicateCount++;
            }

            if (duplicateCount > 1) {
                return null;
            }

            int start = Integer.parseInt(job.split(" ")[0]);
            int end = Integer.parseInt(job.split(" ")[1]);

            if (duplicateCount == 1) {
                job += "#";
            }

            if (endTimeC <= start) {
                jobAssignment.put(job, "C");
                endTimeC = end;
            } else if (endTimeJ <= start) {
                jobAssignment.put(job, "J");
                endTimeJ = end;
            } else {
                return null;
            }

            previousJob = job;
        }

        return jobAssignment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int jobCount = scanner.nextInt();
            scanner.nextLine();

            String[] jobs = new String[jobCount];
            for (int j = 0; j < jobCount; j++) {
                jobs[j] = scanner.nextLine();
            }

            Map<String, String> jobAssignments = assignJobs(jobs);
            StringBuilder result = new StringBuilder();
            if (jobAssignments == null) {
                result.append("IMPOSSIBLE");
            } else {
                for (String job : jobs) {
                    if (jobAssignments.containsKey(job)) {
                        result.append(jobAssignments.get(job));
                        jobAssignments.remove(job);
                    } else {
                        result.append(jobAssignments.get(job + "#"));
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}