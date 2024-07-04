import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();
            Job[] jobs = new Job[n];
            char[] assignments = new char[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                jobs[i] = new Job(start, end, i);
            }

            Arrays.sort(jobs, new JobComparator());

            int cameronEnd = 0, jamieEnd = 0;

            for (Job job : jobs) {
                if (cameronEnd <= job.start) {
                    assignments[job.index] = 'C';
                    cameronEnd = job.end;
                } else if (jamieEnd <= job.start) {
                    assignments[job.index] = 'J';
                    jamieEnd = job.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + ti + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + ti + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }
}

class Job {
    int start, end, index;

    Job(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        if (j1.start != j2.start) {
            return Integer.compare(j1.start, j2.start);
        } else {
            return Integer.compare(j1.end, j2.end);
        }
    }
}