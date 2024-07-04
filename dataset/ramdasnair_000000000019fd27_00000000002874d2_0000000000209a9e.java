import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();
		int b = input.nextInt();
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

			while ( queries < 150 || sets >= b) {
				for (int i = sets + 1; i <= sets + 5; i++) {
					//Checking first+i element
					System.out.println(i);
					queries++;
					String outFromFirst = input.next();

					if (queries > 10 && queries % 10 == 1) {
						//Quantum fluctuation happened
						boolean reversed = false;
						boolean complemented = false;
						if (sameIndex > -1) {
							int curValue = bits[sameIndex];
							System.out.println(sameIndex);
							queries++;
							out = input.next();
							int newValue = Integer.valueOf(out);
							if (curValue != newValue)
								complemented = true;
						}

						if (diffIndex > -1) {
							int curValue = bits[diffIndex];
							System.out.println(sameIndex);
							queries++;
							out = input.next();
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
								bits[b-u] = tmp;
							}
						}
					}
					bits[i] = Integer.valueOf(outFromFirst);

					//Checking last-i element
					System.out.println(b - i + 1);
					queries++;
					out = input.next();
					bits[b-i+1] = Integer.valueOf(out);

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

			String output = input.next();
			if ("Y".equals(output)) {
				continue;
			} else {
				return;
			}
		}

	}
}
