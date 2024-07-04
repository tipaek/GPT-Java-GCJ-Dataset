import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int x = 1; x <= T; ++x) {
			int N = in.nextInt();
			Map<Integer,Integer> CTime = new HashMap<>();
			Map<Integer,Integer> JTime = new HashMap<>();
			StringBuffer sb = new StringBuffer();
			int i=0;
			for (;i<N;i++){
				boolean isImpossible = false;
				int S = in.nextInt();
				int E = in.nextInt();
				if (!isImpossible && canAssign(CTime,S,E)){
					sb.append('C');
					CTime.put(S, E);
				} else if (!isImpossible && canAssign(JTime,S,E)){
					sb.append('J');
					JTime.put(S, E);
				} else {
					sb = new StringBuffer();
					sb.append("IMPOSSIBLE");
					isImpossible = true;
				}
			}
			System.out.println("Case #" + x + ": " + sb.toString());
		}
	}
	
	private static boolean canAssign(Map<Integer,Integer> time, int s, int e){
		Set<Integer> keys = time.keySet();
		for(int So:keys){
			int Eo = time.get(So);
			if(isOverLappingTask(s,e,So,Eo)){
				return false;
			}
		}
		return true;
	}
	
	private static boolean isOverLappingTask(int s1, int e1, int s2, int e2){
		if(s1>=e2 || s2>=e1) return false;
		return true;
	}
	
}
