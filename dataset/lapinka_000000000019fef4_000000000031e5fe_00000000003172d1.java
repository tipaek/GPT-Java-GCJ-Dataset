import java.util.*;

public class Solution {//Code Jam round 1C 2020, Oversized Pancake Choppers, smallest testcase
	Scanner sc;
	
	public int findCuts(int N, int D, long[] A) {
		TreeMap<Long,Integer> count=new TreeMap<>();
		int maxC=1;
		long maxPos=A[0];
		for (int i=0; i<N; i++)
			if (count.containsKey(A[i])) {
				count.put(A[i], count.get(A[i])+1);
				if (maxC<count.get(A[i])) {
					maxC=count.get(A[i]);
					maxPos=A[i];
					}
				}
			else count.put(A[i], 1);
		if (maxC>=D) return 0;
		if (D==2) return 1;
		if (D==3) {
			if ((maxC==2)&&(count.higherKey(maxPos)!=null)) return 1;
			for (long ang:count.keySet())
				if (count.containsKey(2*ang)) return 1;
		}
		return D-1;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			int N=sol.sc.nextInt();
			int D=sol.sc.nextInt();
			sol.sc.nextLine();
			long[] A= new long[N];
			for (int i=0; i<N; i++) A[i]=sol.sc.nextLong();
			sol.sc.nextLine();
			System.out.println("Case #"+t+": "+sol.findCuts(N,D,A));
			
		}
		
		 
	}
}
