import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_cases = in.nextInt();
		for(int test=1; test<=test_cases; test++) {
			int tasks = in.nextInt();
			Job[] jobs = new Job[tasks];
			for(int i=0; i<tasks; i++) 
				jobs[i] = new Job(in.nextInt(),in.nextInt(),i);
			
			Arrays.sort(jobs,new Comparator<Job>() {

				@Override
				public int compare(Job o1, Job o2) {
					return o1.start-o2.start;
				}
			});
			
			int c=0;
			int j=0;
			char[] assignee=new char[tasks];
			String ans="";
			
			for(int i=0;i<tasks;i++) {
				if(jobs[i].start>=c) {
					assignee[jobs[i].index]='C';
					c=jobs[i].end;
				}
				else if(jobs[i].start>=j) {
					assignee[jobs[i].index]='J';
					j=jobs[i].end;
				}
				else {
					ans="IMPOSSIBLE";
					break;
				}
			}
			if(ans.equals("IMPOSSIBLE"))
				System.out.println("Case #"+test+": "+ans);
			else
				System.out.println("Case #"+test+": "+(String.valueOf(assignee)));
		}

	}
	static class Job {
		int start;
		int end;
		int index;
		public Job(int a, int b,int c) {
			this.start = a;
			this.end = b;
			this.index=c;
		}
	}
}
