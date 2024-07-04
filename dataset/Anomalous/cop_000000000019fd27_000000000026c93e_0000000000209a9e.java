import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalInputs = scanner.nextInt();
            int bufferSize = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after the integer inputs

            for (int i = 0; i < totalInputs; i++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                for (int j = 1, remainingLines = bufferSize; j < 150 && remainingLines > 0; j++) {
                    if (j % 10 == 1) {
                        continue;
                    }
                    buffer.append(scanner.nextLine());
                    remainingLines--;
                }

                System.out.println(buffer.toString());
                System.out.flush();

                if (i < totalInputs - 1) {
                    scanner.nextLine();  // Consume the newline character between different inputs
                }
            }
        }
    }
}