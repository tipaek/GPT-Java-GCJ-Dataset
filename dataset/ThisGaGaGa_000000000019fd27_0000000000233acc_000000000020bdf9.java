import java.io.*;
import java.util.*;
 class time implements Comparable<time>{
	int start;
	int end;
	int index;
	public time(int s, int e, int i) {
		start = s;
		end = e;
		index = i;
	}
	public int compareTo(time t) {
		if(start==t.start) return this.end-t.end;
		return this.start-t.start;
	}
	public boolean equals(time t) {
		
		return start == t.start&&end == t.end;
	}
	
}

public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			time[] t = new time[N];
			for(int j = 0; j<N; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				time temp = new time(start, end, j);
				t[j] = temp;
			}
			Arrays.sort(t);
			if(impossible(t)) System.out.println("Case #"+ (i+1)+ ": "+"IMPOSSIBLE");
			else {
				System.out.println("Case #"+ (i+1)+ ": "+solve(t));
			}
			
			
		}
	}
	public static boolean impossible(time[]t) {
		for(int i = 0; i<t.length-2; i++) {
			if(t[i].end>t[i+1].start&&t[i].end>t[i+2].start&&t[i+1].end>t[i+2].start) return true;
		}
		return false;
	}
	public static String solve(time[]t) {
		String str = "";
		boolean[] jt = new boolean[t.length];
		int jEnd = 0;
		for(int i = 0; i<t.length; i++) {
			if(jEnd<=t[i].start) {
				jEnd = t[i].end;
				jt[t[i].index] = true;
			}
		}
		for(boolean b:jt) {
			if(b) str+="J";
			else str+="C";
		}
		return str;
	}
	

}
