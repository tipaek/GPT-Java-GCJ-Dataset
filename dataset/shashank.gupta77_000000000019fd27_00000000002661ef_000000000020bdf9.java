import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        int t = scan.nextInt();
        for(int tc = 1;tc<=t;++tc) {
            int n = scan.nextInt();
            List<Task> tasks = new ArrayList<>();
            for(int i=0;i<n;++i) {
                int s = scan.nextInt();
                int e = scan.nextInt();
                tasks.add(new Task(s,e,i));
            }
            Collections.sort(tasks);
            System.out.println(String.format("Case #%d: %s", tc,solve(tasks)));
        }
    }
    private static String solve(List<Task> tasks) {
        Task c = new Task(0,0,0);
        Task j = new Task(0,0,0);
        char[] ans = new char[tasks.size()];
        for(Task task : tasks) {
        	//System.out.print(task);
            if(c.end <= task.start) {
                ans[task.index] = 'C';
                //System.out.println(" Owner: [C]");
                c = task;
            } else if(j.end <= task.start) {
                ans[task.index] = 'J';
                //System.out.println(" Owner: [J]");
                j = task;
            } else {
            	//System.out.println(" Owner: [IMPOSSIBLE]");
            	return "IMPOSSIBLE";
            }
        }
        return new String(ans);
    }
    
    private static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;
        
        public Task(int s, int e, int i) {
            this.start = s;
            this.end = e;
            this.index = i;
        }
        
        @Override
		public int compareTo(Task other) {
			if (this.start == other.start) {
				return this.end - other.end;
			}
			return this.start - other.start;
		}
		
		public String toString() {
			return String.format("Start: [%d] End: [%d] Index: [%d]", start,end,index);
		}
    }
}