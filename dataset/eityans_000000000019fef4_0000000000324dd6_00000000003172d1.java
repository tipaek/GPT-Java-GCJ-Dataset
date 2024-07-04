

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			
			int N = Integer.parseInt(sc.next());
			int D = Integer.parseInt(sc.next());
			int ans = D-1;
			long[] A = new long[N];
			for(int i=0; i<N; i++)A[i] = Long.parseLong(sc.next());
			Arrays.sort(A);
			
			long tmp = A[0];
			int cnt = 0;
			int max_cnt = 0;
			for(int i=0; i<N; i++){
				if(tmp == A[i]){
					cnt++;
				}else{
					max_cnt = Math.max(max_cnt, cnt);
					cnt = 1;
					tmp = A[i];
				}
			}
			max_cnt = Math.max(max_cnt, cnt);
			if(max_cnt >= D){
				ans = 0;
			}else if (max_cnt >= D-1){
				ans = 1;
			}else {
			
				boolean hasHalf = false;
				for(int i=0; i<N; i++){
					for(int j=i+1; j<N; j++){
						if(A[i] * 2 == A[j]){
							hasHalf = true;
							break;
						}
					}
					if(hasHalf)break;
				}
				ans = hasHalf? 1 : 2;
				if(D == 2)ans = 1;
			}
			
			System.out.println("Case #"+(t+1)+": " + ans);

		}
		
		
		sc.close();
		return;
	}

	
}
