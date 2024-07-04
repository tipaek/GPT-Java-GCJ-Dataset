

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			int N = 10000;
			int U = Integer.parseInt(sc.next());
			int[] M = new int[N];
			int[][] cnt = new int[U][26];
			for(int i=0; i<N; i++){
				M[i] = Integer.parseInt(sc.next());
				char[] A = sc.next().toCharArray();
				int d = A.length;
				for(int j=d-1; j>=0; j--){
					char c = A[j];
					int U_d = d-j-1;
					int ind = (int)(c) - (int)('A');
					cnt[U_d][ind]++;
				}
			}
			/*
			for(int i=0; i<26; i++){
				System.out.print((char)((int)('A')+i)+"\t");
			}
			System.out.println();
			
			for(int[] cn : cnt){
				for(int c : cn){
					System.out.print(c+"\t");
				}
				System.out.println();
			}
			*/
			
			int[] cnt_ = cnt[U-1];
			int[][] key = new int[10][2];
			int ind = 0;
			for(int i=0; i<26; i++){
				if(cnt[0][i] != 0){
					key[ind][0] = i;
					key[ind][1] = cnt[U-1][i];
					ind++;
				}
			}
			Arrays.sort(key, (a,b) -> Integer.compare(a[1], b[1]));
			
			/*
			for(int[] c : key){
				System.out.print((char)(c[0] + (int)('A'))+"\t");
			}
			*/
			StringBuilder ans = new StringBuilder();
			ans.append((char)(key[0][0] + (int)('A')));
			for(int i=9; i>0; i--){
				ans.append((char)(key[i][0] + (int)('A')));
			}
			System.out.println("Case #"+(t+1)+": " + ans);

		}
		
		
		sc.close();
		return;
	}

	
}
