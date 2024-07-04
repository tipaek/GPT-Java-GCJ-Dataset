import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < 2; i++) {
                StringBuilder buffer = new StringBuilder(b);

                for (int k = b, j = 1; k > 0; j++) {
                    System.out.println(k);
                    String bit = scanner.nextLine();

                    if (j % 10 != 1) {
                        buffer.append(bit);
                        k--;
                    }
                }

                System.out.println(buffer);
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}