import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<Job> jobs = new ArrayList<>();
            int[] assignments = new int[N];
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                jobs.add(new Job(start, end, i));
            }

            Collections.sort(jobs, Comparator.comparingInt(job -> job.start));

            List<Job> cameronJobs = new ArrayList<>();
            List<Job> jamieJobs = new ArrayList<>();
            cameronJobs.add(jobs.get(0));
            assignments[jobs.get(0).index] = 1;

            if (N > 1) {
                jamieJobs.add(jobs.get(1));
                assignments[jobs.get(1).index] = 0;
            }

            for (int i = 2; i < jobs.size(); i++) {
                Job currentJob = jobs.get(i);

                if (currentJob.start >= cameronJobs.get(cameronJobs.size() - 1).end) {
                    cameronJobs.add(currentJob);
                    assignments[currentJob.index] = 1;
                } else if (currentJob.start >= jamieJobs.get(jamieJobs.size() - 1).end) {
                    jamieJobs.add(currentJob);
                    assignments[currentJob.index] = 0;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                for (int assignment : assignments) {
                    result.append(assignment == 1 ? "C" : "J");
                }
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    static class Job {
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