import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Job implements Comparable<Job> {
	
	public Integer startTime;
	public Integer endTime;
	
	public Job(int startTime, int endTime) {
		super();
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
		
		if(currentJob.startTime.intValue() < newJob.startTime.intValue() 
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
		
		StringBuilder builder = new StringBuilder(102400);
		
		Person c = new Person("C");
		Person j = new Person("J");
		
		// first job assignment
		if(jobs != null && jobs.length > 0) {
			c.currentJob = jobs[0];
			builder.append(c.name);
		}
		
		// further job assignment
		int length = jobs.length;
		for(int i = 1; i < length; i++) {
			if(c.isAbleToAcceptNewJob(jobs[i])) {
				builder.append(c.name);	
			} else if(j.isAbleToAcceptNewJob(jobs[i])) {
				builder.append(j.name);
			} else {
				return new StringBuilder(IMPOSSIBLE);
			}
		}
		return builder;
	}
	
	public static void solve(Scanner scanner, int caseNumber) {

		int n = scanner.nextInt();
		Job [] jobs = new Job[n];
		
		for(int i = 0; i < n; i++) {
			jobs[i] = new Job(scanner.nextInt(), scanner.nextInt());
		}
		
		Arrays.sort(jobs);
		
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