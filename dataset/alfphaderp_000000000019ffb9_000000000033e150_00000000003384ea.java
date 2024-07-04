
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T;
	
	BigInteger L, R;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int merp = 1; merp <= T; merp++) {
			Solution s = new Solution();
			s.solve(merp);
		}
		
		in.close();
	}
	
	BigInteger sumUpTo(BigInteger i) {
		return i.multiply(i.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
	}
	
	BigInteger helper(BigInteger i) {
		BigInteger sum = sumUpTo(i.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2))).multiply(BigInteger.valueOf(2));
		if(i.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
			return sum;
		} else {
			return sum.add(i.divide(BigInteger.valueOf(2)));
		}
	}
	
	boolean satisfies(BigInteger i, BigInteger small, BigInteger large) {
		BigInteger smallerCost = helper(i), largerCost = helper(i.add(BigInteger.ONE));
		
		
//		System.out.println(smallerCost + "\t" + largerCost);
//		System.out.println((smallerCost.compareTo(small) <= 0) + "\t" + (large.compareTo(largerCost) <= 0));
		
		return smallerCost.compareTo(small) <= 0 && largerCost.compareTo(large) <= 0;
	}
	
	void solve(int c) {
		readInput();
		
		BigInteger small, large;
		if(L.compareTo(R) > 0) {
			small = R;
			large = L;
		} else {
			small = L;
			large = R;
		}
		
		BigInteger minGuess = BigInteger.ONE;
		BigInteger maxGuess = BigInteger.TEN;
		
		while(minGuess.compareTo(maxGuess) <= 0) {
			BigInteger guess = minGuess.add(maxGuess).divide(BigInteger.valueOf(2));
			if(satisfies(guess, small, large)) {
				minGuess = guess.add(BigInteger.ONE);
			} else {
				maxGuess = guess.subtract(BigInteger.ONE);
			}
		}
		
		System.out.println("Case #" + c + ": " + maxGuess + " " + maxGuess + " " + maxGuess);
	}
	
	void readInput() {
		L = new BigInteger(in.next());
		R = new BigInteger(in.next());
	}
}
