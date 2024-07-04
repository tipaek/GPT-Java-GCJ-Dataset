import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int bitLength = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
                StringBuilder bitString = new StringBuilder(bitLength);
                int bitsRemaining = bitLength;

                for (int queryCount = 1; bitsRemaining > 0; queryCount++) {
                    System.out.println(bitsRemaining);
                    String bit = scanner.nextLine();

                    if (queryCount % 10 != 1) {
                        bitString.append(bit);
                        bitsRemaining--;
                    }
                }

                System.out.println(bitString);
                String response = scanner.nextLine();

                if (!"Y".equalsIgnoreCase(response)) {
                    break;
                }
            }
        }
    }
}