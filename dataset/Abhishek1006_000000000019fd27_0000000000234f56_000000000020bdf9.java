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
                jobPriorityQueue.add(new Job(Integer.parseInt(line[0]), Integer.parseInt(line[1]),k,"C"));
            }

            assignJobs(jobPriorityQueue,i);

        }
    }


    private static void assignJobs(PriorityQueue<Job> jobPriorityQueue, int caseNumber){

        Job cameronJob = new Job(0,0,0,"C");
        Job jamesJob = new Job(0,0,0,"J");

        StringBuilder jobOrder = new StringBuilder();

        PriorityQueue<Job> ansPriorityQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.position - o2.position;
            }
        });

        while (!jobPriorityQueue.isEmpty()){
            Job job = jobPriorityQueue.poll();
            if(cameronJob.end<=job.start){
                cameronJob = job;
                cameronJob.jobDoneBy = "C";
                ansPriorityQueue.add(cameronJob);
            }else if(jamesJob.end<=job.start){
                jamesJob = job;
                jamesJob.jobDoneBy = "J";
                ansPriorityQueue.add(jamesJob);
            }else{
                System.out.println("Case #" + caseNumber + ": " +"IMPOSSIBLE");
                return;
            }
        }

        while (!ansPriorityQueue.isEmpty()) {
            jobOrder.append(ansPriorityQueue.poll().jobDoneBy);
        }

        System.out.println("Case #" + caseNumber + ": " +jobOrder.toString());

    }

    static class Job {
        int start = 0, end = 0,position = 0;
        String jobDoneBy;

        public Job(int start, int end, int position, String jobDoneBy) {
            this.start = start;
            this.end = end;
            this.position = position;
            this.jobDoneBy = jobDoneBy;
        }
    }


}


