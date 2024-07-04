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
                StringBuilder bitStringBuilder = new StringBuilder(bitLength);

                for (int queryIndex = 1, remainingBits = bitLength; queryIndex <= 150 && remainingBits > 0; queryIndex++) {
                    System.out.println(remainingBits);
                    String bit = scanner.nextLine();

                    if (queryIndex % 10 != 1) {
                        bitStringBuilder.append(bit);
                        remainingBits--;
                    }
                }

                System.out.println(bitStringBuilder.toString());
                System.out.flush();

                scanner.nextLine(); // Consume the newline character between cases
            }
        }
    }
}