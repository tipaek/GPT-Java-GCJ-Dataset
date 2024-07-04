import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String tests = br.readLine();
		if(tests == null)return;

		int t = Integer.parseInt(tests);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=t;i++) {
			String in = br.readLine();
			if(in == null)return;

			int n = Integer.parseInt(in);
			Task[] tks = new Task[n];
			char[] tasks = new char[n];

			for(int k = 0 ;k<n;k++) {

				String task = br.readLine();
				int[] times = Stream.of(task.split(" ")).mapToInt(y -> Integer.parseInt(y)).toArray();
				tks[k] = new Task(times[0],times[1]);
			}

			if(findOverlaps(tks,tasks)) {
				
				for(int k=0;k<tasks.length;k++) {
					if(tasks[k] == 0)tasks[k] = 'J';
				}
				
				sb.append("case #"+i).append(": ").append(String.valueOf(tasks));
			}else {
				sb.append("case #"+i).append(": ").append("IMPOSSIBLE");
			}
			sb.append("\n");
			
		}
         System.out.println(sb.toString());
	}

	private static boolean findOverlaps(Task[] tks, char[] tasks) {
   
		
		int[] count = new int[tasks.length];

		for(int i =0;i<tks.length;i++) {
			
			for(int j=i-1;j>=0;j--) {
				if(isOverLap(tks[i],tks[j])) {
					
					if(tks[i].start > tks[j] && tks[i].end < tks[j].end) {

						int v = count[j];
						count[j] = v+1;
					}
					if(tasks[j] == 0) {
						tasks[i] = 'C';
					}else {
						tasks[i] = tasks[j] == 'C' ? 'J':'C';
					}
				}
				
			}
			
		}
		
		for(int t=0;t<count.length;t++) {
			if(count[t] >= 2)return false;
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

		Task(int s,int e){
			this.start=s;
			this.end=e;
		}

		
	}

}
