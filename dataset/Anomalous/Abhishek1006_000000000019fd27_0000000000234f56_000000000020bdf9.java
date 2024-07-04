import java.util.*;

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
                jobQueue.add(new Job(start, end, j, "C"));
            }

            assignJobs(jobQueue, i);
        }
    }

    private static void assignJobs(PriorityQueue<Job> jobQueue, int caseNumber) {
        Job cameron = new Job(0, 0, 0, "C");
        Job james = new Job(0, 0, 0, "J");
        StringBuilder jobOrder = new StringBuilder();

        PriorityQueue<Job> resultQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.position));

        while (!jobQueue.isEmpty()) {
            Job currentJob = jobQueue.poll();
            if (cameron.end <= currentJob.start) {
                cameron = currentJob;
                cameron.jobDoneBy = "C";
                resultQueue.add(cameron);
            } else if (james.end <= currentJob.start) {
                james = currentJob;
                james.jobDoneBy = "J";
                resultQueue.add(james);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        while (!resultQueue.isEmpty()) {
            jobOrder.append(resultQueue.poll().jobDoneBy);
        }

        System.out.println("Case #" + caseNumber + ": " + jobOrder);
    }

    static class Job {
        int start, end, position;
        String jobDoneBy;

        public Job(int start, int end, int position, String jobDoneBy) {
            this.start = start;
            this.end = end;
            this.position = position;
            this.jobDoneBy = jobDoneBy;
        }
    }
}