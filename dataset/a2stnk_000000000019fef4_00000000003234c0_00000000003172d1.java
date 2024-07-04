import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}
	
	static void solve(Scanner sc) {
		
		int N = sc.nextInt();
		int D = sc.nextInt();
		
		long[] A = new long[N];
		for(int i=0; i<N; i++)
			A[i] = sc.nextLong();
		
		Arrays.sort(A);
		
		int ans = D-1;
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<=D; j++) {
				long gcd = gcd(A[i], j);
				long numerator = A[i]/gcd;
				long denominator = j/gcd;
				boolean[] used = new boolean[N];
				int served = 0;
				int cut = 0;
				for(int k=0; k<N; k++) {
					if(A[k]%numerator==0) {
						long capa = A[k]*denominator/numerator;
						if(served+capa<=D) {
							served += capa;
							cut += capa-1;
						} else {
							int demand = D-served;
							served += demand;
							cut += demand;
						}
						used[k]=true;
					}
				}
				for(int k=0; k<N; k++) {
					if(used[k])
						continue;
					long capa = A[k]*denominator/numerator;
					int demand = D-served;
					served += Math.min(capa, demand);
					cut += Math.min(capa, demand);
				}
				if(served==D)
					ans = Math.min(ans, cut);
			}
		}
		
		System.out.println(ans);
	}

	static long gcd(long a, long b) {
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}
}
