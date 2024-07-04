import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int nbTestCases = sc.nextInt();
		final int nbBits = sc.nextInt();
		for(int t = 1 ; t <= nbTestCases ; ++t) {
			testCase(new IO(sc), nbBits); //Ignore the 'Y' returned
		}
		sc.close();
	}
	
	public static boolean testCase(IO io, int nbBits) throws Exception {
		final boolean odd = (nbBits % 2) == 1; //maybe useful ?
		final Bit[] answer = new Bit[nbBits];
		for(int offset = 0 ; offset < nbBits ; ++offset) {
			do {
				answer[offset] = io.queryBit(offset);
			} while(!answer[offset].safe);
		}
		return io.guessBits(answer);
	}
	
	private static class Bit {
		public final int value;
		public final boolean safe;
		
		public Bit(int value, boolean safe) {
			this.value = value;
			this.safe = safe;
		}
		
		public Bit complement() {
			return new Bit(1-value, safe);
		}
	}
	
	private static class IO {
		private final static int MAX_BQ = 150;
		private final Scanner sc;
		private int counter;
		
		public IO(Scanner sc) {
			this.sc = sc;
			this.counter = 0;
		}
		
		public boolean canQueryBit() {
			return counter < MAX_BQ;
		}
		
		public Bit queryBit(int offset) throws Exception {
			if(!canQueryBit()) {
				throw new IllegalArgumentException("Max number of queries exceeded: " + MAX_BQ);
			}
			int rawValue = Integer.valueOf(
				send(String.valueOf(offset+1)) //1 as index basis
			);
			return new Bit(rawValue, (counter % 10) != 1);
		}
		
		public boolean guessBits(Bit[] bits) throws Exception {
			StringBuilder answer = new StringBuilder();
			for(Bit bit : bits) {
				answer.append(bit.value);
			}
			return "Y".equals(send(answer.toString()));
		}
		
		private String send(String request) throws Exception {
			++counter;
			System.out.println(request);
			System.out.flush();
			String response = sc.next();
			if("N".equals(response)) {
				throw new IllegalArgumentException("Judge returned 'N' on query: " + request);
			}
			return response;
		}
		
	}
	
}
