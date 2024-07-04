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

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			time[] t = new time[N];
			time[] t2 = new time[N];
			for(int j = 0; j<N; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				time temp = new time(start, end, j);
				t[j] = temp;
				t2[j] = temp;
			}
			Arrays.sort(t);
			String str = solve(t);
			if(impossible(t, solve2(t))) System.out.println("Case #"+ (i+1)+ ": "+"IMPOSSIBLE");
			else {
				System.out.println("Case #"+ (i+1)+ ": "+str);
			}
			
			
		}
	}
	public static boolean impossible(time[]t, String str) {
		/*for(int i = 0; i<t.length-2; i++) {
			if(t[i].end>t[i+1].start&&t[i].end>t[i+2].start&&t[i+1].end>t[i+2].start) return true;
		}*/
		for(int i = 0; i<t.length-1; i++) {
			for(int j = i+1; j<t.length; j++) {
				if(t[i].end>t[j].start&&str.charAt(i)==str.charAt(j)) return true;
			}
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
	public static String solve2(time[]t) {
		String str = "";
		boolean[] jt = new boolean[t.length];
		int jEnd = 0;
		for(int i = 0; i<t.length; i++) {
			if(jEnd<=t[i].start) {
				jEnd = t[i].end;
				jt[i] = true;
			}
		}
		for(boolean b:jt) {
			if(b) str+="J";
			else str+="C";
		}
		return str;
	}
	

}
