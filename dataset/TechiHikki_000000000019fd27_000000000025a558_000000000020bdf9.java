import java.util.*;
public class Solution {
	
	public static class Comp implements Comparator<int[]> {
		int index;
		public Comp(int ind) {
			this.index = ind;
		}
	    public int compare(int[] a, int[] b) {
	        if(a[index] < b[index]) {
	            return -1;
	        } 
	        else if(a[index] > b[index]){
	            return 1;
	        } 
	        else{
	        	if(a[index+1] < b[index+1]) {
	        		return -1;
	        	}
	        	else if(a[index+1] > b[index+1]) {
	        		return 1;
	        	}
	        	else {
	        		return 0;
	        	}
	        }
	    }
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = stdIn.nextInt();
			int C = 0;
			int J = 0;
			String ans = "Case #" +(i+1)+ ": ";
			boolean flag = true;
			int[][] act = new int[N][4];
			for(int j = 0; j < N; j++) {
				act[j][0] = stdIn.nextInt();
				act[j][1] = stdIn.nextInt();
				act[j][2] = j;
				act[j][3] = 0;
			}
			Arrays.sort(act, new Comp(0));
			for(int j = 0; j < N; j++) {
				if(C <= act[j][0]) {
					C = act[j][1];
					act[j][3] = 0;
				}
				else if(J <= act[j][0]) {
					J = act[j][1];
					act[j][3] = 1;
				}
				else {
					ans += "IMPOSSIBLE";
					flag = false;
					break;
				}
			}
			Arrays.sort(act, new Comp(2));
			if(flag) {
				for(int j = 0; j < N; j++) {
					if(act[j][3] == 0) ans += "C";
					else ans += "J";
				}
				System.out.println(ans);
			}
			else System.out.println(ans);
		}

	}

}