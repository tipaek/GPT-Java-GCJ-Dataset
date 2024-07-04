import java.io.FileNotFoundException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	private enum Guess {
		MISS, HIT, CENTER, WRONG
	}

	private static final int maxR = 1000000000;
	private DecimalFormat df = new DecimalFormat("#0.0000000");
	private int A;
	private int B;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		A = scan.nextInt();
		B = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			solve(scan);
		});
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private void solve(Scanner scan) {
		for (int x = -5; x <= 5; x++) {
			for (int y = -5; y <= 5; y++) {
				System.out.println(x + " " + y);
				Guess guess = readGuess(scan);
				if (guess == Guess.CENTER)
					return;
				else if (guess == Guess.WRONG)
					System.exit(0);
			}
		}
	}
//	private void solve2(Scanner scan) {
//		// shoot from middle buttom up
//		BigInteger rSquare = BigInteger.valueOf(gap).multiply(BigInteger.valueOf(gap));
//		int gap = maxR - A;
//		int offsetButtom = 0;
//		for (; offsetButtom < gap; offsetButtom++) {
//			System.out.println("0 " + (offsetButtom - maxR));
//			Guess guess = readGuess(scan);
//			if (guess == Guess.CENTER)
//				return;
//			if (guess == Guess.HIT)
//				break;
//			else if (guess == Guess.WRONG)
//				System.exit(0);
//		}
//
//		// shoot from middle top down
//		int offsetTop = 0;
//		for (; offsetTop < gap; offsetTop++) {
//			System.out.println("0 " + (maxR - offsetTop));
//			Guess guess = readGuess(scan);
//			if (guess == Guess.CENTER)
//				return;
//			if (guess == Guess.HIT)
//				break;
//			else if (guess == Guess.WRONG)
//				System.exit(0);
//		}
//		deltaX = 
//		// calc expected center
//		// try 15*15 square around this
//
//		return null;
//	}
	
	
	private Guess readGuess(Scanner scan) {
		return Guess.valueOf(scan.nextLine().trim());
	}

// =================================================
	// Below are generic utility methods
	
	BigDecimal choose(final int N, final int K) {
		BigDecimal ret = BigDecimal.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigDecimal.valueOf(N-k))
	                 .divide(BigDecimal.valueOf(k+1));
	    }
	    return ret;
	}
}
