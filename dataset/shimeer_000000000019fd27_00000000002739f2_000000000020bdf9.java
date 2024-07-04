import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

class Job {
	int start;
	int end;
	
	Job(int s, int e){
		this.start = s;
		this.end = e;
	}
	boolean compareJob(Job j) {
		boolean isValid = false;
			if((this.start < j.start && this.start <= j.end) || this.start >= j.end) {
				isValid = true;
			} else {
				isValid = false;
				
			}
		return isValid;
	}
}

public class Solution {
	static String ans = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test=1; test<=t; test++) {
			int n = sc.nextInt();
			ArrayList<Job> list = new ArrayList<Job>();
			ArrayList<Job> C = new ArrayList<Job>();
			ArrayList<Job> J = new ArrayList<Job>();
			for(int i=0; i<n; i++) {
				list.add(new Job(sc.nextInt(), sc.nextInt()));
			}
			
			for (Job job : list) {
				if(C.size() == 0) {
					C.add(job);
					ans += "C";
					continue;
				}
				int flagC = 0;
				for (Job c : C) {
					if(job.compareJob(c)) {
						flagC = 1;
					} else {
						flagC = 0;
						break;
					}
				}
				if(flagC == 1) {
					C.add(job);
					ans += "C";
					continue;
				}
				
				if(J.size() == 0) {
					J.add(job);
					ans += "J";
					continue;
				}
				int flagJ = 0;
				for (Job j : J) {
					if(job.compareJob(j)) {
						flagJ = 1;
					} else {
						flagJ = 0;
						break;
					}
				}
				if(flagJ == 1) {
					J.add(job);
					ans += "J";
					continue;
				}
				
			}
			
			if(C.size() + J.size() != list.size()) {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + test + ": " + ans);				
			}
		}
	}
}
