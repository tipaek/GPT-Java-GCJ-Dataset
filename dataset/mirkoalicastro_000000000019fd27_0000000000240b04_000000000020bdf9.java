import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final char JAMIE = 'J';
    private static final char CAMERON = 'C';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static class Job implements Comparable<Job> {
        int from, to;
        Job(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(to, o.to);
        }

        boolean isCompatibleWith(List<Job> jobs) {
            if (jobs.isEmpty())
                return true;
            Job last = jobs.get(jobs.size() - 1);
            return from >= last.to;
        }

        @Override
        public String toString() {
            return "[" + from + ", " + to + "]";
        }
    }

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final StringBuilder out = new StringBuilder();
        final int testCases = scanner.nextInt();
        for (int t=1; t<=testCases; t++) {
            final int n = scanner.nextInt();
            List<Job> jobs = new ArrayList<>(n);
            for (int i=0; i<n; i++) {
                jobs.add(new Job(scanner.nextInt(), scanner.nextInt()));
            }
            String sol = solve(jobs);
            out.append("Case #").append(t).append(": ")
                .append(sol).append(' ')
                .append('\n');
        }
        System.out.print(out.toString());
    }

    private static String solve(List<Job> jobs) {
        Collections.sort(jobs);
        List<Job> j = new LinkedList<>();
        List<Job> c = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Job job: jobs) {
            if (job.isCompatibleWith(j)) {
                j.add(job);
                sb.append(JAMIE);
            } else if (job.isCompatibleWith(c)) {
                c.add(job);
                sb.append(CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }
        return sb.toString();
    }

}