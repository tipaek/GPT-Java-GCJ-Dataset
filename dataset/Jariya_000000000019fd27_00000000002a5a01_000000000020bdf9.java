import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static class Task implements Comparable<Task>{
		int start;
		int end;
		public int compareTo(Task o) {
			if(this.start==o.start) {
				return o.end-this.end;
			}
			return this.start-o.start;
		}
		public String toString() {
			return start+"-"+end+", ";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = sc.nextInt();
			
			for(int test=0; test< T; test++) {
				int N = sc.nextInt();
				Task[] arrTasks = new Task[N];
				for(int i=0; i<N; i++) {
					Task task = new Task();
					task.start = sc.nextInt();
					task.end = sc.nextInt();
					arrTasks[i] = task;
				}
				String y = solution(N, arrTasks);
				System.out.println("Case #"+(test+1)+": "+y);
				cFirst=!cFirst;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private final static String IMPOSSIBLE = "IMPOSSIBLE";
	private final static int[] workC = new int[1440];
	private final static int[] workJ = new int[1440];
	static boolean cFirst = true;
	private static String solution(int N, Task[] arrTasks) {
		StringBuffer sb = new StringBuffer();
		
		Arrays.fill(workC, 0);
		Arrays.fill(workJ, 0);
		Arrays.sort(arrTasks);
		for(int task=0; task<N; task++) {
			int sumC=0, sumJ=0;
			for(int time=arrTasks[task].start; time<arrTasks[task].end; time++) {
				sumC += workC[time];
				sumJ += workJ[time];
			}
			if(sumC == 0) {
				Arrays.fill(workC, arrTasks[task].start, arrTasks[task].end, 1);
				if(cFirst) {sb.append('C');} else {sb.append('J');}
			} else if(sumJ == 0) {
				Arrays.fill(workJ, arrTasks[task].start, arrTasks[task].end, 1);
				if(cFirst) {sb.append('J');} else {sb.append('C');}
			} else {
				
				return IMPOSSIBLE;
			}
			//System.out.print(arrTasks[task]);
		}
		return sb.toString();
	}
}