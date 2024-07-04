import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

class Job implements Comparable<Job> {
    public Integer startTime;
    public Integer endTime;

    public Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Job [startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    @Override
    public int compareTo(Job job) {
        return this.startTime.compareTo(job.startTime);
    }
}

class Person {
    public String name;
    public Job currentJob;

    public Person(String name) {
        this.name = name;
    }

    public boolean canAcceptNewJob(Job newJob) {
        if (newJob == null) return false;

        if (currentJob == null) {
            currentJob = newJob;
            return true;
        }

        boolean overlaps = (currentJob.startTime < newJob.startTime && currentJob.endTime > newJob.startTime) ||
                           (currentJob.startTime < newJob.endTime && currentJob.endTime > newJob.endTime);

        if (overlaps) {
            return false;
        } else {
            currentJob = newJob;
            return true;
        }
    }
}

public class Solution {
    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static StringBuilder assignJobs(Job[] jobs) {
        StringBuilder builder = new StringBuilder(102400);
        Person c = new Person("C");
        Person j = new Person("J");

        if (jobs != null && jobs.length > 0) {
            c.currentJob = jobs[0];
            builder.append(c.name);
        }

        for (int i = 1; i < jobs.length; i++) {
            if (c.canAcceptNewJob(jobs[i])) {
                builder.append(c.name);
            } else if (j.canAcceptNewJob(jobs[i])) {
                builder.append(j.name);
            } else {
                return new StringBuilder(IMPOSSIBLE);
            }
        }
        return builder;
    }

    public static void solve(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(scanner.nextInt(), scanner.nextInt());
        }

        StringBuilder builder = new StringBuilder(102400);
        builder.append("Case #").append(caseNumber).append(": ");
        builder.append(assignJobs(jobs));

        System.out.println(builder.toString());
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            solve(scanner, i);
        }
    }
}