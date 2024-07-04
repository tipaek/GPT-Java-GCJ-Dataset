
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	int t;
	Scanner s;
	int U;
	Random r = new Random();

	Set<Integer> usedChars = new HashSet<>();
	char[] secret = new char[10];
	Map<Character, Integer> secretToPosition = new HashMap<>();
	int[][] counts = new int[10][U];// letter position
	Map<Character, Integer> countsUnk = new HashMap<>(); 
	Set<Character> allChars = new HashSet<>();

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		U = s.nextInt();
		choseSecret();
		bestSolve();

		// read input and solve
		//System.out.println("Case #" + t + ": ");
	}

	long tenAtU() {
		long f = 1;
		for (int i = 0; i < U; i++) {
			f *= 10;
		}
		return f;
	}

	private void bestSolve() {
		
		int queries = 10000;
		long tenAtU = tenAtU();
		for (int i = 0; i < queries; i++) {
//			long m = ThreadLocalRandom.current().nextLong(tenAtU);
//			long n = ThreadLocalRandom.current().nextLong(m+1)+1;
//			String qConv = convert(n);
			s.next();
			String qConv = s.next();
			allChars.add(qConv.charAt(qConv.length()-1));
			if(qConv.length() == U) {
				char leftMost = qConv.charAt(0);
				if(!countsUnk.containsKey(leftMost)) {
					countsUnk.put(leftMost, 0);
				}
				countsUnk.put(leftMost, countsUnk.get(leftMost)+1);
			}
		}
		StringBuilder guessedSecret = new StringBuilder();
		for(char c: allChars) {
			if(!countsUnk.containsKey(c)) {
				guessedSecret.append(c);
				break;
			}
		}
		for(int i=0;i<9;i++) {
			int max = 0;
			char best = ' ';
			for(Map.Entry<Character,Integer> entry : countsUnk.entrySet()) {
				if(entry.getValue() > max) {
					max = entry.getValue();
					best = entry.getKey();
				}
			}
			guessedSecret.append(best);
			countsUnk.remove(best);
		}
		//System.out.println(secret);
		System.out.println("Case #" + t + ": "+guessedSecret);
		
		
	}


	private String convert(long q) {
		StringBuilder sb = new StringBuilder();
		if (q == 0) {
			return "" + secret[0];
		}
		while (q != 0) {
			int digit = (int) (q % 10);
			sb.append(secret[digit]);
			q = q / 10;
		}
		return sb.reverse().toString();
	}

	private void choseSecret() {
		int count = 0;
		while (count < 10) {
			int rand = r.nextInt(26);
			if (!usedChars.contains(rand)) {
				usedChars.add(rand);
				secret[count++] = (char) ('A' + rand);
			}
		}
//		System.out.print("Secret: ");
//		for (char c : secret) {
//			System.out.print(c);
//		}
//		System.out.println();

		for (int i = 0; i < 10; i++) {
			secretToPosition.put(secret[i], i);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//new Solution(0, s).solve();

		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}
//
		s.close();
	}

}
