import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = bufferedReader.readLine().split(" ");
            int numberOfCases = Integer.parseInt(input[0]);
            int totalBits = Integer.parseInt(input[1]);
            int halfTotalBits = totalBits / 2;

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int[] bits = new int[totalBits];
                boolean[] symmetric = new boolean[halfTotalBits];
                boolean allSymmetric = true;

                for (int pos = 0; pos < halfTotalBits; pos++) {
                    System.out.println(pos + 1);
                    System.out.flush();
                    bits[pos] = Integer.parseInt(bufferedReader.readLine());

                    int oppositePos = totalBits - pos - 1;
                    System.out.println(oppositePos + 1);
                    System.out.flush();
                    bits[oppositePos] = Integer.parseInt(bufferedReader.readLine());

                    symmetric[pos] = (bits[pos] == bits[oppositePos]);
                    allSymmetric &= symmetric[pos];
                }

                if (totalBits > 10) {
                    for (int pos = 0; pos < halfTotalBits; pos++) {
                        System.out.println(pos + 1);
                        System.out.flush();
                        bits[pos] = Integer.parseInt(bufferedReader.readLine());

                        int oppositePos = totalBits - pos - 1;
                        bits[oppositePos] = symmetric[pos] ? bits[pos] : (bits[pos] == 0 ? 1 : 0);
                    }

                    if (totalBits > 20) {
                        // Additional logic for cases where totalBits > 20 can be implemented here
                    }
                }

                StringBuilder resultBuilder = new StringBuilder();
                for (int bit : bits) {
                    resultBuilder.append(bit);
                }
                System.out.println(resultBuilder.toString());
                System.out.flush();

                String result = bufferedReader.readLine();
                if (result.equals("N")) {
                    break;
                }
            }
        }
    }
}