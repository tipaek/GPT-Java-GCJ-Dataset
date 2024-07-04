import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tcCount = in.nextInt();

        for (int x = 1; x <= tcCount; x++) {
            in.nextLine();
            int n = in.nextInt();
            List<Job> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                in.nextLine();
                jobs.add(new Job(in.nextInt(), in.nextInt(), i));
            }
            solveScheduling(x, n, jobs);
        }
    }

    private static void solveScheduling(int testCaseNumber, int n, List<Job> jobs) {
        StringBuilder result = new StringBuilder();
        Collections.sort(jobs, Comparator.comparingInt(job -> job.start));

        char[] assignees = new char[n];
        int cEnd = 0, jEnd = 0;

        for (Job job : jobs) {
            if (cEnd <= job.start) {
                cEnd = job.end;
                assignees[job.index] = 'C';
            } else if (jEnd <= job.start) {
                jEnd = job.end;
                assignees[job.index] = 'J';
            } else {
                result.append("IMPOSSIBLE");
                break;
            }
        }

        if (result.length() == 0) {
            result.append(new String(assignees));
        }

        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static class Job {
        int start;
        int end;
        int index;

        Job(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}