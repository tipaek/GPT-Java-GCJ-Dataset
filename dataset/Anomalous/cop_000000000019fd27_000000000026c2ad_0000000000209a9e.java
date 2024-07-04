import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalLines = scanner.nextInt();
            int bufferSize = scanner.nextInt();
            scanner.nextLine();  // Consume the remaining newline

            for (int i = 0; i < totalLines; i++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                int linesToRead = bufferSize;
                for (int j = 1; j < 150 && linesToRead > 0; j++) {
                    if (j % 10 == 1) {
                        continue;  // Skip lines where j % 10 == 1
                    }
                    buffer.append(scanner.nextLine());
                    linesToRead--;
                }

                System.out.println(buffer);
                System.out.flush();

                // Consume the remaining newline
                scanner.nextLine();
            }
        }
    }
}