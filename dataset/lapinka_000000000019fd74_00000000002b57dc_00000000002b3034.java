import java.util.*;

public class Solution {//Code Jam round 1A 2020, Pattern Matching 
	Scanner sc;
	int min(int A, int B) {
		if (A<B) return A;
		return B;
	}
	public String findCom(int N, String[] patterns) {
		String [] start = new String[N];
		String [] end = new String[N];
		String maxS=new String();
		String maxE=new String();
		for (int i=0; i<N; i++) {
			int pos=patterns[i].indexOf('*');
			start[i]=patterns[i].substring(0,pos);
			end[i]=patterns[i].substring(pos+1);
			if (start[i].length()>maxS.length()) maxS=start[i];
			if (end[i].length()>maxE.length()) maxE=end[i];
		}
		for (int i=0; i<N; i++) {
			if (!maxS.substring(0,start[i].length()).equals(start[i])) return "*";
			if (!maxE.substring(maxE.length()-end[i].length()).equals(end[i])) return "*";
		}
		if (maxE.length()+maxS.length()<=10000) return maxS+maxE;
		return "*";
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			int N=sol.sc.nextInt();
			sol.sc.nextLine();
			String [] patterns = new String[N];
			for (int i=0; i<N; i++) {
				patterns[i]=sol.sc.nextLine();
			}
			System.out.println("Case #"+t+": "+sol.findCom(N,patterns));			
		}
		
		 
	}
}
