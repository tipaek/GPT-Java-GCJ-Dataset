import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalInputs = scanner.nextInt();
            int bufferSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < totalInputs; i++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                for (int remainingBits = bufferSize, iteration = 1; remainingBits > 0; iteration++) {
                    System.out.println(remainingBits);
                    String bit = scanner.nextLine();

                    if (iteration % 10 != 1) {
                        buffer.append(bit);
                        remainingBits--;
                    }
                }

                System.out.println(buffer);
                scanner.nextLine(); // Consume the newline character after printing the buffer
            }
        }
    }
}