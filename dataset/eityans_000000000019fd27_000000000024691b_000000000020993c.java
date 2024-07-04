

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			int N = Integer.parseInt(sc.next());
			int[][] A = new int[N][N];
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					A[i][j] = Integer.parseInt(sc.next());
				}
			}
			
			int k = 0;
			int r = 0;
			int c = 0;
			for(int i=0; i<N; i++){
				k += A[i][i];
			}
			
			for(int i=0; i<N; i++){
				Set<Integer> set = new HashSet<>();
				for(int j=0; j<N; j++){
					set.add(A[i][j]);
				}
				if(set.size() != N)r++;
			}
			
			for(int i=0; i<N; i++){
				Set<Integer> set = new HashSet<>();
				for(int j=0; j<N; j++){
					set.add(A[j][i]);
				}
				if(set.size() != N)c++;
			}
			
			
			System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
		}
		
		
		sc.close();
		return;
	}
	

	
}
