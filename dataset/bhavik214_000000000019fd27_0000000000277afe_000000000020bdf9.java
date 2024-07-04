import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job implements Comparable<Job> {
	
	public Integer index;
	public Person person;
	public Integer startTime;
	public Integer endTime;
	
	public Job(int startTime, int endTime, Integer index) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
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

class JobSortingByIndex implements Comparator<Job> {

	@Override
	public int compare(Job j1, Job j2) {
		return j1.index.compareTo(j2.index);
	}
	
}

class Person {
	
	public String name;
	public Job currentJob;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public boolean isAbleToAcceptNewJob(Job newJob) {
		
		if(newJob == null)
			return false;
		
		if(currentJob == null) {
			currentJob = newJob;
			return true;
		}
		
		if(currentJob.startTime.intValue() <= newJob.startTime.intValue() 
				&& currentJob.endTime.intValue() > newJob.startTime.intValue()) {
			return false;
		}
		currentJob = newJob;
		return true;
	}
}

public class Solution {
	
	public static final String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static StringBuilder assignJobs(Job [] jobs, Scanner scanner) {
		
		Arrays.sort(jobs);
		
		Person c = new Person("C");
		Person j = new Person("J");
		
		// first job assignment
		if(jobs != null && jobs.length > 0) {
			c.currentJob = jobs[0];
			jobs[0].person = c;
		}
		
		// further job assignment
		int length = jobs.length;
		for(int i = 1; i < length; i++) {
			if(c.isAbleToAcceptNewJob(jobs[i])) {
				jobs[i].person = c;
			} else if(j.isAbleToAcceptNewJob(jobs[i])) {
				jobs[i].person = j;
			} else {
				return new StringBuilder(IMPOSSIBLE);
			}
		}
		
		Arrays.sort(jobs, new JobSortingByIndex());

		StringBuilder builder = new StringBuilder(102400);
		for(int i = 0; i < length; i++) {
			builder.append(jobs[i].person.name);
		}
		
		return builder;
	}
	
	public static void solve(Scanner scanner, int caseNumber) {

		int n = scanner.nextInt();
		Job [] jobs = new Job[n];
		
		for(int i = 0; i < n; i++) {
			jobs[i] = new Job(scanner.nextInt(), scanner.nextInt(), i);
		}
		
		StringBuilder builder = new StringBuilder(102400);
		builder.append("Case #" + caseNumber + ": ");
		builder.append(assignJobs(jobs, scanner));
		
		System.out.println(builder.toString());
		System.out.flush();
	}
	
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		int t = scanner.nextInt();
		
		for(int i = 1; i <= t; i++) {
			solve(scanner, i);
		}
	}

}