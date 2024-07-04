import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int numOfJobs = Integer.parseInt(scanner.nextLine());
            PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.start));

            for (int j = 0; j < numOfJobs; j++) {
                String[] jobDetails = scanner.nextLine().trim().split(" ");
                int start = Integer.parseInt(jobDetails[0]);
                int end = Integer.parseInt(jobDetails[1]);
                jobQueue.add(new Job(start, end));
            }

            assignJobs(jobQueue, i);
        }
    }

    private static void assignJobs(PriorityQueue<Job> jobQueue, int caseNumber) {
        Job cameronJob = new Job(0, 0);
        Job jamesJob = new Job(0, 0);
        StringBuilder jobOrder = new StringBuilder();

        while (!jobQueue.isEmpty()) {
            Job currentJob = jobQueue.poll();

            if (cameronJob.end <= currentJob.start) {
                cameronJob = currentJob;
                jobOrder.append("C");
            } else if (jamesJob.end <= currentJob.start) {
                jamesJob = currentJob;
                jobOrder.append("J");
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + jobOrder.toString());
    }

    static class Job {
        int start;
        int end;

        Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}