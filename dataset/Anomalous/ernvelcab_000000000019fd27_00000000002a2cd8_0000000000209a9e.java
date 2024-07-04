import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int numberOfCases = Integer.parseInt(input[0]);
            int totalBits = Integer.parseInt(input[1]);
            int halfTotalBits = totalBits / 2;

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int[] bits = new int[totalBits];
                boolean[] isSymmetric = new boolean[halfTotalBits];
                boolean allSymmetric = true;

                for (int i = 0; i < halfTotalBits; i++) {
                    System.out.println(i + 1);
                    System.out.flush();
                    bits[i] = Integer.parseInt(reader.readLine());

                    int oppositeIndex = totalBits - i - 1;
                    System.out.println(oppositeIndex + 1);
                    System.out.flush();
                    bits[oppositeIndex] = Integer.parseInt(reader.readLine());

                    isSymmetric[i] = (bits[i] == bits[oppositeIndex]);
                    allSymmetric = allSymmetric && isSymmetric[i];
                }

                if (totalBits > 10) {
                    for (int i = 0; i < halfTotalBits; i++) {
                        System.out.println(i + 1);
                        System.out.flush();
                        bits[i] = Integer.parseInt(reader.readLine());

                        int oppositeIndex = totalBits - i - 1;
                        if (isSymmetric[i]) {
                            bits[oppositeIndex] = bits[i];
                        } else {
                            bits[oppositeIndex] = (bits[i] == 0) ? 1 : 0;
                        }
                    }

                    if (totalBits > 20) {
                        // Additional logic for cases where totalBits > 20 can be added here
                    }
                }

                StringBuilder resultBuilder = new StringBuilder();
                for (int bit : bits) {
                    resultBuilder.append(bit);
                }
                System.out.println(resultBuilder.toString());
                System.out.flush();

                String result = reader.readLine();
                if ("N".equals(result)) {
                    break;
                }
            }
        }
    }
}