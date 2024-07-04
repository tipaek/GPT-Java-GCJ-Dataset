import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			long L = in.nextInt();
			long R = in.nextInt();

			String res = solve(L,R);			
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

	public static String solve (long l, long r) {
		long k = 0;

		// egalise stacks
		if (l != r) {
			long diff = Math.abs(l-r);
			// find the number		
			long a = 0;
			long b = (long)Math.ceil(Math.sqrt(10*diff))+1;
			while (a<b) {
				long mid = (a+b)/2;
				long sum = (mid*(mid+1))/2;
				if (sum <= diff && sum <= Math.max(l, r))
					a = mid+1;
				else
					b = mid;
			}
			k = a;
			if (l>r)
				l -= (k*(k+1))/2;
			else
				r -= (k*(k+1))/2;
		}		

		// do the remaining (alternate)
		if (r > l) {
			if (k+1>r)
				return String.format("%d %d %d", k,l,r);
			r -= ++k;
		}
		// start from left
		long a = 1;
		long b = (long)Math.ceil(Math.sqrt(10*(l+r)))+1;
		while (a<b) {
			long mid = (a+b)/2;
			long totalL = ((mid+1)/2)*(k+1+k+(mid%2==0?mid-1:mid))/2;
			long totalR = ((mid/2)*(k+2+k+(mid/2)*2))/2;
			if (totalL > l || totalR > r) {
				b = mid;
			} else {
				a = mid+1;
			}
		}
		a--;
		l -= ((a+1)/2)*(k+1+k+(a%2==0?a-1:a))/2;
		r -= ((a/2)*(k+2+k+(a/2)*2))/2;
		k += a;
		
		return String.format("%d %d %d", k,l,r);
	}
	
}
