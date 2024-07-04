import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            List<Job> jamJobs = new ArrayList<>();
            List<Job> camJobs = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (canAddJob(jamJobs, start, end)) {
                    jamJobs.add(new Job(start, end));
                    result.append("J");
                } else if (canAddJob(camJobs, start, end)) {
                    camJobs.add(new Job(start, end));
                    result.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean canAddJob(List<Job> jobs, int start, int end) {
        for (Job job : jobs) {
            if (Math.max(job.start, start) < Math.min(job.end, end)) {
                return false;
            }
        }
        return true;
    }
}

class Job {
    int start, end;

    Job(int start, int end) {
        this.start = start;
        this.end = end;
    }
}