import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    static class TestCase {
        int n;
        Job[] jobs;

        TestCase(int n, Job[] jobs) {
            this.n = n;
            this.jobs = jobs;
        }
    }

    static class Job {
        int start, finish, id;

        Job(int start, int finish, int id) {
            this.start = start;
            this.finish = finish;
            this.id = id;
        }
    }

    static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job a, Job b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public static void findSchedule(int index, int n, Job[] jobs) {
        Arrays.sort(jobs, new JobComparator());
        int lastEndTimeC = -1;
        int lastEndTimeJ = -1;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                schedule.append('C');
                lastEndTimeC = jobs[i].finish;
            } else {
                if (jobs[i].start >= jobs[i - 1].finish) {
                    if (schedule.charAt(i - 1) == 'C') {
                        schedule.append('C');
                        lastEndTimeC = jobs[i].finish;
                    } else {
                        schedule.append('J');
                        lastEndTimeJ = jobs[i].finish;
                    }
                } else {
                    if (schedule.charAt(i - 1) == 'C') {
                        if (lastEndTimeJ == -1 || jobs[i].start >= lastEndTimeJ) {
                            schedule.append('J');
                            lastEndTimeJ = jobs[i].finish;
                        } else {
                            schedule.setLength(0);
                            schedule.append("IMPOSSIBLE");
                            break;
                        }
                    } else {
                        if (lastEndTimeC == -1 || jobs[i].start >= lastEndTimeC) {
                            schedule.append('C');
                            lastEndTimeC = jobs[i].finish;
                        } else {
                            schedule.setLength(0);
                            schedule.append("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
        }

        if (!schedule.toString().equals("IMPOSSIBLE")) {
            char[] result = new char[n];
            for (int i = 0; i < n; i++) {
                result[jobs[i].id] = schedule.charAt(i);
            }
            schedule = new StringBuilder(new String(result));
        }

        System.out.println("Case #" + (index + 1) + ": " + schedule);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TestCase[] testCases = new TestCase[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Job[] jobs = new Job[n];
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int finish = sc.nextInt();
                jobs[j] = new Job(start, finish, j);
            }
            testCases[i] = new TestCase(n, jobs);
        }

        for (int i = 0; i < t; i++) {
            findSchedule(i, testCases[i].n, testCases[i].jobs);
        }
    }
}