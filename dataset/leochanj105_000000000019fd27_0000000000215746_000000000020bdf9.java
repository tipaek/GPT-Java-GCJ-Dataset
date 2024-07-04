
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt(), N, i, j, S, E;
		Task tasks[] = new Task[1000], curC, curJ, cur;
		boolean camaron[] = new boolean[1000];
		//String s;
		for(i = 0; i < T; i++) {
			N = input.nextInt();
			for(j = 0; j < N; j++) {
				S = input.nextInt();
				E = input.nextInt();
				tasks[j] = new Task(S, E, j);
			}
			curC = null;
			curJ = null;
			Arrays.sort(tasks, 0, N);
//			for(j = 0; j < N; j++) {
//				System.out.print("<" + tasks[j].start + "," + tasks[j].end + "> ");
//			}
//			System.out.println();
			for(j = 0; j < N; j++) {
				cur = tasks[j];
				if(!cur.conflict(curC)) {
					curC = cur;
					camaron[cur.num] = true;
				}
				else if(!cur.conflict(curJ)) {
					curJ = cur;
					camaron[cur.num] = false;
				} else {
					break;
				}
			}
			System.out.print("Case #" + (i + 1) + ": ");
			if(j < N) {
				System.out.println("IMPOSSIBLE");
			} else {
				for(j = 0; j < N; j++) {
					System.out.print(camaron[j] ? "C" : "J");
				}
				System.out.println();
			}
			
		}
		input.close();
	}

}

class Task implements Comparable<Task>{
	public int start, end, num;
	public Task(int s, int e, int n) {
		start = s;
		end = e;
		num = n;
	}
	
	@Override
	public int compareTo(Task t) {
		if(this.start > t.start) return 1;
		if(this.start < t.start) return -1;
		return 0;
	}
	
	public boolean conflict(Task t) {
		if(t == null) return false;
//		System.out.print("this: <" + this.start + "," + this.end + "> ");
//		System.out.println("before: <" + t.start + "," + t.end + "> ");
//		System.out.println((this.start < t.end) || (this.end > t.start));
		return (this.start < t.end);
	}
}
