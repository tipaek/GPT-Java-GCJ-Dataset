import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            Job[] jobs = new Job[n];

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                jobs[i] = new Job(start, end, i);
            }

            Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));

            char[] schedule = new char[n];
            int camEnd = 0, jamEnd = 0;
            boolean impossible = false;

            for (Job job : jobs) {
                if (camEnd <= job.start) {
                    schedule[job.index] = 'C';
                    camEnd = job.end;
                } else if (jamEnd <= job.start) {
                    schedule[job.index] = 'J';
                    jamEnd = job.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }
        }
    }

    static class Job {
        int start, end, index;

        Job(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}