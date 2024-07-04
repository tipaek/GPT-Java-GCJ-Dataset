import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();
			long[] xs = new long[N], ys = new long[N];
			for (int i = 0; i < N; i++) {
				xs[i] = in.nextLong();
				ys[i] = in.nextLong();
			}
			long ans = 1;
			HashSet<String> slopes = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long num = xs[i] - xs[j];
					long den = ys[i] - ys[j];
					if (den < 0) {
						num *= -1;
						den *= -1;
					}
					if (num == 0) {
						den = 1;
					}
					long gcd = gcd(num,den);
					num /= gcd;
					den /= gcd;
					
					String key = num + "/" + den;
//					System.out.println(key);
					slopes.add(key);
				}
			}
			
			for (String key : slopes) {
//				System.out.println("key=" + key);
				String[] vals = key.split("/");
				int dx = Integer.parseInt(vals[0]);
				int dy = Integer.parseInt(vals[1]);
				// dot with norm?
				HashMap<Long,Integer> cnts = new HashMap<>();
				for (int i=0;i<N;i++) {
					long diag = xs[i]*dy + ys[i]*dx;
//					System.out.println("found on diag" + diag);
					cnts.put(diag, cnts.getOrDefault(diag, 0)+1);
				}
				
				long cur= 0;
				int excess = 0;
//				System.out.println("slope=" + key);
				for(long diag : cnts.keySet()) {
					int cnt = cnts.get(diag);
//					System.out.println(diag + ": " + cnts);
					if (cnt > 1) {
						cur += cnt;
					} else {
						excess++;
					}
				}
				
				ans = Math.max(ans,cur + Math.min(excess, 2));
				
			}
			System.out.printf("Case #%d: %d\n", t, ans);

		}
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
