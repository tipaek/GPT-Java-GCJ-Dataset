import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalTests = scanner.nextInt();
            int bitLength = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            for (int test = 0; test < totalTests; test++) {
                StringBuilder bitSequence = new StringBuilder(bitLength);

                for (int bitIndex = 0, queryCount = 1; bitIndex < bitLength; queryCount++) {
                    System.out.println(bitLength - bitIndex);
                    String bit = scanner.nextLine();

                    if (queryCount % 10 != 1) {
                        bitSequence.append(bit);
                        bitIndex++;
                    }
                }

                System.out.println(bitSequence.toString());
                String response = scanner.nextLine();

                if (!"Y".equalsIgnoreCase(response)) {
                    break;
                }
            }
        }
    }
}