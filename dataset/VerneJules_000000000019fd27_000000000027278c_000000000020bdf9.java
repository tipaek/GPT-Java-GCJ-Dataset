import java.io.*;
import java.util.*;

public class Solution{
	class Sched{
		int id = 0;
		int start = 0;
		int end = 0;
		//~ ArrayList<Integer> conflicts = new ArrayList<Integer>();
		public Sched(int id, int start, int end){
			this.id = id;
			this.start = start;
			this.end = end;
		}
		boolean notConflicts(Sched s){
			return this.end <= s.start || this.start >= s.end;
		}
	}
	public static void main(String[] args){
		Solution sol = new Solution();
		sol.start(args);
	}
	public void start(String[] args){
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0; i < t; i++){
			String output = "";
			boolean imp = false;
			int n = s.nextInt();
			Sched[] sc = new Sched[n];
			ArrayList<Integer> cam = new ArrayList<Integer>();
			ArrayList<Integer> jay = new ArrayList<Integer>();
			char[] c = new char[n];
			for(int j = 0; j < n; j++){
				int start = s.nextInt();
				int end = s.nextInt();
				sc[j] = new Sched(j, start, end);
				boolean b = false;
				for(int job:cam){
					if(!sc[job].notConflicts(sc[j])){
						b = true;
						break;
					}
				}
				if(b){
					for(int job:jay){
						if(!sc[job].notConflicts(sc[j])){
							imp = true;
							break;
						}
					}
					if(!imp){
						jay.add(j);
						c[j] = 'J';
					}
				}else{
					cam.add(j);
					c[j] = 'C';
				}
				if(imp){
					output = "IMPOSSIBLE";
					break;
				}
			}
			if(!imp){
				output = String.valueOf(c);
			}
			System.out.println("Case #"+(i+1)+": "+output);
		}
	}
}