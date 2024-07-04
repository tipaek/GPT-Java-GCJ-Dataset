
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int numOfJobs = Integer.parseInt(in.nextLine());
            PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.start - o2.start;
                }
            });
            for (int k = 0; k < numOfJobs; k++) {
                String[] line = in.nextLine().trim().split(" ");
                jobPriorityQueue.add(new Job(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }

            assignJobs(jobPriorityQueue,i);

        }
    }


    private static void assignJobs(PriorityQueue<Job> jobPriorityQueue, int caseNumber){

        Job cameronJob = new Job(0,0);
        Job jamesJob = new Job(0,0);

        StringBuilder jobOrder = new StringBuilder();

        while (!jobPriorityQueue.isEmpty()){
            Job job = jobPriorityQueue.poll();
            if(cameronJob.end<=job.start){
                cameronJob = job;
                jobOrder.append("C");
            }else if(jamesJob.end<=job.start){
                jamesJob = job;
                jobOrder.append("J");
            }else{
                System.out.println("Case #" + caseNumber + ": " +"IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " +jobOrder.toString());



    }

    static class Job {
        int start = 0, end = 0;

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


