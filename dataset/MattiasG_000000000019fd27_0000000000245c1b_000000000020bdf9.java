import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int tests = Integer.parseInt(in.readLine());
            for (int test = 0; test < tests; test++) {
                int n = Integer.parseInt(in.readLine());
                List<Job> jobs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    String[] line = in.readLine().split(" ");
                    jobs.add(new Job(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i+1));
                }
                Collections.sort(jobs);

                StringBuilder out = new StringBuilder();
                int end = 0;
                int end2 = 0;
                boolean impossible = false;
                for (Job job : jobs) {
                    if (job.start >= end) {
                        end = job.end;
                        out.append('C');
                    } else if (job.start >= end2) {
                        end2 = job.end;
                        out.append('J');
                    } else {
                        impossible = true;
                        break;
                    }
                }
                if (impossible)
                    System.out.printf("Case #%d: %s\n", test+1, "IMPOSSIBLE");
                else
                    System.out.printf("Case #%d: %s\n", test+1, out.toString());
            }
        }
    }

    private static class Job implements Comparable<Job> {
        int start;
        int end;
        int index;

        public Job(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Job o) {
            return start-o.start;
        }
    }
}