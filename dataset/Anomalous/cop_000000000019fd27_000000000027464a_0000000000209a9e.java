import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int bitCount = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < totalCases; i++) {
                StringBuilder bitSequence = new StringBuilder(bitCount);

                for (int remainingBits = bitCount, iteration = 1; remainingBits > 0; iteration++) {
                    System.out.println(remainingBits);
                    String bit = scanner.nextLine();

                    if (iteration % 10 != 1) {
                        bitSequence.append(bit);
                        remainingBits--;
                    }
                }

                System.out.println(bitSequence.toString());
                String result = scanner.nextLine();
            }
        }
    }
}