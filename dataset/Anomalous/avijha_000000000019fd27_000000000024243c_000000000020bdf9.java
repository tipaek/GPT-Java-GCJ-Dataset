import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int taskCount = scanner.nextInt();
            Job[] jobs = new Job[taskCount];
            
            for (int i = 0; i < taskCount; i++) {
                jobs[i] = new Job(scanner.nextInt(), scanner.nextInt(), i);
            }
            
            Arrays.sort(jobs, (job1, job2) -> Integer.compare(job1.start, job2.start));
            
            int cEnd = 0;
            int jEnd = 0;
            char[] assignees = new char[taskCount];
            boolean possible = true;
            
            for (Job job : jobs) {
                if (job.start >= cEnd) {
                    assignees[job.index] = 'C';
                    cEnd = job.end;
                } else if (job.start >= jEnd) {
                    assignees[job.index] = 'J';
                    jEnd = job.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            String result = possible ? new String(assignees) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s%n", test, result);
        }
        
        scanner.close();
    }

    static class Job {
        int start;
        int end;
        int index;

        public Job(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}