import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution {
	static BigInteger ZERO = BigInteger.ZERO;
	static BigInteger ONE = BigInteger.ONE;
	static BigInteger TWO = new BigInteger("2");
	static BigInteger stopped;
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();

		for (int ca = 1 ; ca <= T ; ca++) {
			BigInteger L = new BigInteger(sc.next()), R = new BigInteger(sc.next());
			BigInteger people = ZERO;
			boolean swapped = false;
			
			BigInteger[] stacks = new BigInteger[2];
			stacks[0] = L;
			stacks[1] = R;
			
			if (L.compareTo(R) == -1) {
				BigInteger temp = stacks[0];
				stacks[0] = stacks[1];
				stacks[1] = temp;
				swapped = true;
			} 
			
			BigInteger low = ZERO;
			BigInteger high = new BigInteger("1000000000000000000");
			BigInteger mid = ZERO;
			
			// find smallest n where [0] gets smaller than / equal [1]
			while (high.subtract(low).compareTo(ZERO) > 0) {
				mid = (high.add(low)).divide(TWO);
				BigInteger sum = sum(mid);
				if (stacks[0].subtract(sum).compareTo(stacks[1]) < 1) {
					high = mid;
				} else {
					low = mid.add(ONE);
				}
			}
			people = people.add(high);
			stacks[0] = stacks[0].subtract(sum(high));
			
			stopped = people;
			
			// priortize left
			if (stacks[0].compareTo(stacks[1]) == 0) {
				if (swapped) {
					BigInteger temp = stacks[0];
					stacks[0] = stacks[1];
					stacks[1] = temp;
					swapped = false;
				}
			}
			
			if (stacks[1].compareTo(stacks[0]) == 1) {
				BigInteger temp = stacks[0];
				stacks[0] = stacks[1];
				stacks[1] = temp;
				swapped = !swapped;
			}
			
			
			BigInteger leftN = ZERO, rightN = ZERO;
			// [0] even, [1] odd
			if (low.mod(TWO).compareTo(TWO) == 1) {
				leftN = binSearchEven(stacks[0], stopped.add(ONE));
				stacks[0] = stacks[0].subtract(sumEven(leftN, stopped.add(ONE)));
				
				rightN = binSearchOdd(stacks[1], stopped.add(TWO));
				stacks[1] = stacks[1].subtract(sumOdd(rightN, stopped.add(TWO)));
			}
			
			
			// [0] odd, [1] even
			else {
				leftN = binSearchOdd(stacks[0], stopped.add(ONE));
				stacks[0] = stacks[0].subtract(sumOdd(leftN, stopped.add(ONE)));
				
				rightN = binSearchEven(stacks[1], stopped.add(TWO));
				stacks[1] = stacks[1].subtract(sumEven(rightN, stopped.add(TWO)));
			}
			people = people.add(leftN);
			people = people.add(rightN);
			
			if (swapped) {
				BigInteger temp = stacks[0];
				stacks[0] = stacks[1];
				stacks[1] = temp;
			}
			
			out.printf("Case #%d: %s %s %s\n ", ca, people, stacks[0], stacks[1]);
		}
		out.close();
	}
/*
1
1 2	
 */
	static BigInteger sum(BigInteger n) {
		return n.multiply(n.add(ONE)).divide(TWO);
	}

	static BigInteger sumOdd(BigInteger n, BigInteger a) {
		return (n.multiply((TWO.multiply(a)).add((n.subtract(ONE)).multiply(TWO)))).divide(TWO);
	}
	
	static BigInteger sumEven(BigInteger n, BigInteger a) {
		return sumOdd(n,a.add(ONE)).subtract(n);
	}
	
	static BigInteger binSearchEven(BigInteger stack, BigInteger start) {
		BigInteger low = ZERO;
		BigInteger high = new BigInteger("1000000000000000000");
		BigInteger mid = ZERO;
		
		while (high.subtract(low).compareTo(ZERO) > 0) {
			mid = (high.add(low).add(ONE)).divide(TWO);
			BigInteger sum = sumEven(mid, start);
			if (stack.subtract(sum).compareTo(ZERO) == -1) {
				high = mid.subtract(ONE);
			} else {
				low = mid;
			}
		}
		
		return low;
	}
	
	static BigInteger binSearchOdd(BigInteger stack, BigInteger start) {
		BigInteger low = ZERO;
		BigInteger high = new BigInteger("1000000000000000000");
		BigInteger mid = ZERO;
		
		while (high.subtract(low).compareTo(ZERO) > 0) {
			mid = (high.add(low).add(ONE)).divide(TWO);
			
			BigInteger sum = sumOdd(mid, start);
			if (stack.subtract(sum).compareTo(ZERO) == -1) {
				high = mid.subtract(ONE);
			} else {
				low = mid;
			}
		}
		
		return low;
	}
	
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}
}