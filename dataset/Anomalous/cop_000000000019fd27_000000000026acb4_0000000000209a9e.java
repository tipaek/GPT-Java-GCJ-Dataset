import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scanner.nextInt();
            int b = scanner.nextInt();

            for (int i = 0; i < total; i++) {
                StringBuilder stringBuilder = new StringBuilder(b);

                for (int j = 1, remaining = b; j < 150 && remaining > 0; j++) {
                    if (j % 10 == 1) {
                        continue;
                    }
                    stringBuilder.append(scanner.nextInt());
                    remaining--;
                }

                System.out.println(stringBuilder.toString());
                scanner.nextLine(); // Consume the newline character
                String response = scanner.nextLine();

                if (!response.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
    }
}