

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			int X = Integer.parseInt(sc.next());
			int Y = Integer.parseInt(sc.next());
			char[] A = sc.next().toCharArray();
			int N = A.length;
			int ans = 1001;
			for(int i=0; i<N; i++){
				int time = i+1;
				switch(A[i]){
					case 'S':
						Y -= 1;
						break;
					case 'N':
						Y += 1;
						break;
					case 'W':
						X -= 1;
						break;
					case 'E':
						X += 1;
						break;
				}
				int need_time = Math.abs(X) + Math.abs(Y);
				if(time>=need_time){
					ans = Math.min(ans, time);
				}
			}
			System.out.println("Case #"+(t+1)+": " + ((ans < 1001)? ans : "IMPOSSIBLE"));

		}
		
		
		sc.close();
		return;
	}

	
}
