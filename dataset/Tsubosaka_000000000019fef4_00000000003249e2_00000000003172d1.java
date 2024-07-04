import java.util.Arrays;
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
			return solveSmall(N , D , A);
		}
		Arrays.sort(A);
		int ret = D - 1;
		for(int P = 1 ; P <= D ; ++P){
			long AP[] = new long[N];
			for(int i = 0 ; i < N ; ++i){
				AP[i] = A[i] * P;
			}
			for(long an : A){
				int r = 0;
				long d = 0;
				long ls = 0;
				for(long apn : AP){
					long m = apn / an;
					if(apn % an == 0){
						if(d + m <= D){
							r += m - 1;
							d = d + m;
						}else{
							r += D - d;
							d = D;
							break;
						}
					}else{
						ls += m;
					}
				}
				if(d >= D){
					ret = Math.min(ret, r);
					continue;
				}
				if(d + ls >= D){
					ret = Math.min(ret, r + (int)(D - d));
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
