import java.util.*;

public class Solution {//Code Jam round 1C 2020, Oversized Pancake Choppers, smallest testcase
	Scanner sc;
	public int findCutsperSize(int N, int D, TreeMap<Long,Integer> count, long sizeN, long sizeD) {
		int res=0;
		int remP=D;
		for (long ang : count.keySet())
			if ((ang*sizeD)%sizeN==0) {
				long M=ang*sizeD/sizeN;
				if (remP<=M*count.get(ang)) {
					if (remP%M==0) {
						res=res+(int)((M-1)*(remP/M));
						return res;
					} else {
						res=(int)((M-1)*(remP/M));
						remP=remP-(int)(M*(remP/M));
						res=res+remP;
						return res;
					}
					
				} else {
					remP=remP-(int)(M*count.get(ang));
					res=res+(int)((M-1)*count.get(ang));
				}
			}
		for (long ang : count.keySet())
			if ((ang>sizeN/sizeD)&&((ang*sizeD)%sizeN!=0)) {
				for (int j=1; j<=count.get(ang); j++) {
					if (ang*sizeD/sizeN>=remP) {
						return res+remP;
					} else {
						remP=remP-(int)(ang*sizeD/sizeN);
						res=res+(int)(ang*sizeD/sizeN);
					}
				}
			}
		return D-1;
	}
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
		int res=D-1;
		for (long ang:count.keySet()) {
			for (int i=1; i<D-1; i++) {
				int curcuts=findCutsperSize(N, D, count, ang, i);
				if (curcuts<res) res=curcuts;
			}
		}
		return res;
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
