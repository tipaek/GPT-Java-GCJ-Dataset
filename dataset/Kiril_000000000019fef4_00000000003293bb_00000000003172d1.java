
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		final InputStream is;
		if (args.length == 0) {
			is = System.in;
		} else {
			is = new FileInputStream(args[0]);
		}
		final Scanner s = new Scanner(new BufferedInputStream(is));
		final PrintStream pw = System.out;
		final int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			pw.print("Case #");
			pw.print(i);
			pw.print(": ");
			solution(s, pw);
		}
		pw.flush();
	}
	
	static long gcd(long n1, long n2) {
	    if (n2 == 0) {
	        return n1;
	    }
	    return gcd(n2, n1 % n2);
	}

	private static void solution(Scanner s, PrintStream pw) {
		int n = s.nextInt();
		int d = s.nextInt();
		long[] a = new long[n];
		
		Map<Long, Integer> group = new HashMap<>();
		long max = 0;
		long maxKey = 0;
		long g = 0;
		for(int i = 0; i < n; i++) {
			a[i] = s.nextLong();
			long k = group.merge(a[i], 1, (b, c) -> b + c);
			g = gcd(a[i], g);
			if(k > max) {
				max = k;
				maxKey = a[i];
			}
		}
		if(n == 1) {
			pw.println(d - 1);
			return;
		} else if(max >= d) {
			pw.println(0);
			return;
		} else if(d == 2) {
			pw.println(1);
			return;
		} 
		for(Map.Entry<Long, Integer> e : group.entrySet()) {
			Integer c1 = group.get(e.getKey() * 2);
			if(c1 != null) {
				pw.println(1);
				return ;
			}
		}
		
		
		// TODO Auto-generated method stub
		pw.println(2);
	}
}
