import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            nextTest:
            for (int t = 0; t < T; t++) {
                int n = sc.nextInt();

                List<Job> jobs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    jobs.add(new Job(sc.nextInt(), sc.nextInt(), i));
                }
                Collections.sort(jobs);

                ArrayDeque<Job> c = new ArrayDeque<>();
                ArrayDeque<Job> j = new ArrayDeque<>();

                for (Job job : jobs) {
                    Job clast = c.peek();
                    Job jlast = j.peek();
                    if (clast == null || clast.end <= job.start) {
                        c.push(job);
                    } else if (jlast == null || jlast.end <= job.start) {
                        j.push(job);
                    } else {
                        out.println(String.format("Case #%s: IMPOSSIBLE", t + 1));
                        continue nextTest;
                    }
                }
                
                Set<Integer> cset = c.stream().map(job -> job.idx).collect(Collectors.toSet());

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (cset.contains(i)) {
                        sb.append('C');
                    } else {
                        sb.append('J');
                    }
                }
                out.println(String.format("Case #%s: %s", t + 1, sb));
            }
        }
    }

    private static class Job implements Comparable<Job> {
        private final int start;
        private final int end;
        private final int idx;

        public Job(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Job o) {
            return start - o.start;
        }
    }

}
