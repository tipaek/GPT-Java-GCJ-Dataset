import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int tc = 0;

        while (++tc <= T) {
            int N = scanner.nextInt();
            Job[] activities = new Job[N];

            for (int i = 0; i < N; i++) {
                int st = scanner.nextInt();
                int fin = scanner.nextInt();
                Job newJob = new Job(st, fin);
                activities[i] = newJob;
            }
            Arrays.sort(activities, Job::compareTo);
            int jAvailable = 0;
            int cAvailable = 0;
            String res = "";
            boolean impossible = false;

            for (Job job: activities) {
                int start = job.start;
                int end = job.finish;
                if (jAvailable <= start) {
                    res += 'J';
                    jAvailable = end;
                }
                else if (cAvailable <= start) {
                    res += 'C';
                    cAvailable = end;
                }
                else {
                    impossible = true;
                    break;
                }
            }


            System.out.println("Case #" + tc + ": " + ((impossible) ? "IMPOSSIBLE" : res));
        }
    }

    static class Job {
        int start;
        int finish;

        public Job(int start, int finish) {
            this.finish = finish;
            this.start = start;
        }

        public int compareTo(Job job) {
            if (this.start > job.start) return 1;
            else return -1;
        }
    }
}