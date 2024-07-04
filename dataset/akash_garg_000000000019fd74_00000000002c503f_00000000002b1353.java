import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		long[] pow = new long[33];
		pow[1] = 1;
		for(int x = 2; x <= 32; x++) {
			pow[x] = pow[x - 1] * 2;
		}
		for (int q = 1; q <= test_cases; q++) {
			System.out.print("Case #" + q + ": ");
			long n = in.nextLong();
			int val = 0;
			while(pow[val] <= n) {
				val++;
			}
			val--;
			for(int x = 1; x <= val; x++) {
				System.out.println(val +" " + x);
			}
			n -= pow[val];
			boolean flag = false;
	
			while(n != 0) {
				val--;
				if(pow[val] > n) {
					n--;
					if(flag)
						System.out.println(val+" "+1);
					else
						System.out.println(val+" "+val);
					continue;
				}
				if(flag) {
					for(int x = 1; x <= val; x++) {
						System.out.println(val +" " + x);
					}
				}
				else {
					for(int x = val; x >= 1; x--) {
						System.out.println(val +" " + x);
					}
				}
				flag =!flag;
				n -= pow[val];
			}
		}
	}

}