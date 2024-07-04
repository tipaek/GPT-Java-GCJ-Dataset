import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scanner.nextInt();
            int bufferSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0, sequenceNumber = 1; i < total; i++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                for (int k = 1, remainingBits = bufferSize; k <= 150 && remainingBits > 0; k++, sequenceNumber++) {
                    System.out.println(remainingBits);
                    String bit = scanner.nextLine();

                    if (sequenceNumber % 10 != 1) {
                        buffer.append(bit);
                        remainingBits--;
                    }
                }

                System.out.println(buffer.toString());
                System.out.flush();

                scanner.nextLine(); // Consume the newline character after printing the buffer
            }
        }
    }
}