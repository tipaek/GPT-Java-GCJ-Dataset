import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for(int t = 1; t <= tests; t++) {

            int n = sc.nextInt();
            ArrayList<Job> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                jobs.add(new Job(sc.nextInt(), sc.nextInt(), i));
            }

            Collections.sort(jobs, (Job a, Job b) -> (a.start - b.start));

            int assigned = 0;
            int lastEnd = 0;
            for(Job job : jobs) {
                if(job.start >= lastEnd) {
                    job.assignedTo = 'C';
                    assigned ++;
                    lastEnd = job.end;
                }
            }

            lastEnd = 0;
            for(Job job : jobs) {
                if(job.start >= lastEnd && job.assignedTo == ' ') {
                    job.assignedTo = 'J';
                    assigned ++;
                    lastEnd = job.end;
                }
            }

            char[] schedule = new char[jobs.size()];

            System.out.print("Case #" + t + ": ");

            if(assigned != jobs.size())
                System.out.print("IMPOSSIBLE");
            else {
                for(Job job : jobs) {
                    schedule[job.activityNum] = job.assignedTo;
                }

                for(char c : schedule) {
                    System.out.print(c);
                }
            }

            System.out.println();
        }


        sc.close();
    }
}

class Job {

    int start;
    int end;
    char assignedTo;
    int activityNum;

    Job(int start, int end, int activityNum) {
        this.start = start;
        this.end = end;
        this.assignedTo = ' ';
        this.activityNum = activityNum;
    }

}
