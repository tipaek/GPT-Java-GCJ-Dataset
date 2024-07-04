import java.util.Scanner;

public class Solution {
	static long search(long L , long R){
		if(R - 1 < L){
			return 0;
		}
		for(long i = 1 ; ; ++i){
			long x = i * (i + 1) / 2;
			if(R - x < L){
				return i - 1;
			}
			long ni = i + 1000000;
			long x2 = ni * (ni + 1) / 2;
			if(R - x2 >= L){
				i = ni - 1;
			}
		}
	}
	static long search2(long ci , long L , long R){
		for(long i = 1 ; ; ++i){
			long lsum = i * (ci + (i - 1));
			long rsum = i * (ci + 1 + (i - 1));
			if(lsum > L || rsum > R){
				return i - 1;
			}
			long ni = i + 1000000;
			lsum = ni * (ci + (ni - 1));
			rsum = ni * (ci + 1 + (ni - 1));
			if(lsum <= L && rsum <= R){
				i = ni - 1;
			}
		}
	}
	static void solve(int t , long L , long R){
		long ci = 1;
		if(L >= R){
			long c = search(R, L);
			L -= c * (c + 1) / 2;
			ci = c + 1;
		}else{
			long c = search(L, R);
			R -= c * (c + 1) / 2;
			ci = c + 1;
		}
		if(L < ci && R < ci){
			ci--;
			System.out.printf("Case #%d: %d %d %d\n" , t , ci , L , R);			
			return ;
		}
//		System.out.println(ci+" "+L+" "+R);
		while(L >= ci || R >= ci){
			if(L >= R){
				L -= ci;
			}else{
				R -= ci;
				break;
			}
			if(L < ci + 1 && R < ci + 1){
				break;
			}
			ci++;
		}
		if(L >= ci || R >= ci){
			ci++;
			long c = search2(ci, L, R);
			long lsum = c * (ci + (c - 1));
			long rsum = c * (ci + 1 + (c - 1));
//			System.out.println(c+" "+lsum+" "+rsum);
			ci += 2 * c;
			L -= lsum;
			R -= rsum;
			while(L >= ci || R >= ci){
				if(L >= R){
					L -= ci;
				}else{
					R -= ci;
				}
				ci++;
			}
			ci--;
			System.out.printf("Case #%d: %d %d %d\n" , t , ci , L , R);
		}else{
			System.out.printf("Case #%d: %d %d %d\n" , t , ci , L , R);			
		}
	}
	static long[] solveNaive(long L , long R){
		long ci = 1;
		while(L >= ci || R >= ci){
			if(L >= R){
				L -= ci;
				System.out.println("L" + L+" "+R+" "+ci);
			}else{
				R -= ci;
				System.out.println("R" + L+" "+R+" "+ci);
			}
			ci++;
		}
		ci--;
		return new long[] { ci , L , R};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cn = sc.nextInt();
		for(int t = 1 ; t <= cn ; ++t){
			long L = sc.nextLong();
			long R = sc.nextLong();
			solve(t, L , R);
//			solveNaive(L, R);
		}
				
	}
}
