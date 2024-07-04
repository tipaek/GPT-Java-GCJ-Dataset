import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job implements Comparable<Job> {
    Integer index;
    Person person;
    Integer startTime;
    Integer endTime;

    public Job(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Job[startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    @Override
    public int compareTo(Job other) {
        return this.startTime.compareTo(other.startTime);
    }
}

class JobSortingByIndex implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return j1.index.compareTo(j2.index);
    }
}

class Person {
    String name;
    Job currentJob;

    public Person(String name) {
        this.name = name;
    }

    public boolean canAcceptNewJob(Job newJob) {
        if (newJob == null) return false;
        if (currentJob == null || currentJob.endTime <= newJob.startTime) {
            currentJob = newJob;
            return true;
        }
        return false;
    }
}

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static StringBuilder assignJobs(Job[] jobs) {
        Arrays.sort(jobs);

        Person c = new Person("C");
        Person j = new Person("J");

        if (jobs.length > 0) {
            c.currentJob = jobs[0];
            jobs[0].person = c;
        }

        for (int i = 1; i < jobs.length; i++) {
            if (c.canAcceptNewJob(jobs[i])) {
                jobs[i].person = c;
            } else if (j.canAcceptNewJob(jobs[i])) {
                jobs[i].person = j;
            } else {
                return new StringBuilder(IMPOSSIBLE);
            }
        }

        Arrays.sort(jobs, new JobSortingByIndex());

        StringBuilder result = new StringBuilder(jobs.length);
        for (Job job : jobs) {
            result.append(job.person.name);
        }
        return result;
    }

    public static void solve(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(scanner.nextInt(), scanner.nextInt(), i);
        }

        StringBuilder result = new StringBuilder("Case #").append(caseNumber).append(": ");
        result.append(assignJobs(jobs));

        System.out.println(result.toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            solve(scanner, i);
        }
    }
}