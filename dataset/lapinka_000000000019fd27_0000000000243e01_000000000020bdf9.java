import java.util.*;

public class Solution {//Code Jam quals 2020, Parenting Partnering Returns
	Scanner sc;
	public class Rec{
		int end;
		int pos;
		Rec(int a, int b){
			end=a;
			pos=b;
		}
	}
	public String findSeq(int N, int[][] act) {
		TreeMap<Integer, ArrayList<Rec>> stpoints=new TreeMap<>();
		for (int i=0; i<N; i++)
			if (stpoints.containsKey(act[i][0])) {
				if (stpoints.get(act[i][0]).size()>1) return "IMPOSSIBLE";
				stpoints.get(act[i][0]).add(new Rec(act[i][1],i));
			} else {
				ArrayList<Rec> tmp = new ArrayList<Rec>();
				tmp.add(new Rec(act[i][1],i));
				stpoints.put(act[i][0], tmp);
			}
		char[] answer = new char[N];
		int endC=0;
		int endJ=0;
		for (int stp : stpoints.keySet()) {
			for (int i=0; i<stpoints.get(stp).size(); i++) {
				if (endC<=stp) {
					answer[stpoints.get(stp).get(i).pos]='C';
					endC=stpoints.get(stp).get(i).end;
				} else if (endJ<=stp) {
					answer[stpoints.get(stp).get(i).pos]='J';
					endJ=stpoints.get(stp).get(i).end;
				} else return "IMPOSSIBLE";
					
			}
		}
		return new String(answer);
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
