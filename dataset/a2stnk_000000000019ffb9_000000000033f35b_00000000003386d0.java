import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
		long[] x = new long[N];
		long[] y = new long[N];
		for(int i=0; i<N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		if(N<=4) {
			System.out.println(N);
			return;
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				HashMap<Long, Integer> map = new HashMap<>();
				if(x[i]==x[j]) {
					for(int k=0; k<N; k++) {
						Integer count = map.get(x[k]);
						if(count==null) {
							count = 0;
						}
						map.put(x[k], count+1);
					}
				} else {
					for(int k=0; k<N; k++) {
						long v1 = y[k]*(x[j]-x[i])-x[k]*(y[j]-y[i]);
						long v2 = x[j]-x[i];
						long gcd = gcd(v1, v2);
						v1 /= gcd;
						v2 /= gcd;
						long v = (v1*rev(v2))%MOD;
						Integer count = map.get(v);
						if(count==null) {
							count = 0;
						}
						map.put(v, count+1);
					}
				}
				Integer[] v = map.values().toArray(new Integer[0]);
				Arrays.sort(v);
				
				int one = 0;
				int odd = 0;
				for(int size : v) {
					if(size%2==1) {
						if(size==1) {
							one++;
						} else {
							odd++;
						}
					}
				}
				
				one += odd%2;
				
				ans = Math.max(ans, N-Math.max(0, one-2));
				
			}
		}
		
		System.out.println(ans);
	}
	
	static long gcd(long a, long b) {
		return a==0 ? b : gcd(b%a, a);
	}
	final static long MOD = 1000000007;
	static long rev(long a) {
		return pow(a, MOD-2);
	}
	static long pow(long a, long b) {
		long ans = 1;
		while(b>0) {
			if((b&1)!=0) {
				ans = (ans * a)%MOD;
			}
			b>>=1;
			a = (a*a)%MOD;
		}
		return ans;
	}
}
