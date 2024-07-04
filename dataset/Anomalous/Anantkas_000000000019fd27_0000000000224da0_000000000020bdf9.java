import java.util.*;
import java.io.*;

public class Solution {

    private static Map<String, String> assignJobs(String[] jobArray) {
        List<String> jobs = new ArrayList<>(Arrays.asList(jobArray));
        
        jobs.sort((o1, o2) -> {
            int start1 = Integer.parseInt(o1.split(" ")[0]);
            int start2 = Integer.parseInt(o2.split(" ")[0]);
            return Integer.compare(start1, start2);
        });

        int endTimeC = -1, endTimeJ = -1;
        Map<String, String> jobAssignments = new HashMap<>();

        for (String job : jobs) {
            int start = Integer.parseInt(job.split(" ")[0]);
            int end = Integer.parseInt(job.split(" ")[1]);

            if (endTimeC <= start) {
                jobAssignments.put(job, "C");
                endTimeC = end;
            } else if (endTimeJ <= start) {
                jobAssignments.put(job, "J");
                endTimeJ = end;
            } else {
                return null;
            }
        }

        return jobAssignments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
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
                    result.append(jobAssignments.getOrDefault(job, ""));
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}