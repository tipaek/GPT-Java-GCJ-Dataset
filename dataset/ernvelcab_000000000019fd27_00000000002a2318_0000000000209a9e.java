import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] lineParts = bufferedReader.readLine().split(" ");
            final int numberOfCases = Integer.parseInt(lineParts[0]);
            final int totalBits = Integer.parseInt(lineParts[1]);
            final int halfTotalBits = totalBits / 2;

            for (int c = 1; c <= numberOfCases; c++) {
                final int[] bits = new int[totalBits];
                final boolean[] symmetric1 = new boolean[halfTotalBits];
                boolean allSymmetric = true;

                for (int pos = 0; pos < halfTotalBits; pos ++) {
                    System.out.println(pos);
					System.out.flush();
                    bits[pos] = Integer.parseInt(bufferedReader.readLine());

                    final int oppositePos = totalBits - pos - 1;
                    System.out.println(oppositePos);
					System.out.flush();
                    bits[oppositePos] = Integer.parseInt(bufferedReader.readLine());

                    symmetric1[pos] = (bits[pos] == bits[oppositePos]);
                    allSymmetric = allSymmetric && symmetric1[pos];
                }

                if (totalBits > 10) {
                    for (int pos = 0; pos < halfTotalBits; pos ++) {
                        System.out.println(pos);
						System.out.flush();
                        bits[pos] = Integer.parseInt(bufferedReader.readLine());

                        final int oppositePos = totalBits - pos - 1;
                        if (symmetric1[pos]) {
                            bits[oppositePos] = bits[pos];
                        } else {
                            bits[oppositePos] = (bits[pos] == 0) ? 1 : 0;
                        }
                    }

                    if (totalBits > 20) {
                        // TODO
                    }
                }

                final StringBuilder sb = new StringBuilder();
                for (int pos = 0; pos < totalBits; pos ++) {
                    sb.append(bits[pos]);
                }
                System.out.println(sb.toString());
				System.out.flush();

                final String result = bufferedReader.readLine();

                if (result.equals("N")) {
                    break;
                }
            }
        }
    }
}
