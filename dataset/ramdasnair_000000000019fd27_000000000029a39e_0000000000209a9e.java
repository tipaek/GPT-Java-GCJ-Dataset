import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		boolean debug = false;
		Scanner input = new Scanner(System.in);
		MockScan mockInput = new MockScan();

		int t, b = 0;

		if (debug) {
			t = 1;
			b = 20;
		} else {
			t = input.nextInt();
			b = input.nextInt();
		}

		for (int x = 0; x < t; x++ ) {
			StringBuilder result = new StringBuilder();

			int queries = 0;
			int sets = 0;

			int[] bits = new int[b+1];

			bits[0] = -1;
			for(int i=1; i <= b; i++) {
				bits[i] = 2;
			}

			String out = "";
			int sameIndex = -1;
			int diffIndex = -1;

			while ( queries <= 150 && sets < (b/2)) {
				//System.out.println("Set ");
				for (int i = sets + 1; i <= sets + 5; i++) {
					if (i > b/2) break;
					//Checking first+i element
					System.out.println(i);
					queries++;
					String outFromFirst = debug? mockInput.next(i): input.next();

					queries = checkForQuantumFlux(input, mockInput, debug, b, queries, bits, sameIndex, diffIndex);

					bits[i] = Integer.valueOf(outFromFirst);

					//Checking last-i element
					System.out.println(b - i + 1);
					queries++;
					String outFromLast = debug? mockInput.next(b-i+1): input.next();

					queries = checkForQuantumFlux(input, mockInput, debug, b, queries, bits, sameIndex, diffIndex);

					bits[b-i+1] = Integer.valueOf(outFromLast);

					//Figuring same Index
					if (sameIndex == -1) {
						if (bits[b-i+1] == bits[i]) {
							sameIndex = i;
						}
					}

					//Figuring different Index
					if (diffIndex == -1) {
						if (bits[b-i+1] != bits[i]) {
							diffIndex = i;
						}
					}
				}
				sets += 5;
			}
			for(int i=1; i <= b; i++) {
				result.append(bits[i]);
			}

			System.out.println(result);
			if (debug) {
				System.out.println(mockInput.printBinary() + "<= Result from server");
				System.out.println("Queries: " + queries);
			}
			String output = debug? mockInput.next(): input.next();
			if ("Y".equals(output)) {
				continue;
			} else {
				return;
			}
		}

	}

	private static int checkForQuantumFlux(Scanner input, MockScan mockInput, boolean debug, int b, int queries, int[] bits, int sameIndex, int diffIndex) {
		if (queries > 10 && queries % 10 == 1) {
			if (debug) {
				System.out.println("Quantum flux happened");
			}
			//Quantum fluctuation happened
			boolean reversed = false;
			boolean complemented = false;
			if (sameIndex > -1) {
				int curValue = bits[sameIndex];
				System.out.println(sameIndex);
				queries++;
				String out = debug? mockInput.next(sameIndex) : input.next();
				int newValue = Integer.valueOf(out);
				if (curValue != newValue)
					complemented = true;
			}

			if (diffIndex > -1) {
				int curValue = bits[diffIndex];
				System.out.println(diffIndex);
				queries++;
				String out = debug? mockInput.next(diffIndex) : input.next();
				int newValue = Integer.valueOf(out);

				if (complemented) {
					if (curValue == newValue) reversed = true;
				} else {
					if (curValue != newValue) reversed = true;
				}
			}

			if (complemented) {
				//Apply complement on local array
				for(int u=1; u <=b; u++) {
					if (bits[u] == 0) {
						bits[u] = 1;
					} else if (bits[u] == 1) {
						bits[u] = 0;
					}
				}
			}

			if (reversed) {
				//Apply reverse on local array
				for(int u=1; u <= (b/2); u++) {
					int tmp = bits[u];
					bits[u] = bits[b-u+1];
					bits[b-u+1] = tmp;
				}
			}
		}

		return queries;
	}

	private static class MockScan {

		public static int queries = 0;

		public static String binary = "11111011110111111111";//"11010110011011110001";

		private static String next(int i) {
			queries++;
			if (queries % 10 == 1 && queries > 10) {
				binary = "00000100001000000000";//complement

				//binary = "00000000010000100000";//complement and reversed
				//binary = "00101001100100001110";//complement
				//binary = "10001111011001101011";//reversed
				//binary = "01110000100110010100";//reversed complement
			}

			if (queries % 10 == 1 && queries > 20) {
				//binary = "11111111101111011111";//reversed
				//binary = "00101001100100001110";//complement
				//binary = "10001111011001101011";//reversed
				//binary = "01110000100110010100";//reversed complement
			}

			return "" + binary.charAt(i-1);
		}

		private static String next() {
			return "Y";
		}

		private static Integer nextInt() {
			return Integer.MIN_VALUE;
		}

		private static String printBinary() {
			return binary;
		}
	}

}
