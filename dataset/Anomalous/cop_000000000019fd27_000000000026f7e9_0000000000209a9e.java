import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalTests = scanner.nextInt();
            int bitLength = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            for (int testIndex = 0; testIndex < 2; testIndex++) {
                StringBuilder bitString = new StringBuilder(bitLength);

                for (int queryIndex = 1, bitCount = bitLength; queryIndex <= 150 && bitCount > 0; queryIndex++) {
                    System.out.println(bitCount);
                    System.out.flush();
                    String bit = scanner.nextLine();

                    if (queryIndex % 10 != 1) {
                        bitString.append(bit);
                        bitCount--;
                    }
                }

                System.out.println(bitString);
                System.out.flush();

                scanner.nextLine();  // Consume newline
            }
        }
    }
}