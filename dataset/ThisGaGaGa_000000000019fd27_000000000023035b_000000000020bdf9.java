import java.io.*;
import java.util.*;
 class time implements Comparable<time>{
	int start;
	int end;
	public time(int s, int e) {
		start = s;
		end = e;
	}
	public int compareTo(time t) {
		return this.start-t.start;
	}
	public boolean equals(time t) {
		return start == t.start&&end == t.end;
	}
	
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			time[] t = new time[N];
			time[]t2 = new time[N];
			for(int j = 0; j<N; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				time temp = new time(start, end);
				t2[j] = temp;
				t[j] = temp;
			}
			Arrays.sort(t);
			if(impossible(t)) System.out.println("Case #"+ (i+1)+ ": "+"IMPOSSIBLE");
			else {
				System.out.println("Case #"+ (i+1)+ ": "+solve(t,t2));
			}
			
			
		}
	}
	public static boolean impossible(time[]t) {
		for(int i = 0; i<t.length-2; i++) {
			if(t[i].end>t[i+1].start&&t[i].end>t[i+2].start&&t[i+1].end>t[i+2].start) return true;
		}
		return false;
	}
	public static String solve(time[]t, time[]t2) {
		String str = "";
		boolean[] jt = new boolean[t.length];
		boolean[] temp = new boolean[t.length];
		int jEnd = 0;
		for(int i = 0; i<t.length; i++) {
			if(jEnd<=t[i].start) {
				jEnd = t[i].end;
				jt[i] = true;
			}
		}
		for(int i = 0; i<t.length; i++) {
			for(int j = 0; j<t.length; j++) {
				if(t[i].equals(t2[j])) {
					temp[j] = jt[i];
				}
			}
		}
		for(boolean b:temp) {
			if(b) str+="J";
			else str+="C";
		}
		return str;
	}

}
