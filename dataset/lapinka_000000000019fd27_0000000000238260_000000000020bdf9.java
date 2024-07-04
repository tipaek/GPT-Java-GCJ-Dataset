import java.util.*;

public class Solution {//Code Jam quals 2020, Parenting Partnering Returns
	Scanner sc;
	public class Seq{
		TreeMap<Integer,Integer> pts;
		Seq() {
			pts=new TreeMap<>();
			}
		public boolean insert (int x, int y) {
			if ((pts.size()==0)||(y<=pts.firstKey())||(x>=pts.get(pts.lastKey()))) {
				pts.put(x, y);
				return true;
			}
			if (pts.higherKey(y-1)==null) return false;
			int nextst=pts.higherKey(y-1);
			int prevst=pts.lowerKey(nextst);
			if (pts.get(prevst)<=x) {
				pts.put(x, y);
				return true;
			}
			else return false;
		}
	}
	
	public String findSeq(int N, int[][] act) {
		StringBuilder res= new StringBuilder();
		Seq seqC=new Seq();
		Seq seqJ=new Seq();
		for (int i=0; i<N; i++) {
			boolean add=seqC.insert(act[i][0], act[i][1]);
			if (add) {
				res.append('C');
			} else {
				add=seqJ.insert(act[i][0], act[i][1]);
				if (add) res.append('J');
				else return "IMPOSSIBLE";
			}
		}
		
		return res.toString();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			int N=sol.sc.nextInt();
			sol.sc.nextLine();
			int[][] act = new int[N][2];
			for (int i=0; i<N; i++) {
				act[i][0]=sol.sc.nextInt();
				act[i][1]=sol.sc.nextInt();
				sol.sc.nextLine();
			}
			System.out.println("Case #"+t+": "+sol.findSeq(N,act));			
		}
		
		 
	}
}
