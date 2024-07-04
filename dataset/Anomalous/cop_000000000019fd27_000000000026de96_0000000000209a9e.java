import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < total; i++) {
                StringBuilder buffer = new StringBuilder(b);
                int remainingBits = b;

                for (int j = 1; j <= 150 && remainingBits > 0; j++) {
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

                scanner.nextLine();
            }
        }
    }
}