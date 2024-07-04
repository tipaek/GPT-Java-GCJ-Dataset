import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            for (int i = 0; i < total; i++) {
                StringBuilder buffer = new StringBuilder(b);

                for (int j = 1, remainingBits = b; j <= 150 && remainingBits > 0; j++) {
                    System.out.println(remainingBits);
                    System.out.flush();
                    String bit = scanner.nextLine();

                    if (j % 10 != 1) {
                        buffer.append(bit);
                        remainingBits--;
                    }
                }

                System.out.println(buffer);
                System.out.flush();

                scanner.nextLine(); // Consume the remaining newline before the next iteration
            }
        }
    }
}