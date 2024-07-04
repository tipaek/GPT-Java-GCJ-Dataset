import java.util.*;
import java.io.*;
import java.math.BigDecimal;
public class Solution {

	static void solve(int i, BigDecimal l, BigDecimal r) {
		BigDecimal inc = new BigDecimal("1");
		BigDecimal order = new BigDecimal("1");
		while(order.compareTo(l)<=0 || order.compareTo(r)<=0) {
			if (l.compareTo(r) >= 0) {
				l = l.subtract(order);
			} else {
				r = r.subtract(order);
			}
			order = order.add(inc);
		}
		order = order.subtract(inc);
		System.out.println("Case #" + i + ": " + order + " " + l + " " + r);
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			BigDecimal l = in.nextBigDecimal();
			BigDecimal r = in.nextBigDecimal();
			solve(i, l, r);
		}
		in.close();
	}

}
