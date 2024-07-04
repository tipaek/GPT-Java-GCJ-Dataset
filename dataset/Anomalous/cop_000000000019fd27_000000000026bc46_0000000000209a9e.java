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
                StringBuilder result = new StringBuilder(b);

                int remaining = b;
                for (int j = 1; j <= 150 && remaining > 0; j++) {
                    if (j % 10 != 1) {
                        result.append(scanner.nextInt());
                        remaining--;
                    }
                }

                System.out.println(result.toString());
                System.out.flush();
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }
}