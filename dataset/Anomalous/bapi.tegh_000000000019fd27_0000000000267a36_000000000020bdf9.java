import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            Job[] jobs = new Job[n];
            char[] assignments = new char[n];
            boolean impossible = false;

            // Reading jobs
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                jobs[i] = new Job(start, end, i);
            }

            // Sorting jobs by their end time
            Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));

            int camEnd = 0, jamEnd = 0;

            // Assigning jobs
            for (Job job : jobs) {
                if (camEnd <= job.start) {
                    assignments[job.index] = 'C';
                    camEnd = job.end;
                } else if (jamEnd <= job.start) {
                    assignments[job.index] = 'J';
                    jamEnd = job.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            // Output result
            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(assignments));
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