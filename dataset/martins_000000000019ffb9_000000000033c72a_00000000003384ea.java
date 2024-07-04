import java.util.*;
import java.io.*;
import java.math.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int test = 1;
		while(T-- > 0) {
			BigInteger L = BigInteger.valueOf(sc.nextLong());
			BigInteger R = BigInteger.valueOf(sc.nextLong());
			BigInteger start;
			if(L.compareTo(R) >= 0) { // L > R, find first i such that L <= R
				BigInteger d = L.subtract(R);
				BigInteger a = BigInteger.ZERO, b = BigInteger.valueOf(1000000000000000000L);
				while(b.subtract(a).compareTo(BigInteger.ONE) > 0) {
					BigInteger c = a.add(b).divide(BigInteger.valueOf(2));
					if(sum(c).compareTo(d) > 0) b = c;
					else a = c;
				}
				start = b;
				L = L.subtract(sum(start));
			}
			else{
				BigInteger d = R.subtract(L);
				BigInteger a = BigInteger.ZERO, b = BigInteger.valueOf(1000000000000000000L);
				while(b.subtract(a).compareTo(BigInteger.ONE) > 0) {
					BigInteger c = a.add(b).divide(BigInteger.valueOf(2));
					if(sum(c).compareTo(d) >= 0) b = c;
					else a = c;
				}
				start = b;
				R = R.subtract(sum(start));
				if(R.compareTo(L) >= 0) {
					start = start.add(BigInteger.ONE);
					L = L.subtract(start);
				}
			}
			//L < R
			BigInteger finish;
			if(start.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
				if(L.compareTo(BigInteger.ZERO) > 0) {
					BigInteger a = start.divide(BigInteger.valueOf(2)), b = BigInteger.valueOf(1000000000000000000L).divide(BigInteger.valueOf(2));
					while(b.subtract(a).compareTo(BigInteger.ONE) > 0) {
						BigInteger c = a.add(b).divide(BigInteger.valueOf(2));
						if(sumevensrange(start, c.multiply(BigInteger.valueOf(2))).compareTo(L) > 0) b = c;
						else a = c;
					}
					finish = b.multiply(BigInteger.valueOf(2));
				}
				else {
					finish = start;
				}
				L = L.subtract(sumevensrange(start, finish));
				R = R.subtract(sumoddsrange(start.subtract(BigInteger.ONE), finish.subtract(BigInteger.ONE)));
				if(L.compareTo(BigInteger.ZERO) < 0) {
					L = L.add(finish);
					finish = finish.subtract(BigInteger.ONE);
				}
				if(R.compareTo(BigInteger.ZERO) < 0) {
					R = R.add(finish);
					finish = finish.subtract(BigInteger.ONE);
				}
			}
			else{
				if(L.compareTo(BigInteger.ZERO) > 0) {
					BigInteger a = start.divide(BigInteger.valueOf(2)), b = BigInteger.valueOf(1000000000000000000L).divide(BigInteger.valueOf(2));
					while(b.subtract(a).compareTo(BigInteger.ONE) > 0) {
						BigInteger c = a.add(b).divide(BigInteger.valueOf(2));
						if(sumoddsrange(start, c.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE)).compareTo(L) > 0) b = c;
						else a = c;
					}
					finish = b.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
				}
				else{
					finish = start;
				}
				L = L.subtract(sumoddsrange(start, finish));
				R = R.subtract(sumevensrange(start.subtract(BigInteger.ONE), finish.subtract(BigInteger.ONE)));
				if(L.compareTo(BigInteger.ZERO) < 0) {
					L = L.add(finish);
					finish = finish.subtract(BigInteger.ONE);
				}
				if(R.compareTo(BigInteger.ZERO) < 0) {
					R = R.add(finish);
					finish = finish.subtract(BigInteger.ONE);
				}
			}
			System.out.printf("Case #%d: %s %s %s\n", test++, finish, L, R);
		}

	}
	static BigInteger sum(BigInteger c) {
		return c.multiply(c.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
	}
	static BigInteger sumoddsrange(BigInteger a, BigInteger b) { //both are odd, a is exclusive
		BigInteger a2 = a.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
		BigInteger b2 = b.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
		return b2.multiply(b2).subtract(a2.multiply(a2));
	}
	static BigInteger sumevensrange(BigInteger a, BigInteger b) {
		BigInteger a2 = a.divide(BigInteger.valueOf(2));
		BigInteger b2 = b.divide(BigInteger.valueOf(2));
		BigInteger large = b2.multiply(b2.add(BigInteger.ONE));
		BigInteger small = a2.multiply(a2.add(BigInteger.ONE));
		return large.subtract(small);
	}

}
