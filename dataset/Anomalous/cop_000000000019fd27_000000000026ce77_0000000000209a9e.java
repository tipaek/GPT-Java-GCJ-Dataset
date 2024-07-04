import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int bufferSize = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                for (int lineIndex = 1, remainingBuffer = bufferSize; lineIndex <= 150 && remainingBuffer > 0; lineIndex++) {
                    if (lineIndex % 10 == 1) {
                        continue;
                    }

                    System.out.println(remainingBuffer--);
                    buffer.append(scanner.nextLine());
                }

                System.out.println(buffer);
                System.out.flush();

                scanner.nextLine();  // Consume the newline character before the next case
            }
        }
    }
}