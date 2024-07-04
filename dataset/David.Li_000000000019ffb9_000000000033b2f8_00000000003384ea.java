import java.io.*;
import java.util.*;;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());

		for(int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			
			long[] ans = solve(l,r);
			System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
		}
	}
	
	public static long[] solve(long l, long r) {
		long[] toRet = new long[3];
		
		long diff = Math.abs(l-r);
		
		long times = (long)((Math.pow(8*diff+1, .5)-1)/2);
		long lS = times+1;
		long rS = times+2;
		
		//System.out.println(times);
		
		if(l >= r) {
			l -= (times)*(times+1)/2;
		}
		else {
			r -= (times)*(times+1)/2;
			
			if(l != r) {
				rS = times+1;
				lS = times+2;
			}
		}
		toRet[0] += times;

		long k = calc(rS,r);
		r -= (k+rS-1)*(k);
		toRet[0] += k;
		
		k = calc(lS,l);
		l -= (k+lS-1)*(k);
		toRet[0] += k;
		
		toRet[1] = l;
		toRet[2] = r;
		
		return toRet;
	}
	
	public static long calc(long start, long tot) {
		long b = start-1;
		long c = -tot;
		
		long ans = (long) ((-b + Math.pow(b*b-4*c, .5))/2);
		return ans;
	}
}
