import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class IndexCompare implements Comparator<Job> 
{ 
    public int compare(Job thiss, Job that) 
    { 
        if(thiss.jobId < that.jobId) {
			return -1;
		}
		else if(thiss.jobId > that.jobId) {
			return 1;
		}
        return 0;
    } 
} 
class Job implements Comparable<Job> {
	
	public Job(int jobId,int st,int et) {
		this.jobId = jobId;
		this.st = st;
		this.et = et;
	}
	int jobId;
	int st;
	int et;
	Person assigendTo;
	boolean isCompleted = false;
	@Override
	public int compareTo(Job that) {
		if(this.st < that.st) {
			return -1;
		}
		else if (this.st > that.st) {
			return 1;
		}
		return 0;
	}
}

class Person {
	public Person(String name) {
		this.name = name;
	}
	String name;
	boolean isBusy = false;
}

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		String res = "";
		 for (int i = 1; i <= t; i++) {
			 String resTemp = "";
			 int noOfJobs = in.nextInt();
			 List<Job> jobs = new ArrayList<>();
			 for(int j=0;j<noOfJobs;j++) {
				 int st = in.nextInt();
				 int et = in.nextInt();
				 Job job = new Job(j,st,et);
				 jobs.add(job);
			 }
			 
			 Collections.sort(jobs);
			 
			 List<Person> persons = getPersonList();
			 
			 List<Job> startedJobs = new ArrayList<>();
			 
			 int lastAssigendJobPos = 0;
			 boolean isExceptionOccured = false;
			 for(int time=0;time<1440;time++) {
				 if(lastAssigendJobPos == jobs.size()) {
					 break;
				 }
				 Job currentJob = jobs.get(lastAssigendJobPos);
				 
				 for(Job startedJob :startedJobs) {
					 
					 if(startedJob.et == time && !startedJob.isCompleted) {
						 startedJob.isCompleted = true;
						 startedJob.assigendTo.isBusy = false;
					 }
				 }
				 
				 if(currentJob.st == time) {
					 
					 Person person = getAvailablePerson(persons);
					 if(person != null) {
						 currentJob.assigendTo = person;
						 person.isBusy = true;
						 startedJobs.add(currentJob);
						 lastAssigendJobPos ++;
					 }
					 else {
						 isExceptionOccured = true;
						 break;
					 }
				 }
			 }
			 
			 if(isExceptionOccured) {
				 resTemp = resTemp + "Case #" + i + ": IMPOSSIBLE";
			 }
			 else {
				 Collections.sort(startedJobs,new IndexCompare());
				 String assigenedOrder = "";
				 for(Job startedJob : startedJobs) {
					 assigenedOrder = assigenedOrder + startedJob.assigendTo.name;
				 }
				 resTemp = resTemp + "Case #" + i + ": "+assigenedOrder;
			 }
			 
			 res = res + resTemp + "\n";
	     }
		 System.out.println(res);
	}
	
	
	private static Person getAvailablePerson(List<Person> persons) {
		for(Person person :persons) {
			if(!person.isBusy) {
				return person;
			}
		}
		return null;
	}


	private static List<Person> getPersonList() {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("C"));
		persons.add(new Person("J"));
		
		return persons;
	}
}