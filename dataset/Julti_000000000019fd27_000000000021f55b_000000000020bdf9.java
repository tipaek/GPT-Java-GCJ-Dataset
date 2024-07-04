import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			ArrayList<Task> tasks = new ArrayList<Task>();
			String[] v = new String[n];
			for (int j = 0; j < n; j++) {
				int si = s.nextInt();
				int fi = s.nextInt();
				Task ti = new Task(si, fi,j);
				tasks.add(ti);
			}
			order(tasks);
			ArrayList<Task> cam = new ArrayList<Solution.Task>();
			ArrayList<Task> jam = new ArrayList<Solution.Task>();
			String[] sol=new String[n];
			boolean isimpossible=false;
			for (int j = 0; j < tasks.size(); j++) {
				if(cam.isEmpty()) {
					cam.add(tasks.get(j));
					sol[tasks.get(j).index]="C";
				}else {
					if(tasks.get(j).start>=cam.get(cam.size()-1).end) {
						cam.add(tasks.get(j));
						sol[tasks.get(j).index]="C";
					}else {
						if(jam.isEmpty()) {
							jam.add(tasks.get(j));
							sol[tasks.get(j).index]="J";
						}else {
							if(tasks.get(j).start>=jam.get(jam.size()-1).end) {
								jam.add(tasks.get(j));
								sol[tasks.get(j).index]="J";
							}else {
								isimpossible=true;
							}
						}
						
					}
				}
			}
			if(isimpossible) {
				System.out.print("Case #"+(i+1)+": IMPOSSIBLE");
			}else {
				System.out.print("Case #"+(i+1)+": ");
				for (int j2 = 0; j2 < sol.length; j2++) {
					System.out.print(sol[j2]);
				}
			}
			System.out.println();
		}
	}
	private static void order(List<Task> persons) {

	    Collections.sort(persons, new Comparator() {

	        public int compare(Object o1, Object o2) {

	            Integer x1 = ((Task) o1).start;
	            Integer x2 = ((Task) o2).start;
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) {
	               return sComp;
	            } 

	            Integer y1 = ((Task) o1).end;
	            Integer y2 = ((Task) o2).end;
	            return y1.compareTo(y2);
	    }});
	}
	static class Task {
		int start;
		int end;
		int index;
		public Task(int si,int fi,int index) {
			this.start=si;
			this.end=fi;
			this.index=index;
		}
	}

}
