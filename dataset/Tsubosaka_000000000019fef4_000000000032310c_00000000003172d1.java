import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int solveSmall(int N , int D , long A[]){
		Arrays.sort(A);
		if(D == 2){
			for(int i = 0 ; i < N - 1; ++i){
				if(A[i] == A[i + 1]){
					return 0;
				}
			}
			return 1;
		}
		// D == 3
		for(int i = 0 ; i < N - 2; ++i){
			if(A[i] == A[i + 1] && A[i] == A[i + 2]){
				return 0;
			}
		}
		for(int i = 0 ; i < N - 1; ++i){
			if(A[i] == A[i + 1] && i + 2 < N){
				return 1;
			}		
		}
		for(int i = 0 ; i < N - 1; ++i){
			for(int j = i + 1 ; j < N ; ++j){
				if(2 * A[i] == A[j]){
					return 1;
				}
			}
		}
		return D - 1;
	}
	static int solve(int N , int D , long A[]){
		if(D <= 3){
//			return solveSmall(N , D , A);
		}
		if(N > 300){
//			return D - 1;
		}
		Arrays.sort(A);
		int ret = D - 1;
		for(int P = 1 ; P <= D ; ++P){
			for(int n = 0 ; n < N ; ++n){
				long an = A[n];
				List<Long> lst = new ArrayList<Long>();
				List<Long> lst2 = new ArrayList<Long>();
				for(long a : A){
					if((a * P) % an == 0){
						long m = (a * P) / an;
						lst.add(m);
					}else{
						long m = (a * P) / an;
						lst2.add(m);
					}
				}
				/*
				System.out.println(P+" "+n);
				System.out.println(lst);
				System.out.println(lst2);
				*/
				int r = 0;
				long d = 0;
				for(long l : lst){
					if(d + l <= D){
						r += l - 1;
						d = d + l;
					}else{
						long res = D - d;
						r += res;
						d = D;
					}
				}
				for(long l : lst2){
					if(d + l <= D){
						r += l;
						d = d + l;
					}else{
						long res = D - d;
						r += res;
						d = D;
					}
				}
				if(d >= D){
					ret = Math.min(ret, r);
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int cn = 1 ; cn <= T ; ++cn){
			int N = sc.nextInt();
			int D = sc.nextInt();
			long A[] = new long[N];
			for(int i = 0 ; i < N ; ++i){
				A[i] = sc.nextLong();
			}
			int ret = solve(N , D , A);
			System.out.printf("Case #%d: %d\n", cn , ret);
		}
	}
}
