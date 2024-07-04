import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            jobs.add(new Job(start, end, i));
        }

        jobs.sort(Comparator.comparingInt(job -> job.start));

        int cEnd = 0;
        int jEnd = 0;
        char[] schedule = new char[n];
        boolean impossible = false;

        for (Job job : jobs) {
            if (job.start >= cEnd) {
                cEnd = job.end;
                schedule[job.index] = 'C';
            } else if (job.start >= jEnd) {
                jEnd = job.end;
                schedule[job.index] = 'J';
            } else {
                impossible = true;
                break;
            }
        }

        String result = impossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
        System.out.println();
    }

    private static class Job {
        int start;
        int end;
        int index;

        Job(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}