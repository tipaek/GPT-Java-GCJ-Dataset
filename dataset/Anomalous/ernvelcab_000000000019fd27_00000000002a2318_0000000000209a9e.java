import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] initialInput = bufferedReader.readLine().split(" ");
            int numberOfCases = Integer.parseInt(initialInput[0]);
            int totalBits = Integer.parseInt(initialInput[1]);
            int halfTotalBits = totalBits / 2;

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int[] bits = new int[totalBits];
                boolean[] symmetricBits = new boolean[halfTotalBits];
                boolean allSymmetric = true;

                for (int pos = 0; pos < halfTotalBits; pos++) {
                    System.out.println(pos);
                    System.out.flush();
                    bits[pos] = Integer.parseInt(bufferedReader.readLine());

                    int oppositePos = totalBits - pos - 1;
                    System.out.println(oppositePos);
                    System.out.flush();
                    bits[oppositePos] = Integer.parseInt(bufferedReader.readLine());

                    symmetricBits[pos] = (bits[pos] == bits[oppositePos]);
                    allSymmetric &= symmetricBits[pos];
                }

                if (totalBits > 10) {
                    for (int pos = 0; pos < halfTotalBits; pos++) {
                        System.out.println(pos);
                        System.out.flush();
                        bits[pos] = Integer.parseInt(bufferedReader.readLine());

                        int oppositePos = totalBits - pos - 1;
                        bits[oppositePos] = symmetricBits[pos] ? bits[pos] : 1 - bits[pos];
                    }

                    if (totalBits > 20) {
                        // Additional logic for more than 20 bits can be added here
                    }
                }

                StringBuilder resultBuilder = new StringBuilder();
                for (int bit : bits) {
                    resultBuilder.append(bit);
                }
                System.out.println(resultBuilder.toString());
                System.out.flush();

                String result = bufferedReader.readLine();
                if ("N".equals(result)) {
                    break;
                }
            }
        }
    }
}