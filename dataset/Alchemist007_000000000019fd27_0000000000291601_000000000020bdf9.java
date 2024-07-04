import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int t = 0;
		while(++t <= T) {
			int N = scn.nextInt();
			int[] S = new int[N];
			int[] E = new int[N];
			for(int i = 0; i<N; i++) {
				S[i] = scn.nextInt();
				E[i] = scn.nextInt();
			}
			String res = getSchedule(S, E);
			System.out.println("Case #" + t + ": " + res);
		}

	}
	
	public static String getSchedule(int[] S, int[] E) {
		
		int[] sortS = new int[S.length];
		for(int i = 0; i<S.length; i++) {
			sortS[i] = S[i];
		}
		Arrays.sort(sortS);
		char[] res = new char[S.length];
		int C_end = 0, J_end = 0;
		for(int i = 0; i < sortS.length; i++) {
			int start = sortS[i];
			int idx;
			if(i!=0 && sortS[i] == sortS[i-1])
				idx = getIndex(S, start, 2);
			else
				idx = getIndex(S, start, 1);
			if(C_end <= start) {
				res[idx] = 'C';
				C_end = E[idx];
			}else if(J_end <= start) {
				res[idx] = 'J';
				J_end = E[idx];
			}else
				return "IMPOSSIBLE";
		}
		String rv = new String(res);
		return rv;
		
	}
	
	public static int getIndex(int[] arr , int item, int select) {
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == item)
				count++;
			if(count == select)
				return i;
		}
		return -1;
	}

}
