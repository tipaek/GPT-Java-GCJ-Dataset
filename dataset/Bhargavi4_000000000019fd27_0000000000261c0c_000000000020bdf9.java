import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String tests = br.readLine();
		if(tests == null)return;

		int t = Integer.parseInt(tests);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=t;i++) {
			sb.append("case #"+i).append(": ");
			String in = br.readLine();
			if(in == null)return;

			int n = Integer.parseInt(in);
			Task[] tks = new Task[n];
			char[] tasks = new char[n];

			for(int k = 0 ;k<n;k++) {

				String task = br.readLine();
				int[] times = Stream.of(task.split(" ")).mapToInt(y -> Integer.parseInt(y)).toArray();
				tks[k] = new Task(times[0],times[1],k,null);
			}
			
			
			Arrays.sort(tks,new Comparator<Task>() {
				@Override
				public int compare(Task o1, Task o2) {
					
					return o1.start - o2.start;
				}

				
			});
			
			
            int c=0;
            int j=0;
            boolean isPosible=true;
			for(int k=0;k<tks.length;k++) {
					
				if(c == 0 || c <= tks[k].start) {
					tks[k].person="C";
					c = tks[k].end;
				}
				else if(j <= tks[k].start) {
					tks[k].person="J";
					j=tks[k].end;
				}else {
					isPosible=false;
				}
				
			}
			
			
			for(int k=0;k<tks.length;k++) {
				
				if(tks[k].person != null && (j == 0 || j < tks[k].start)) {
					tks[k].person="J";
					j = tks[k].end;
				}
				
			}
			
			
			Arrays.parallelSort(tks, (t1,t2) -> t1.task-t2.task);
			
			if(isPosible) {
				for(Task p : tks) {
					sb.append(p.person);
				}
			}else {
				sb.append("IMPOSSIBLE");
			}
			
			sb.append("\n");
		}
         System.out.println(sb.toString());
	}

	private static boolean findOverlaps(Task[] tks, char[] tasks) {

		for(int i =0;i<tks.length;i++) {
			boolean[] isTrue = new boolean[tasks.length];
			for(int j=i-1;j>=0;j--) {
				if(isOverLap(tks[i],tks[j])) {
					if(isTrue[i] && tasks[j] == tasks[i]) {
						return false;
					}
					tasks[i] = tasks[j] == 'C' ? 'J' : 'C';
					isTrue[i] = true;
					
				}
				
			}
			
			if(tasks[i] == 0) {
				tasks[i] = 'C';
			}
			
		}
		

		return true;
	}
	
	static boolean isOverLap(Task t1,Task t2) {
		
		if((t1.start > t2.start && t1.start < t2.end) || (t1.end > t2.start && t1.end < t2.end) ) {
			return true;
		}
		return false;
	}



	static class Task{

		int start;
		int end;
		int task;
		String person;

		Task(int s,int e,int t,String person){
			this.start=s;
			this.end=e;
			this.task=t;
			this.person = person;
		}

		
	}

}
