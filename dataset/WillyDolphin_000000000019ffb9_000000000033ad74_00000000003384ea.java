import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			long[] lr = new long[2];
			lr[0] = sc.nextLong();
			lr[1] = sc.nextLong();
			int s = 0;
			if(lr[1-s] > lr[s]) {
				s = 1-s;
			}
			long dif = lr[s] - lr[1-s];
			long k = (long) Math.sqrt(2*dif);
			while(k*(k+1) <= 2*dif) {
				k++;
			}
			lr[s] -= k*(k-1)/2;
			if(lr[0] >= lr[1]) {
				s = 0;
			}
			if(lr[s] == 0) {
				System.out.println("Case #"+i+": "+(k-1)+ " "+lr[0]+" "+lr[1]);
				return;
			}
//			System.out.println("Case #"+i+": "+(k-1)+ " "+lr[0]+" "+lr[1]);

			// lr[s] -- 1/2 * n * (2k+2n) = n*(k+n-1)
			// lr[1-s] -- (k+n)*n
			long x = 0;
			long y = (long) (2*Math.sqrt(lr[s]));
			while(y-x > 1) {
				long mid = (x+y)/2;
				if(mid *(mid+k-1) <= lr[s]) {
					x = mid;
				} else {
					y = mid;
				}
			}
//			System.out.println(x);
			long xx = 0;
			long yy = (long) (2*Math.sqrt(lr[1-s]));
			while(yy-xx > 1) {
				long mid = (xx+yy)/2;
				if(mid *(mid+k) <= lr[1-s]) {
					xx = mid;
				} else {
					yy = mid;
				}
			}
//			System.out.println(xx);
			lr[s] -= (x+k-1)*x;
			lr[1-s] -= (xx+k)*xx;
			k = k + x + xx -1;
			System.out.println("Case #"+i+": "+k+ " "+lr[0]+" "+lr[1]);
		}
	}
}
